package by.itsparnter.task.controllers;

import by.itsparnter.task.model.Room;
import by.itsparnter.task.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Room> add(@RequestBody Room room) {
        roomRepository.save(room);
        return roomRepository.findAll();
    }
}
