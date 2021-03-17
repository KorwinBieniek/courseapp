package com.courseapp.controller;

public final class RegisterUserRequestDto {

    private final String login;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String pesel;

    public RegisterUserRequestDto(String login, String password, String firstname, String lastname, String pesel) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "RegisterUserRequestDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
