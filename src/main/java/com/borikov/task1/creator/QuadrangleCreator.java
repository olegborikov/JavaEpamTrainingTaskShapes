package com.borikov.task1.creator;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.parser.DataParser;
import com.borikov.task1.reader.CustomFileReader;
import com.borikov.task1.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<Quadrangle> createQuadranglesFromFile(String fileName) {// TODO: 13.08.2020 refactor?
        List<Quadrangle> quadrangles = new ArrayList<>();
        if (fileName != null) {
            CustomFileReader textFileReader = new CustomFileReader();
            DataParser quadrangleParser = new DataParser();
            QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
            List<String> linedText = textFileReader.readText(fileName);
            linedText.removeIf(line -> !quadrangleValidator.isLineConformQuadrangle(line));
            LOGGER.log(Level.INFO, "{} lines are correct", linedText.size());
            for (String line : linedText) {
                List<Double> numbers = quadrangleParser.parseLineToNumberList(line);
                Quadrangle quadrangle = createQuadrangle(numbers);
                if (quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
                    quadrangles.add(quadrangle);
                }
            }
            LOGGER.log(Level.INFO, "{} quadrangles are valid", quadrangles.size());
        }
        return quadrangles;
    }

    public Quadrangle createQuadrangle(List<Double> numbers) {
        Point point1 = new Point(numbers.get(0), numbers.get(1));
        Point point2 = new Point(numbers.get(2), numbers.get(3));
        Point point3 = new Point(numbers.get(4), numbers.get(5));
        Point point4 = new Point(numbers.get(6), numbers.get(7));
        return new Quadrangle(point1, point2, point3, point4);
    }
}
