package by.rymko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello_page";
    }

    @GetMapping("/time")
    public String currentTime(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "time_page";
    }
}
