package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.validator.QuadrangleValidator;

public class QuadrangleArithmeticServiceImpl extends QuadrangleArithmeticService {
    @Override
    public double calculateSquare(Quadrangle quadrangle) throws IncorrectDataException {// TODO: 10.08.2020 refactor
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
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
    public double calculatePerimeter(Quadrangle quadrangle)
            throws IncorrectDataException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        double side1 = calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint2());
        double side2 = calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint3());
        double side3 = calculateDistanceBetweenPoints(
                quadrangle.getPoint3(), quadrangle.getPoint4());
        double side4 = calculateDistanceBetweenPoints(
                quadrangle.getPoint4(), quadrangle.getPoint1());
        return side1 + side2 + side3 + side4;
    }
}
