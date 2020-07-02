package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllRoomsDto(Model model) {
        List<RoomDto> allRoomsDto = roomService.getAllRoomDto();
        model.addAttribute("allRoomsDto", allRoomsDto);
        return "roomsList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRoomDtoForm(Model model){
        RoomDto roomDto = new RoomDto();
        model.addAttribute("roomDto",roomDto);
        return "addRoom";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRoomDto(Model model, @ModelAttribute("roomDto") RoomDto roomDto){
        this.roomService.addRoom(roomDto);
        return "redirect:/rooms/all";
    }

}
