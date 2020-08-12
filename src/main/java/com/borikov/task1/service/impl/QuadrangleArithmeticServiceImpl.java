package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.validator.QuadrangleValidator;

public class QuadrangleArithmeticServiceImpl extends QuadrangleArithmeticService {

    @Override
    public double calculateSquare(Quadrangle quadrangle) throws IncorrectDataException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        double diagonal = calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint4());
        double side1 = calculateDistanceBetweenPoints(
                quadrangle.getPoint1(), quadrangle.getPoint2());
        double side2 = calculateDistanceBetweenPoints(
                quadrangle.getPoint2(), quadrangle.getPoint3());
        double side3 = calculateDistanceBetweenPoints(
                quadrangle.getPoint3(), quadrangle.getPoint4());
        double side4 = calculateDistanceBetweenPoints(
                quadrangle.getPoint4(), quadrangle.getPoint1());
        double cosineFirst = calculateCosine(side1, side4, diagonal);
        double cosineSecond = calculateCosine(side2, side3, diagonal);
        double angle = roundIntermediateValue(Math.acos(cosineFirst) + Math.acos(cosineSecond));
        double perimeterHalf = (side1 + side2 + side3 + side4) / 2;
        double quadrangleSquare = Math.sqrt((((perimeterHalf - side1) *
                (perimeterHalf - side2) * (perimeterHalf - side3) *
                (perimeterHalf - side4)) - roundIntermediateValue(side1 * side2 * side3 * side4 * Math.pow(Math.cos(angle / 2),2))));
        return roundFinalValue(quadrangleSquare);
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
        double quadranglePerimeter = side1 + side2 + side3 + side4;
        return roundFinalValue(quadranglePerimeter);
    }
}
