package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import com.borikov.task1.warehouse.QuadrangleWarehouse;

import javax.servlet.http.HttpServletRequest;

public class AddQuadranglesWarehouseCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
       String quadrangles = request.getParameter(RequestParameter.QUADRANGLES);
        QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
       // System.out.println(quadrangles);
        return PagePath.LOGIN;
    }
}
