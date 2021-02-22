package com.courseapp.service;

import com.courseapp.controller.RegisterUserRequestDto;
import com.courseapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    //1. Metoda powinna zwrocic stworzony obiekt User na podstawie request.
    //2. Powinien poleciec wyjatek jesli login jest krotszy niz 8 znakow
    //3. Powinien poleciec wyjatek jesli haslo jest krotsze niz 10 znakow
    public User registerUser(RegisterUserRequestDto request) {

        final String login = request.getLogin();
        final String password = request.getPassword();

        if(login.length() < 8) {
            throw new ApplicationException("The login is too short");
        }

        if(password.length() < 10) {
            throw new ApplicationException("The password is too short");
        }

        return new User(login, password, request.getFirstname(), request.getLastname(), request.getPesel());

    }
}
