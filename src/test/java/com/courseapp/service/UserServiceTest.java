package com.courseapp.service;

import com.courseapp.controller.RegisterUserRequestDto;
import com.courseapp.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.courseapp.domain.UserAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void registerUserTest() {
        //given
        RegisterUserRequestDto request = new RegisterUserRequestDto("testLogin", "testPassword",
                "testFirstName", "testLastName", "99011496565");

        //when
        User user = userService.registerUser(request);

        //then
        assertThat(user).hasLogin("testLogin")
                .hasFirstname("testFirstName")
                .hasLastname("testLastName")
                .hasPesel("99011496565");
    }

    @Test
    void loginTooShortTest() {
        //given
        RegisterUserRequestDto request = new RegisterUserRequestDto("short", "testPassword",
                "testFirstName", "testSurname", "99011496565");

        //when & then
        assertThrows(
                ApplicationException.class,
                () -> userService.registerUser(request),
                "The login is too short"
        );
    }

    @Test
    void passwordTooShortTest() {
        //given
        RegisterUserRequestDto request = new RegisterUserRequestDto("testLogin", "short",
                "testFirstName", "testSurname", "99011496565");

        //when & then
        assertThrows(
                ApplicationException.class,
                () -> userService.registerUser(request),
                "The password is too short"
        );
    }
}