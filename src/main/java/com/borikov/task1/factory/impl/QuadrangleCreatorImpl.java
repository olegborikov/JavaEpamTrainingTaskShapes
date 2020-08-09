package com.borikov.task1.factory.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.factory.QuadrangleCreator;
import com.borikov.task1.parser.QuadrangleParser;
import com.borikov.task1.reader.TextFileReader;
import com.borikov.task1.validator.PointValidator;
import com.borikov.task1.validator.TextValidator;
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
            TextFileReader textFileReader = new TextFileReader();
            QuadrangleParser quadrangleParser = new QuadrangleParser();
            TextValidator textValidator = new TextValidator();
            PointValidator pointValidator = new PointValidator();
            List<String> linedText = textFileReader.readText(fileName);
            int allLinesAmount = linedText.size();
            linedText.removeIf(line -> !textValidator.isLineCorrect(line));
            LOGGER.log(Level.INFO, "{} lines are incorrect", allLinesAmount - linedText.size());
            for (String line : linedText) {
                Quadrangle quadrangle = quadrangleParser.parseLineToQuadrangle(line);
                if (pointValidator.isPointInLimit(quadrangle.getPoint1())
                        && pointValidator.isPointInLimit(quadrangle.getPoint2())
                        && pointValidator.isPointInLimit(quadrangle.getPoint3())
                        && pointValidator.isPointInLimit(quadrangle.getPoint4())) {
                    quadrangles.add(quadrangle);
                }
            }
            LOGGER.log(Level.INFO, "{} quadrangles are invalid", linedText.size() - quadrangles.size());
        }
        return quadrangles;
    }
}
