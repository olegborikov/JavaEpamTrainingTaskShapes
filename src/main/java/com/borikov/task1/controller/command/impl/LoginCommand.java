package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import com.borikov.task1.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        if (userService.isUserExists(login, password)) {
            page = PagePath.MAIN;
        } else {
            request.setAttribute(RequestParameter.ERROR_LOGIN_PASSWORD_MESSAGE, "Incorrect login or password");
            page = PagePath.LOGIN;
        }
        return page;
    }
}
