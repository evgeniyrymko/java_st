package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.service.CountryDtoService;
import by.itsparnter.task.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;
    private CountryDtoService countryDtoService;

    @Autowired
    public RoomController(RoomService roomService, CountryDtoService countryDtoService) {
        this.roomService = roomService;
        this.countryDtoService = countryDtoService;
    }


    @GetMapping(value = "/all")
    public String getAllRoomsDto(Model model) {
        List<RoomDto> allRoomsDto = roomService.getAllRoomDto();
        model.addAttribute("allRoomsDto", allRoomsDto);
        return "roomsList";
    }

    @GetMapping(value = "/add")
    public String addRoomDtoForm(Model model) {
        model.addAttribute("allCountries", countryDtoService.getAllCountries());
        RoomDto roomDto = new RoomDto();
        model.addAttribute("roomDto", roomDto);
        return "addRoom";
    }

    @PostMapping(value = "/add")
    public String addRoomDto(@Valid @ModelAttribute("roomDto") RoomDto roomDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addRoom";
        } else {
            this.roomService.addRoom(roomDto);
        }
        return "redirect:/rooms/all";
    }


}
