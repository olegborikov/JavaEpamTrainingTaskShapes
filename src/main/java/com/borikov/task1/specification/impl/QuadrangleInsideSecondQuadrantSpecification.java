package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.Specification;

public class QuadrangleInsideSecondQuadrantSpecification implements Specification {
    private static final double MIN_COORDINATE = 0;

    @Override
    public boolean test(Quadrangle quadrangle) {
        Point point1 = quadrangle.getPoint1();
        Point point2 = quadrangle.getPoint2();
        Point point3 = quadrangle.getPoint3();
        Point point4 = quadrangle.getPoint4();
        return point1.getX() <= MIN_COORDINATE && point1.getY() >= MIN_COORDINATE
                && point2.getX() <= MIN_COORDINATE && point2.getY() >= MIN_COORDINATE
                && point3.getX() <= MIN_COORDINATE && point3.getY() >= MIN_COORDINATE
                && point4.getX() <= MIN_COORDINATE && point4.getY() >= MIN_COORDINATE;
    }
}
