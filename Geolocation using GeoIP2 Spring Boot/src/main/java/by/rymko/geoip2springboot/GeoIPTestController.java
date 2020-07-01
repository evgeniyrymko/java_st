package by.rymko.geoip2springboot;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GeoIPTestController {
    private RawDBDemoGeoIPLocationService locationService;

    public GeoIPTestController() throws IOException {
        locationService = new RawDBDemoGeoIPLocationService();
    }

    @PostMapping("/GeoIPTest")
    public GeoIP getLocation(@RequestParam(value = "ipAddress", required = true) String ipAddress) throws IOException, GeoIp2Exception {
        return locationService.getLocation(ipAddress);
    }
}
