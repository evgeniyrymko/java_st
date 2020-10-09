package by.rymko.controller;

import by.rymko.dto.UserDto;
import by.rymko.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/users/{userId}")
    @ResponseBody
    public UserDto findById(@PathVariable("userId") int userId) {
        return userService.findById(userId);
    }

    @PostMapping(value = "/users")
    @ResponseBody
    public UserDto addUser(@RequestBody @Valid UserDto userDto) {
//        if (bindingResult.hasErrors()) return null;
        return userService.addUser(userDto);
    }
}
