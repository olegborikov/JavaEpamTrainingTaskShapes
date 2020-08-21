package com.borikov.task1.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@WebServlet(urlPatterns = "/controller")
public class QuadrangleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date time = Calendar.getInstance().getTime();
        request.setAttribute("time", time);
        request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
    }
}
