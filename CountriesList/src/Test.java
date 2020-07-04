import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        List<CountryDto> allCountries = new ArrayList<>();
        String[] isoCountries = Locale.getISOCountries();
        for (String isoCountry : isoCountries) {
            Locale locale = new Locale("FR",isoCountry);
            String name = locale.getDisplayCountry();
            allCountries.add(new CountryDto(name));

        }
        for (CountryDto countryDto : allCountries) {
            System.out.println(countryDto.getName());

        }
    }
}
