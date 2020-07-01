package by.rymko.geoip2springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String startPage(){
        return "GeoIP";
    }
}
