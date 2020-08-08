package com.borikov.task1.validator;

public class PointValidator {
    private static final double MAX_VALUE = 1000;
    private static final double MIN_VALUE = -1000;

    public boolean isCoordinateInLimit(double coordinate) {
        return coordinate > MIN_VALUE && coordinate < MAX_VALUE;
    }
}
