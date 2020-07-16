package by.itsparnter.task.controller;

import by.itsparnter.task.dto.RoomDto;
import by.itsparnter.task.service.CountryService;
import by.itsparnter.task.service.GeolocationService;
import by.itsparnter.task.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    private RoomService roomService;

    private GeolocationService geolocationService;


    @Autowired
    public RoomController(RoomService roomService, GeolocationService geolocationService) {
        this.roomService = roomService;
        this.geolocationService = geolocationService;
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
    public String roomById(@PathVariable("id") long id, Model model, HttpServletRequest request) {

//        Following piece of code represents definition of country name of current room and country name of user defined by his remote IP address.
//        As this application runs on localhost, it always returns value 0:0:0:0:0:0:0:1.
//        While using remote server it is possible to forbid user to enter room if his country name does not coincide country name of the room.
        String ipUser = request.getRemoteAddr();
        logger.info("IP address of remote user called /rooms/{id} is -> " + ipUser);
//        Here is the example to get country name. In remote server it's needed to apply ipUser as the parameter in defineCountryByIp() method.
        String countryUser = geolocationService.defineCountryByIp("95.31.18.119");
        logger.info("Country name of user defined by executing Geolocation service is -> " + countryUser);
        String countryRoom = roomService.getRoomDtoById(id).getCountryName();
        logger.info("Country name received from DB corresponding current room Id is -> " + countryRoom);

        RoomDto roomDtoById = roomService.getRoomDtoById(id);
        model.addAttribute("roomDtoById", roomDtoById);
        return "room";
    }


}
