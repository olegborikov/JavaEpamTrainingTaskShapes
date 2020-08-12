package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleVerificationService;
import com.borikov.task1.validator.PointValidator;
import com.borikov.task1.validator.QuadrangleValidator;

public class QuadrangleVerificationServiceImpl extends QuadrangleVerificationService {
    @Override
    public boolean isPointsMakeQuadrangle(
            Point point1, Point point2, Point point3, Point point4)
            throws IncorrectDataException {
        PointValidator pointValidator = new PointValidator();
        if (pointValidator.isPointInLimit(point1)
                && pointValidator.isPointInLimit(point2)
                && pointValidator.isPointInLimit(point3)
                && pointValidator.isPointInLimit(point4)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        return !(isPointsInLine(point1, point2, point3)
                || isPointsInLine(point1, point2, point4)
                || isPointsInLine(point1, point3, point4)
                || isPointsInLine(point2, point3, point4));
    }

    @Override
    public boolean isQuadrangleConvex(Quadrangle quadrangle) throws IncorrectDataException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        Point point1 = quadrangle.getPoint1();
        Point point2 = quadrangle.getPoint2();
        Point point3 = quadrangle.getPoint3();
        Point point4 = quadrangle.getPoint4();
        return ((calculateVectorComposition(point1, point2, point4) > 0 && calculateVectorComposition(point3, point2, point4) < 0)
                || (calculateVectorComposition(point1, point2, point4) < 0 && calculateVectorComposition(point3, point2, point4) > 0))
                && ((calculateVectorComposition(point4, point1, point3) > 0 && calculateVectorComposition(point2, point1, point3) < 0)
                || (calculateVectorComposition(point4, point1, point3) < 0 && calculateVectorComposition(point2, point2, point3) > 0));
    }

    @Override
    public boolean isQuadrangleSquare(Quadrangle quadrangle) throws IncorrectDataException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        boolean result = false;
        if (isQuadrangleRhombus(quadrangle)) {
            double side1 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint1(), quadrangle.getPoint2());
            double side2 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint1(), quadrangle.getPoint4());
            double side3 = calculateDistanceBetweenPoints(
                    quadrangle.getPoint2(), quadrangle.getPoint4());
            result = calculateCosine(side1, side2, side3) == 0;
        }
        return result;
    }

    @Override
    public boolean isQuadrangleRhombus(Quadrangle quadrangle) throws IncorrectDataException {
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
        return side1 == side2 && side1 == side3 && side1 == side4;
    }

    @Override
    public boolean isQuadrangleTrapezoid(Quadrangle quadrangle) throws IncorrectDataException {
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        if (!quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
            throw new IncorrectDataException("Data is incorrect");
        }
        Point point1 = quadrangle.getPoint1();
        Point point2 = quadrangle.getPoint2();
        Point point3 = quadrangle.getPoint3();
        Point point4 = quadrangle.getPoint4();
        return (isLinesParallelByPoints(point1, point4, point2, point3) && !isLinesParallelByPoints(point1, point2, point4, point3))
                || (isLinesParallelByPoints(point1, point2, point4, point3) && !isLinesParallelByPoints(point1, point4, point2, point3));
    }

    private boolean isPointsInLine(Point point1, Point point2, Point point3) {
        return (point3.getX() - point1.getX())
                * (point2.getY() - point1.getY())
                == (point3.getY() - point1.getY())
                * (point2.getX() - point1.getX());
    }

    private boolean isLinesParallelByPoints(Point point1Line1, Point point2Line1, Point point1Line2, Point point2Line2) {
        double angleCoefficientPoint1 = (point2Line1.getY() - point1Line1.getY()) / (point2Line1.getX() - point1Line1.getX());
        double angleCoefficientPoint2 = (point2Line2.getY() - point1Line2.getY()) / (point2Line2.getX() - point1Line2.getX());
        return angleCoefficientPoint1 == angleCoefficientPoint2;
    }


    private double calculateVectorComposition(Point point1, Point point2, Point point3) {
        return ((point1.getX() - point2.getX())) * (point3.getY() - point2.getY()) - ((point3.getX() - point2.getX()) * (point1.getY() - point2.getY()));
    }
}
