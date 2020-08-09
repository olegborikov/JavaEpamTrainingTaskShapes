package com.borikov.task1.factory.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.factory.QuadrangleCreator;
import com.borikov.task1.parser.DataParser;
import com.borikov.task1.reader.CustomFileReader;
import com.borikov.task1.validator.PointValidator;
import com.borikov.task1.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreatorImpl implements QuadrangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Quadrangle> createQuadrangles(String fileName) {
        List<Quadrangle> quadrangles = new ArrayList<>();
        if (fileName != null) {
            CustomFileReader textFileReader = new CustomFileReader();
            DataParser quadrangleParser = new DataParser();
            QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
            PointValidator pointValidator = new PointValidator();
            List<String> linedText = textFileReader.readFromFile(fileName);
            int allLinesAmount = linedText.size();
            linedText.removeIf(line -> !quadrangleValidator.isLineConformQuadrangle(line));
            int correctLinesAmount = linedText.size();
            LOGGER.log(Level.INFO, "{} lines are incorrect", allLinesAmount - correctLinesAmount);
            for (String line : linedText) {
                List<Double> numbers = quadrangleParser.parseLineToNumberList(line);
                Point point1 = new Point(numbers.get(0), numbers.get(1));
                Point point2 = new Point(numbers.get(2), numbers.get(3));
                Point point3 = new Point(numbers.get(4), numbers.get(5));
                Point point4 = new Point(numbers.get(6), numbers.get(7));
                Quadrangle quadrangle = new Quadrangle(point1, point2, point3, point4);// TODO: 09.08.2020 where i should move it
                if (pointValidator.isPointInLimit(quadrangle.getPoint1())
                        && pointValidator.isPointInLimit(quadrangle.getPoint2())
                        && pointValidator.isPointInLimit(quadrangle.getPoint3())
                        && pointValidator.isPointInLimit(quadrangle.getPoint4())) {
                    quadrangles.add(quadrangle);
                }
            }
            LOGGER.log(Level.INFO, "{} quadrangles are invalid", correctLinesAmount - quadrangles.size());
        }
        return quadrangles;
    }
}
