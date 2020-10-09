package by.itsparnter.task.service;

import by.itsparnter.task.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class CountryService {

    public static List<CountryDto> allAvailableCountries;

    private CountryService() {
        getAvailableCountries();
    }

    private void getAvailableCountries() {
        allAvailableCountries = new ArrayList<>();
        String[] isoCountries = Locale.getISOCountries();
        for (String isoCountry : isoCountries) {
            Locale locale = new Locale("", isoCountry);
            String name = locale.getDisplayCountry(Locale.ENGLISH);
            allAvailableCountries.add(new CountryDto(name));
        }
        Collections.sort(allAvailableCountries);
    }


}
