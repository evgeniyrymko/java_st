package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.service.CountryService;
import by.itsparnter.task.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomController {

    private RoomService roomService;


    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/welcome")
    public String welcomePage() {
        return "index";
    }


    @GetMapping(value = "/rooms/all")
    public String getAllRoomsDto(Model model) {
        List<RoomDto> allRoomsDto = roomService.getAllRoomDto();
        model.addAttribute("allRoomsDto", allRoomsDto);
        return "roomsList";
    }

    @GetMapping(value = "/rooms/add")
    public String addRoomDtoForm(Model model) {
        model.addAttribute("allCountries", CountryService.allAvailableCountries);
        RoomDto roomDto = new RoomDto();
        model.addAttribute("roomDto", roomDto);
        return "addRoom";
    }

    @PostMapping(value = "/rooms/add")
    public String addRoomDto(@Valid @ModelAttribute("roomDto") RoomDto roomDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("allCountries", CountryService.allAvailableCountries);
            return "addRoom";
        } else {
            this.roomService.addRoom(roomDto);
        }
        return "redirect:/rooms/all";
    }

    @GetMapping(value = "/rooms/{id}")
    public String roomById(@PathVariable("id") long id, Model model) {
        RoomDto roomDtoById = roomService.getRoomDtoById(id);
        model.addAttribute("roomDtoById", roomDtoById);
        return "room";
    }


}
