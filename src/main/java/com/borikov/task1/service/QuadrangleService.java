package com.borikov.task1.service;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

import java.math.BigDecimal;

import static java.lang.Math.*;

public class QuadrangleService {
    public double calculateSquare(Quadrangle quadrangle) {
        double quadrangleSquare = 0;
        double side1 = calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint2());
        double side2 = calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint4());
        double side3 = calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint4());
        double cosine = calculateCosine(side1, side2, side3);
        double sinus = getSinusFromCosine(cosine);
        return cosine;
    }

    public double calculatePerimeter(Quadrangle quadrangle) {
        double quadranglePerimeter = 0;
        quadranglePerimeter += calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint2());
        quadranglePerimeter += calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint3());
        quadranglePerimeter += calculateDistanceBetweenPoints(
                quadrangle.getPoint3(), quadrangle.getPoint4());
        quadranglePerimeter += calculateDistanceBetweenPoints(
                quadrangle.getPoint4(), quadrangle.getPoint1());
        return quadranglePerimeter;
    }

    public boolean isPointsMakeQuadrangle(Point point1, Point point2, Point point3, Point point4) {
        return !(isPointsInLine(point1, point2, point3)
                || isPointsInLine(point1, point2, point4)
                || isPointsInLine(point1, point3, point4)
                || isPointsInLine(point2, point3, point4));
    }

    public boolean isQuadrangleConvex(Quadrangle quadrangle) {
        return false;
    }

    public boolean isQuadrangleSquare(Quadrangle quadrangle) {
        return false;
    }

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

    public boolean isQuadrangleTrapezoid(Quadrangle quadrangle) {
        return false;
    }

    private double calculateDistanceBetweenPoints(
            Point point1, Point point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        double distanceBetweenPoints = hypot(distanceX, distanceY);
        return distanceBetweenPoints;
    }

    private boolean isPointsInLine(Point point1, Point point2, Point point3) {
        return (point3.getX() - point1.getX())
                * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY())
                * (point2.getX() - point1.getX());
    }

    private double calculateCosine(double side1, double side2, double side3) {
        BigDecimal s1 = BigDecimal.valueOf(side1);
        BigDecimal s2 = BigDecimal.valueOf(side2);
        BigDecimal s3 = BigDecimal.valueOf(side3);

        BigDecimal cosine = ((((s1.pow(2)).add(s2.pow(2))).subtract(s3.pow(2))).divide(s1.subtract(s3).subtract(BigDecimal.valueOf(2))));
        return cosine.doubleValue();
    }

    private double getSinusFromCosine(double cosine) {
        double sinus = sqrt(pow(cosine, 2) - 1);
        return sinus;/
    }
}
