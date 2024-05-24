package com.funtikov.web.schedule.contoller;

import com.funtikov.web.schedule.dto.UserDto;
import com.funtikov.web.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegisterForm()    {
        return "register";
    }

    @PostMapping
    public String processRegistration(UserDto dto)  {
        return userService.saveUser(dto, "/login");
    }
}
