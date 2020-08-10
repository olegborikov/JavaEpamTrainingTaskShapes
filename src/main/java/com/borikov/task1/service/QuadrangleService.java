package com.borikov.task1.service;

import com.borikov.task1.entity.Point;

import java.math.BigDecimal;

public interface QuadrangleService {
    default double calculateDistanceBetweenPoints(
            Point point1, Point point2) {
        BigDecimal distanceX = BigDecimal.valueOf(point1.getX() - point2.getX());
        BigDecimal distanceY = BigDecimal.valueOf(point1.getY() - point2.getY());
        BigDecimal distanceBetweenPoints = distanceX.pow(2).add(distanceY.pow(2));
        BigDecimal distanceBetweenPoints1 = BigDecimal.valueOf(Math.sqrt(distanceBetweenPoints.doubleValue()));
        return distanceBetweenPoints1.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    default double calculateCosine(double side1, double side2, double side3) {
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

    default double getSinusFromCosine(double cosine) {
        BigDecimal c = BigDecimal.valueOf(cosine);
        BigDecimal c1 = c.pow(2);
        BigDecimal sinus = new BigDecimal("1").subtract(c1);
        return sinus.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
