package com.courseapp.controller;

import com.courseapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getUserId(), user.getLogin(), user.getFirstname(), user.getLastname(), user.getPesel());
    }
}
