package com.borikov.task1.controller;

import com.borikov.task1.controller.command.Command;
import com.borikov.task1.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/quadrangle/*")
public class QuadrangleController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommandProvider commandProvider = new CommandProvider();
        Command command = commandProvider.defineCommand(request.getParameter("commandType"));
        command.execute(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
