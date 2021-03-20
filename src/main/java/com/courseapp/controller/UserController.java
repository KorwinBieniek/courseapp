package com.courseapp.controller;

import com.courseapp.domain.User;
import com.courseapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/employees")
    public User testApi() {
        return new User("admin1", "admin2", "Mihail", "Surname", "12345678909");
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterUserRequestDto requestDto) {
       return userService.registerUser(requestDto);
    }


}
