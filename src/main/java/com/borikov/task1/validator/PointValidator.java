package com.borikov.task1.validator;

import com.borikov.task1.entity.Point;

public class PointValidator {
    private static final double MAX_VALUE = 1000;
    private static final double MIN_VALUE = -1000;

    public boolean isPointInLimit(Point point) {
        return isCoordinateInLimit(point.getX())
                && isCoordinateInLimit(point.getY());
    }

    public boolean isCoordinateInLimit(double coordinate) {
        return coordinate > MIN_VALUE && coordinate < MAX_VALUE;
    }
}
