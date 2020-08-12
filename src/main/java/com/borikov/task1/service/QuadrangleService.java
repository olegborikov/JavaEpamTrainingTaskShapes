package com.borikov.task1.service;

import com.borikov.task1.entity.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class QuadrangleService {
    private static final int ROUND_NUMBER = 5;

    protected double calculateDistanceBetweenPoints(
            Point point1, Point point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        double distanceBetweenPoints = Math.hypot(distanceX, distanceY);
        return round(distanceBetweenPoints);
    }

    protected double calculateCosine(double side1, double side2, double side3) {
        double side1Squared = round(Math.pow(side1, 2));
        double side2Squared = round(Math.pow(side2, 2));
        double side3Squared = round(Math.pow(side3, 2));
        double cosine = (side1Squared + side2Squared - side3Squared) / (side1Squared * side2Squared * 2);
        return round(cosine);
    }

    protected double getSinusFromCosine(double cosine) {
        double cosineSquared = round(Math.pow(cosine, 2));
        double sinus = 1 - cosineSquared;
        return round(sinus);
    }

    protected double round(double number) {
        BigDecimal newNumber = BigDecimal.valueOf(number);
        BigDecimal roundedNumber = newNumber.setScale(ROUND_NUMBER, RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }
}
