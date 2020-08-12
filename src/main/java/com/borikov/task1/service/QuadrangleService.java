package com.borikov.task1.service;

import com.borikov.task1.entity.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class QuadrangleService {
    private static final int ROUNDING_NUMBERS_INTERMEDIATE_VALUE = 5;
    private static final int ROUNDING_NUMBERS_FINAL_VALUE = 2;

    protected double calculateDistanceBetweenPoints(
            Point firstPoint, Point secondPoint) {
        double distanceX = firstPoint.getX() - secondPoint.getX();
        double distanceY = firstPoint.getY() - secondPoint.getY();
        double distanceBetweenPoints = Math.hypot(distanceX, distanceY);
        return roundIntermediateValue(distanceBetweenPoints);
    }

    protected double calculateCosineBySides(
            double leftSide, double rightSide, double oppositeSide) {
        double leftSideSquared = roundIntermediateValue(Math.pow(leftSide, 2));
        double rightSideSquared = roundIntermediateValue(Math.pow(rightSide, 2));
        double oppositeSideSquared = roundIntermediateValue(Math.pow(oppositeSide, 2));
        double cosine = (leftSideSquared + rightSideSquared - oppositeSideSquared)
                / (leftSide * rightSide * 2);
        return roundIntermediateValue(cosine);
    }

    protected double roundIntermediateValue(double number) {
        if (Double.isInfinite(number) || Double.isNaN(number)) {
            return number;
        }
        BigDecimal newNumber = BigDecimal.valueOf(number);
        BigDecimal roundedNumber = newNumber.setScale(ROUNDING_NUMBERS_INTERMEDIATE_VALUE,
                RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }

    protected double roundFinalValue(double number) {
        if (Double.isInfinite(number) || Double.isNaN(number)) {
            return number;
        }
        BigDecimal newNumber = BigDecimal.valueOf(number);
        BigDecimal roundedNumber = newNumber.setScale(ROUNDING_NUMBERS_FINAL_VALUE,
                RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }
}
