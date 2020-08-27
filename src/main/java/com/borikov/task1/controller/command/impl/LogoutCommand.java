package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.LOGIN;
    }
}
