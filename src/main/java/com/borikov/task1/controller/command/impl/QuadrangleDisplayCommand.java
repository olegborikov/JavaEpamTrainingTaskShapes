package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import com.borikov.task1.creator.QuadrangleCreator;
import com.borikov.task1.entity.Quadrangle;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class QuadrangleDisplayCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Oleshka\\Desktop" +
            "\\JavaEpamTrainingTaskShapes\\src\\main\\webapp\\uploads";

    @Override
    public String execute(HttpServletRequest request) {
        String fileName = request.getParameter(RequestParameter.FILE_NAME);
        QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
        List<Quadrangle> quadrangles = quadrangleCreator.createQuadranglesFromFile(
                UPLOAD_DIRECTORY + File.separator + fileName);
        request.setAttribute(RequestParameter.QUADRANGLES, quadrangles);
        return PagePath.QUADRANGLE_DISPLAY;
    }
}
