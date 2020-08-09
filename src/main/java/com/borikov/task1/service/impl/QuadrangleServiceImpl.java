package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.service.QuadrangleService;

import java.math.BigDecimal;

public class QuadrangleServiceImpl implements QuadrangleService {
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

        return sinus;
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
        BigDecimal distanceX = BigDecimal.valueOf(point1.getX() - point2.getX());
        BigDecimal distanceY = BigDecimal.valueOf(point1.getY() - point2.getY());
        BigDecimal distanceBetweenPoints = distanceX.pow(2).add(distanceY.pow(2));
        BigDecimal distanceBetweenPoints1 = BigDecimal.valueOf(Math.sqrt(distanceBetweenPoints.doubleValue()));
        return distanceBetweenPoints1.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
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
        BigDecimal s12 = s1.multiply(s1);
        BigDecimal s22 = s2.multiply(s2);
        BigDecimal s32 = s3.multiply(s3);
        BigDecimal first = s12.add(s22).subtract(s32).setScale(5, BigDecimal.ROUND_HALF_UP);
        BigDecimal second = s1.multiply(s1).multiply(new BigDecimal(2));
        System.out.println(first);
        System.out.println(second);
        return first.divide(second, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private double getSinusFromCosine(double cosine) {
        BigDecimal c = BigDecimal.valueOf(cosine);
        BigDecimal c1 = c.pow(2);
        BigDecimal sinus = new BigDecimal("1").subtract(c1);
        return sinus.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
