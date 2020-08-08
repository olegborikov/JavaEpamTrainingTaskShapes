package com.borikov.task1.service;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

import static java.lang.Math.*;

public class QuadrangleService {
    public double getSquare(Quadrangle quadrangle) {
        double quadrangleSquare = 0;

        return quadrangleSquare;
    }

    public double getPerimeter(Quadrangle quadrangle) {
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
        return ((Double.compare(point1.getX(), point2.getX()) == 0
                && Double.compare(point1.getX(), point3.getX()) == 0)
                || (Double.compare(point1.getX(), point2.getX()) == 0
                && Double.compare(point1.getX(), point4.getX()) == 0)
                || (Double.compare(point1.getX(), point3.getX()) == 0
                && Double.compare(point1.getX(), point4.getX()) == 0)
                || (Double.compare(point2.getX(), point3.getX()) == 0
                && Double.compare(point2.getX(), point4.getX()) == 0))
                || ((Double.compare(point1.getY(), point2.getY()) == 0
                && Double.compare(point1.getY(), point3.getY()) == 0)
                || (Double.compare(point1.getY(), point2.getY()) == 0
                && Double.compare(point1.getY(), point4.getY()) == 0)
                || (Double.compare(point1.getY(), point3.getY()) == 0
                && Double.compare(point1.getY(), point4.getY()) == 0)
                || (Double.compare(point2.getY(), point3.getY()) == 0
                && Double.compare(point2.getY(), point4.getY()) == 0));
    }

    private double calculateDistanceBetweenPoints(
            Point firstPoint, Point secondPoint) {
        double distanceX = abs(firstPoint.getX() - secondPoint.getX());
        double distanceY = abs(firstPoint.getY() - secondPoint.getY());
        double distanceBetweenPoints = hypot(distanceX, distanceY);
        return distanceBetweenPoints;
    }
}
