package com.courseapp.service;

import com.courseapp.controller.RegisterUserRequestDto;
import com.courseapp.domain.User;
import com.courseapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegisterUserRequestDto request) {
        final String login = request.getLogin();
        final String password = request.getPassword();

        if(login.length() < 8) {
            throw new ApplicationException("The login is too short");
        }

        if(password.length() < 10) {
            throw new ApplicationException("The password is too short");
        }

        User user = new User(login, password, request.getFirstname(), request.getLastname(), request.getPesel());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        Iterable<User> result = userRepository.findAll();
        return StreamSupport.stream(result.spliterator(), false)
                .collect(Collectors.toList());
    }
}
