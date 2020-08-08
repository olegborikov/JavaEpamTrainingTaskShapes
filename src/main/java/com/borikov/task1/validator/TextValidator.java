package com.borikov.task1.validator;

public class TextValidator {
    private static final String LINE_REGEX =
            "^(([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+) ){7}" +
                    "([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)$";

    public boolean isLineCorrect(String line) {
        return line.matches(LINE_REGEX);
    }
}
