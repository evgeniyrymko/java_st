package com.itvdn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by Asus on 28.03.2018.
 */

@Controller
public class Home {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

}
