package com.borikov.task1.service;

import com.borikov.task1.entity.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class QuadrangleService {
    private static final int ROUNDING_NUMBERS_INTERMEDIATE_VALUE = 5;
    private static final int ROUNDING_NUMBERS_FINAL_VALUE = 2;

    protected double calculateDistanceBetweenPoints(
            Point point1, Point point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        double distanceBetweenPoints = Math.hypot(distanceX, distanceY);
        return roundIntermediateValue(distanceBetweenPoints);
    }

    protected double calculateCosine(double side1, double side2, double side3) {
        double side1Squared = roundIntermediateValue(Math.pow(side1, 2));
        double side2Squared = roundIntermediateValue(Math.pow(side2, 2));
        double side3Squared = roundIntermediateValue(Math.pow(side3, 2));
        double cosine = (side1Squared + side2Squared - side3Squared) / (side1 * side2 * 2);
        return roundIntermediateValue(cosine);
    }

    protected double getSinusFromCosine(double cosine) {
        double cosineSquared = roundIntermediateValue(Math.pow(cosine, 2));
        double sinus = 1 - cosineSquared;
        return roundIntermediateValue(sinus);
    }

    protected double roundIntermediateValue(double number) {
        if(Double.isInfinite(number) || Double.isNaN(number)){
            return number;
        }
        BigDecimal newNumber = BigDecimal.valueOf(number);
        BigDecimal roundedNumber = newNumber.setScale(ROUNDING_NUMBERS_INTERMEDIATE_VALUE, RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }

    protected double roundFinalValue(double number) {
        if(Double.isInfinite(number) || Double.isNaN(number)){
            return number;
        }
        BigDecimal newNumber = BigDecimal.valueOf(number);
        BigDecimal roundedNumber = newNumber.setScale(ROUNDING_NUMBERS_FINAL_VALUE, RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }
}
