package by.resliv.task.cityguide.service;

import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.model.CityDescription;
import by.resliv.task.cityguide.repository.CityDescriptionRepository;
import by.resliv.task.cityguide.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "cityguide-api.dbseeder", havingValue = "true")
public class DatabaseSeeder implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSeeder.class);

    private CityRepository cityRepository;

    private CityDescriptionRepository cityDescriptionRepository;

    @Autowired
    public DatabaseSeeder(CityRepository cityRepository, CityDescriptionRepository cityDescriptionRepository) {
        this.cityRepository = cityRepository;
        this.cityDescriptionRepository = cityDescriptionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        CityDescription moscowDescription = new CityDescription("Visit Red Square");
        cityDescriptionRepository.save(moscowDescription);
        City moscowCity = new City("Moscow", moscowDescription);
        cityRepository.save(moscowCity);

        CityDescription minskDescription = new CityDescription("Visit National Library");
        cityDescriptionRepository.save(minskDescription);
        City minskCity = new City("Minsk", minskDescription);
        cityRepository.save(minskCity);

        LOGGER.info("Database Seeder successfully executed.");
    }
}
