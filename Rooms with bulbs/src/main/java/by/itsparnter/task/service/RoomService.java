package by.itsparnter.task.service;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.mapper.RoomMapper;
import by.itsparnter.task.model.Room;
import by.itsparnter.task.repository.BulbRepository;
import by.itsparnter.task.repository.CountryRepository;
import by.itsparnter.task.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private BulbRepository bulbRepository;
    private CountryRepository countryRepository;
    private RoomRepository roomRepository;
    private RoomMapper roomMapper;

    @Autowired
    public RoomService(BulbRepository bulbRepository, CountryRepository countryRepository, RoomRepository roomRepository, RoomMapper roomMapper) {
        this.bulbRepository = bulbRepository;
        this.countryRepository = countryRepository;
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<RoomDto> getAllRoomDto() {
        List<Room> allRooms = this.roomRepository.findAll();
        List<RoomDto> allRoomsDto = allRooms.stream()
                .map(room -> this.roomMapper.mapToRoomDto(room))
                .collect(Collectors.toList());
        return allRoomsDto;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRoom(RoomDto roomDto) {
        Room room = this.roomMapper.mapToRoom(roomDto);
        bulbRepository.save(room.getBulb());
        countryRepository.save(room.getCountry());
        roomRepository.save(room);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public RoomDto getRoomDtoById(long id) {
        Room room = roomRepository.findById(id).get();
        RoomDto roomDto = roomMapper.mapToRoomDto(room);
        return roomDto;
    }
}
