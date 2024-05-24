package com.funtikov.web.schedule.mapper;

import com.funtikov.web.schedule.dto.UserDto;
import com.funtikov.web.schedule.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
