package com.borikov.task1.service;

import com.borikov.task1.entity.Point;

import java.math.BigDecimal;

public abstract class QuadrangleService {
    protected double calculateDistanceBetweenPoints(
            Point point1, Point point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        double distanceBetweenPoints = Math.hypot(distanceX, distanceY);// TODO: 10.08.2020 refactor: round
        return distanceBetweenPoints;
    }

    protected double calculateCosine(double side1, double side2, double side3) {// TODO: 10.08.2020 refactor
        BigDecimal s1 = BigDecimal.valueOf(side1);
        BigDecimal s2 = BigDecimal.valueOf(side2);
        BigDecimal s3 = BigDecimal.valueOf(side3);
        BigDecimal s12 = s1.multiply(s1);
        BigDecimal s22 = s2.multiply(s2);
        BigDecimal s32 = s3.multiply(s3);
        BigDecimal first = s12.add(s22).subtract(s32).setScale(5, BigDecimal.ROUND_HALF_UP);
        BigDecimal second = s1.multiply(s1).multiply(new BigDecimal(2));
        return first.divide(second, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    protected double getSinusFromCosine(double cosine) {// TODO: 10.08.2020 refactor
        BigDecimal c = BigDecimal.valueOf(cosine);
        BigDecimal c1 = c.pow(2);
        BigDecimal sinus = new BigDecimal("1").subtract(c1);
        return sinus.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
