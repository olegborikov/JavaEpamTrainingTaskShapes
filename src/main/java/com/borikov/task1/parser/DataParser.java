package com.borikov.task1.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String LINE_DELIMITER = "\u0020";

    public List<Double> parseLineToNumberList(String line) {
        List<Double> numbers = new ArrayList<>();
        if (line != null) {
            String[] numbersString = line.split(LINE_DELIMITER);
            for (String numberString : numbersString) {
                numbers.add(Double.parseDouble(numberString));
            }
        }
        return numbers;
    }
}
