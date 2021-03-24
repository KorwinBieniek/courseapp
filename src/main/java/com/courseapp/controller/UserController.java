package com.courseapp.controller;

import com.courseapp.domain.User;
import com.courseapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        User user = userService.findById(id);
        return userMapper.toDto(user);
    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody RegisterUserRequestDto requestDto) {
        final User user = userService.registerUser(requestDto);
        return userMapper.toDto(user);
    }


}
