package com.courseapp.service;

import com.courseapp.controller.RegisterUserRequestDto;
import com.courseapp.domain.User;
import com.courseapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static com.courseapp.domain.UserAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void registerUserTest() {
        //given
        RegisterUserRequestDto request = new RegisterUserRequestDto("testLogin", "testPassword",
                "testFirstName", "testLastName", "99011496565");
        User user = new User("testLogin", "testPassword", "testFirstName", "testLastName", "99011496565");
        when(userRepository.save(any())).thenReturn(user);

        //when
        User result = userService.registerUser(request);

        //then
        verify(userRepository).save(any());
        assertThat(result).hasLogin("testLogin")
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

    @Test
    void findAllTest() {
        //given
        List<User> users = Arrays.asList(
                new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", "99011496565"),
                new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", "99011496566"),
                new User("testLogin3", "testPassword3", "testFirstName3", "testLastName3", "99011496566")
        );
        when(userRepository.findAll()).thenReturn(users);

        //when
        List<User> result = userService.findAll();

        //then
        verify(userRepository).findAll();
        assertThat(result.size()).isEqualTo(3);
    }
}