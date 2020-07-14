package by.itsparnter.task.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Service
public class GeolocationService {

    private static final Logger logger = LoggerFactory.getLogger(GeolocationService.class);

    private static final String DB_LOCATION = "src/main/resources/geoip/GeoLite2-Country.mmdb";

    public static String defineCountryByIp(String ip) {
        String countryName = StringUtils.EMPTY;

        File db = new File(DB_LOCATION);

        try (DatabaseReader dbReader = new DatabaseReader.Builder(db).build()) {
            InetAddress ipAddress = InetAddress.getByName(ip);
            logger.info(ipAddress.toString());
            CountryResponse countryResponse = dbReader.country(ipAddress);
            countryName = countryResponse.getCountry().getName();
            logger.info(countryName);
        } catch (IOException e) {
            logger.error("IOException has been caught.", e);
        } catch (GeoIp2Exception e) {
            logger.error("GeoIp2Exception has been caught.", e);
        }
        return countryName;
    }
}
