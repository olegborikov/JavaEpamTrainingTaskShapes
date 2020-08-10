package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.service.QuadrangleVerificationService;

import java.math.BigDecimal;

public class QuadrangleVerificationServiceImpl implements QuadrangleVerificationService {
    @Override
    public boolean isPointsMakeQuadrangle(Point point1, Point point2, Point point3, Point point4) {
        return !(isPointsInLine(point1, point2, point3)
                || isPointsInLine(point1, point2, point4)
                || isPointsInLine(point1, point3, point4)
                || isPointsInLine(point2, point3, point4));
    }

    @Override
    public boolean isQuadrangleConvex(Quadrangle quadrangle) {
        return false;
    }

    @Override
    public boolean isQuadrangleSquare(Quadrangle quadrangle) {
        boolean result = false;
        if (isQuadrangleRhombus(quadrangle)) {
            double side1 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint1(), quadrangle.getPoint2());
            double side2 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint1(), quadrangle.getPoint4());
            double side3 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint2(), quadrangle.getPoint4());
            result = calculateCosine(side1, side2, side3) == 1;
        }
        return result;
    }

    @Override
    public boolean isQuadrangleRhombus(Quadrangle quadrangle) {
        double side1 = calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint2());
        double side2 = calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint3());
        double side3 = calculateDistanceBetweenPoints(
                quadrangle.getPoint3(), quadrangle.getPoint4());
        double side4 = calculateDistanceBetweenPoints(
                quadrangle.getPoint4(), quadrangle.getPoint1());
        return side1 == side2 && side1 == side3 && side1 == side4;
    }

    @Override
    public boolean isQuadrangleTrapezoid(Quadrangle quadrangle) {
        return false;
    }

    private boolean isPointsInLine(Point point1, Point point2, Point point3) {
        return (point3.getX() - point1.getX())
                * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY())
                * (point2.getX() - point1.getX());
    }
}
