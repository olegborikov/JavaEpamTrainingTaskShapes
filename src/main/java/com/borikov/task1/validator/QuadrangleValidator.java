package com.borikov.task1.validator;

import com.borikov.task1.entity.Quadrangle;

public class QuadrangleValidator {
    private static final String LINE_REGEX =
            "^(-?([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)\u0020){7}" +
                    "-?([\\d]+\\.[\\d]+|[\\d]+\\.?|\\.[\\d]+)$";

    public boolean isLineConformQuadrangle(String line) {
        boolean result = false;
        if (line != null) {
            result = line.matches(LINE_REGEX);
        }
        return result;
    }

    public boolean isQuadrangleCorrect(Quadrangle quadrangle) {
        boolean result = false;
        PointValidator pointValidator = new PointValidator();
        if (quadrangle != null && quadrangle.getPoint1() != null
                && quadrangle.getPoint2() != null
                && quadrangle.getPoint3() != null
                && quadrangle.getPoint4() != null) {
            result = pointValidator.isPointInLimit(quadrangle.getPoint1())
                    && pointValidator.isPointInLimit(quadrangle.getPoint2())
                    && pointValidator.isPointInLimit(quadrangle.getPoint3())
                    && pointValidator.isPointInLimit(quadrangle.getPoint4());
        }
        return result;
    }
}
