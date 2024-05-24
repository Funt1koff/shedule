package com.funtikov.web.schedule.contoller;

import com.funtikov.web.schedule.domain.DateManager;
import com.funtikov.web.schedule.domain.Day;
import com.funtikov.web.schedule.dto.UserDto;
import com.funtikov.web.schedule.mapper.UserMapper;
import com.funtikov.web.schedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/schedule5")
public class ScheduleController_5 {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String getPage() {
        return "schedule5";
    }

    @ModelAttribute(name = "user")
    public UserDto getCurrentUser(Principal principal, Model model) {
        com.funtikov.web.schedule.entity.User currUser = userRepository.findByUsername(principal.getName());
        return userMapper.toDto(currUser);
    }

    @ModelAttribute
    public void addDates(Model model)   {
        List<Day> days = DateManager.getCurrentWeek();

        for(int i = 0; i < days.size(); i++)
            model.addAttribute("day"+i,days.get(i));
    }
}
