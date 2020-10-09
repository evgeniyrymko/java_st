package by.itsparnter.task.service;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.mapper.RoomMapper;
import by.itsparnter.task.model.Bulb;
import by.itsparnter.task.model.Room;
import by.itsparnter.task.repository.BulbRepository;
import by.itsparnter.task.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulbService {

    private final RoomRepository roomRepository;

    private final BulbRepository bulbRepository;

    private final RoomMapper roomMapper;

    public BulbService(RoomRepository roomRepository, BulbRepository bulbRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.bulbRepository = bulbRepository;
        this.roomMapper = roomMapper;
    }


    public RoomDto switchBulbInTheRoom(RoomDto roomDtoReceived) {

        Room roomReceivedById = roomRepository.findById(roomDtoReceived.getId()).get();
        Bulb bulbReceivedById = bulbRepository.findById(roomReceivedById.getBulb().getId()).get();
        bulbReceivedById.setTurnedOn(!roomDtoReceived.isBulbTurnedOn());

        bulbRepository.save(bulbReceivedById);

        Room roomToSendById = roomRepository.findById(roomDtoReceived.getId()).get();
        RoomDto roomDtoSent = roomMapper.mapToRoomDto(roomToSendById);

        return roomDtoSent;
    }
}
