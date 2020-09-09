package by.rymko.controller;

import by.rymko.dto.UserDto;
import by.rymko.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    @ResponseBody
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}
