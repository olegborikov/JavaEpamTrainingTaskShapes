package com.borikov.task1.parser;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleParser {
    private static final String LINE_DELIMITER = " ";

    public Quadrangle parseLineToQuadrangle(String line) {
        List<Double> numbers = new ArrayList<>();
        String[] numbersString = line.split(LINE_DELIMITER);
        for (String numberString : numbersString) {
            numbers.add(Double.parseDouble(numberString));
        }
        Point point1 = new Point(numbers.get(0), numbers.get(1));
        Point point2 = new Point(numbers.get(2), numbers.get(3));
        Point point3 = new Point(numbers.get(4), numbers.get(5));
        Point point4 = new Point(numbers.get(6), numbers.get(7));
        return new Quadrangle(point1, point2, point3, point4);
    }
}
