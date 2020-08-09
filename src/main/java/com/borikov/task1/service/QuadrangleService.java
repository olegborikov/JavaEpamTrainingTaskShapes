package com.borikov.task1.service;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Math.*;

public interface QuadrangleService {
    public double calculateSquare(Quadrangle quadrangle);

    public double calculatePerimeter(Quadrangle quadrangle);

    public boolean isPointsMakeQuadrangle(Point point1, Point point2, Point point3, Point point4);

    public boolean isQuadrangleConvex(Quadrangle quadrangle);

    public boolean isQuadrangleSquare(Quadrangle quadrangle);

    public boolean isQuadrangleRhombus(Quadrangle quadrangle);

    public boolean isQuadrangleTrapezoid(Quadrangle quadrangle);
}
