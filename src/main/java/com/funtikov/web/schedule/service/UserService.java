package com.funtikov.web.schedule.service;

import com.funtikov.web.schedule.dto.UserDto;
import com.funtikov.web.schedule.entity.User;
import com.funtikov.web.schedule.mapper.UserMapper;
import com.funtikov.web.schedule.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    public String saveUser(UserDto dto, String redirect)    {

        dto.setPassword(encoder.encode(dto.getPassword()));
        User user = userMapper.toEntity(dto);
        userRepository.save(user);
        log.info("SuccessRegistration user: {}", user);

        return "redirect:" + redirect;
    }
}
