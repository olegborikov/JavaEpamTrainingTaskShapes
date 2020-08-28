package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.repository.QuadrangleRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RepositoryDisplayCommand implements Command {
    private final QuadrangleRepository quadrangleRepository = QuadrangleRepository.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        List<Quadrangle> quadrangles = quadrangleRepository.getAll();
        request.setAttribute(RequestParameter.QUADRANGLES, quadrangles);
        return PagePath.REPOSITORY_DISPLAY;
    }
}
