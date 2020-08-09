package com.borikov.task1.validator;

public class QuadrangleValidator {
    private static final String LINE_REGEX =
            "^(([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+) ){7}" +
                    "([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)$";// TODO: 09.08.2020 change for ascii symbol

    public boolean isLineConformQuadrangle(String line) {
        boolean result = false;
        if (line != null) {
            result = line.matches(LINE_REGEX);
        }
        return result;
    }
}
