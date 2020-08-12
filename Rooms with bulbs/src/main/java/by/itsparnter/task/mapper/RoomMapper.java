package by.itsparnter.task.mapper;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.model.Bulb;
import by.itsparnter.task.model.Country;
import by.itsparnter.task.model.Room;
import by.itsparnter.task.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoomMapper {

    private final CountryRepository countryRepository;

    public RoomMapper(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Room mapToRoom(RoomDto roomDto) {
        Bulb bulb = new Bulb(roomDto.isBulbTurnedOn());
        Country country;

        Optional<Country> optionalCountry = countryRepository.findByName(roomDto.getCountryName());
        if (optionalCountry.isPresent()) {
            country = optionalCountry.get();
        } else {
            country = new Country(roomDto.getCountryName());
        }
        Room entity = new Room(roomDto.getName(), country, bulb);

        return entity;
    }

    public RoomDto mapToRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setName(room.getName());
        roomDto.setCountryName(room.getCountry().getName());
        roomDto.setBulbTurnedOn(room.getBulb().isTurnedOn());
        return roomDto;
    }

}
