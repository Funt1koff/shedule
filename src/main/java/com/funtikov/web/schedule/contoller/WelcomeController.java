package com.funtikov.web.schedule.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String showWelcomeForm() {
        return "index";
    }

    @GetMapping("/index")
    public String showAnotherWelcomeForm()  {
        return "index";
    }
}
