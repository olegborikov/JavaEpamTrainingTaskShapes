package com.borikov.task1.service;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;

public abstract class QuadrangleVerificationService extends QuadrangleService {
    public abstract boolean isPointsMakeQuadrangle(
            Point point1, Point point2, Point point3, Point point4)
            throws IncorrectDataException;

    public abstract boolean isQuadrangleConvex(Quadrangle quadrangle)
            throws IncorrectDataException;

    public abstract boolean isQuadrangleSquare(Quadrangle quadrangle)
            throws IncorrectDataException;

    public abstract boolean isQuadrangleRhombus(Quadrangle quadrangle)
            throws IncorrectDataException;

    public abstract boolean isQuadrangleTrapezoid(Quadrangle quadrangle)
            throws IncorrectDataException;
}
