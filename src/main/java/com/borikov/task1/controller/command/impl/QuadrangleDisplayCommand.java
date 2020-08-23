package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.command.Command;
import com.borikov.task1.creator.QuadrangleCreator;
import com.borikov.task1.entity.Quadrangle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class QuadrangleDisplayCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Oleshka\\Desktop" +
            "\\JavaEpamTrainingTaskShapes\\src\\main\\webapp\\uploads";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
        List<Quadrangle> quadrangles = quadrangleCreator.createQuadranglesFromFile(UPLOAD_DIRECTORY + File.separator + fileName);
        request.setAttribute("quadrangles", quadrangles);
        request.getRequestDispatcher("/jsp/quadrangle_display.jsp").forward(request, response);
    }
}
