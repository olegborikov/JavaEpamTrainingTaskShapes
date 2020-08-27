package com.borikov.task1.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface Command {
    String execute(HttpServletRequest request) throws IOException, ServletException;
}
