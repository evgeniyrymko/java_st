package by.itsparnter.task.service;

import by.itsparnter.task.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CountryDtoService {
    final List<CountryDto> allCountries = new ArrayList<>();

    public List<CountryDto> getAllCountries(){
        String[] isoCountries = Locale.getISOCountries();
        for (String isoCountry :isoCountries) {
            Locale locale = new Locale("en",isoCountry);
            String name = locale.getDisplayCountry();
            allCountries.add(new CountryDto(name));
        }
        return allCountries;
    }


}
