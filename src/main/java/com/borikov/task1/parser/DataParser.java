package com.borikov.task1.parser;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String LINE_DELIMITER = " ";// TODO: 09.08.2020 change for ascii symbol

    public List<Double> parseLineToNumberList(String quadrangleLine) {
        List<Double> numbers = new ArrayList<>();
        String[] numbersString = quadrangleLine.split(LINE_DELIMITER);
        for (String numberString : numbersString) {
            numbers.add(Double.parseDouble(numberString));
        }
        return numbers;
    }
}
