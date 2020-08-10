package com.borikov.task1.service;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

public interface QuadrangleVerificationService extends QuadrangleService {
    public boolean isPointsMakeQuadrangle(Point point1, Point point2, Point point3, Point point4);

    public boolean isQuadrangleConvex(Quadrangle quadrangle);

    public boolean isQuadrangleSquare(Quadrangle quadrangle);

    public boolean isQuadrangleRhombus(Quadrangle quadrangle);

    public boolean isQuadrangleTrapezoid(Quadrangle quadrangle);
}
