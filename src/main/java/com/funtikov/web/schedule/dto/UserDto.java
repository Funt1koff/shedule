package com.funtikov.web.schedule.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String surName;
    private String universityName;
    private String groupCode;

}
