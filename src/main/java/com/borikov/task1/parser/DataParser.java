package com.borikov.task1.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String LINE_DELIMITER = "\u0020";

    public List<Double> parseLineToNumberList(String quadrangleLine) {
        List<Double> numbers = new ArrayList<>();
        String[] numbersString = quadrangleLine.split(LINE_DELIMITER);
        for (String numberString : numbersString) {
            numbers.add(Double.parseDouble(numberString));
        }
        return numbers;
    }
}
