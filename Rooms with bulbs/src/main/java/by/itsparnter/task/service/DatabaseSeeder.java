package by.itsparnter.task.service;

import by.itsparnter.task.configuration.WebSocketEventListener;
import by.itsparnter.task.model.Bulb;
import by.itsparnter.task.model.Country;
import by.itsparnter.task.model.Room;
import by.itsparnter.task.repository.BulbRepository;
import by.itsparnter.task.repository.CountryRepository;
import by.itsparnter.task.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "application.db.databaseseeder", havingValue = "true")
public class DatabaseSeeder implements CommandLineRunner {

    private RoomRepository roomRepository;
    private CountryRepository countryRepository;
    private BulbRepository bulbRepository;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    public DatabaseSeeder(RoomRepository roomRepository, CountryRepository countryRepository, BulbRepository bulbRepository) {
        this.roomRepository = roomRepository;
        this.countryRepository = countryRepository;
        this.bulbRepository = bulbRepository;
    }

    @Override
    public void run(String... args) {

        Bulb bulb1 = new Bulb(true);
        bulbRepository.save(bulb1);
        Country country1 = new Country("Belarus");
        countryRepository.save(country1);
        Room room1 = new Room("room1", country1, bulb1);
        roomRepository.save(room1);

        Bulb bulb2 = new Bulb(false);
        bulbRepository.save(bulb2);
        Country country2 = new Country("Poland");
        countryRepository.save(country2);
        Room room2 = new Room("room2", country2, bulb2);
        roomRepository.save(room2);

        Bulb bulb3 = new Bulb(true);
        bulbRepository.save(bulb3);
        Room room3 = new Room("room3mix", country1, bulb3);
        roomRepository.save(room3);

        logger.info("DatabaseSeeder is successfully executed.");

    }
}
