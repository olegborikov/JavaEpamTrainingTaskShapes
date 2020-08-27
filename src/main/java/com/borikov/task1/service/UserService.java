package com.borikov.task1.service;

public class UserService {
    public static final String DEFAULT_LOGIN = "admin";
    public static final String DEFAULT_PASSWORD = "12345678";

    public boolean isUserExists(String login, String password) {
        return login.equals(DEFAULT_LOGIN) && password.equals(DEFAULT_PASSWORD);
    }
}
