package com.courseapp.controller;

public class UserDto {

    private Long userId;
    private String login;
    private String firstname;
    private String lastname;
    private String pesel;

    public UserDto() {
    }

    public UserDto(Long userId, String login, String firstname, String lastname, String pesel) {
        this.userId = userId;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
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
}
