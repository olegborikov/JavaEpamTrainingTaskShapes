package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.service.QuadrangleArithmeticService;

public class QuadrangleArithmeticServiceImpl implements QuadrangleArithmeticService {
    @Override
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

    @Override
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

}
