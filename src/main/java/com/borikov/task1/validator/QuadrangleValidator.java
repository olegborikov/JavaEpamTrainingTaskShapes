package com.borikov.task1.validator;

public class QuadrangleValidator {
    private static final String LINE_REGEX =
            "^(([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)\u0020){7}" +
                    "([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)$";

    public boolean isLineConformQuadrangle(String line) {
        boolean result = false;
        if (line != null) {
            result = line.matches(LINE_REGEX);
        }
        return result;
    }
}
