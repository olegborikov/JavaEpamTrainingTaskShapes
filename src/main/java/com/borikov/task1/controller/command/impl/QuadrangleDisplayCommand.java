package com.borikov.task1.controller.command.impl;

import com.borikov.task1.controller.PagePath;
import com.borikov.task1.controller.RequestParameter;
import com.borikov.task1.controller.command.Command;
import com.borikov.task1.creator.QuadrangleCreator;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.parser.DataParser;
import com.borikov.task1.reader.CustomFileReader;
import com.borikov.task1.repository.QuadrangleRepository;
import com.borikov.task1.validator.QuadrangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuadrangleDisplayCommand implements Command {
    private static final String UPLOAD_DIRECTORY = "C:\\uploads";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String fileName = request.getParameter(RequestParameter.FILE_NAME);
        QuadrangleCreator quadrangleCreator = new QuadrangleCreator();
        List<Quadrangle> quadrangles = new ArrayList<>();
        CustomFileReader textFileReader = new CustomFileReader();
        DataParser quadrangleParser = new DataParser();
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        QuadrangleRepository quadrangleRepository = QuadrangleRepository.getInstance();
        List<String> linedText = textFileReader.readText(UPLOAD_DIRECTORY + File.separator + fileName);
        linedText.removeIf(line -> !quadrangleValidator.isLineConformQuadrangle(line));
        LOGGER.log(Level.INFO, "{} lines are correct", linedText.size());
        for (String line : linedText) {
            List<Double> numbers = quadrangleParser.parseLineToNumberList(line);
            Quadrangle quadrangle = quadrangleCreator.createQuadrangle(numbers);
            if (quadrangleValidator.isQuadrangleCorrect(quadrangle)) {
                quadrangles.add(quadrangle);
                quadrangleRepository.add(quadrangle);
            }
        }
        LOGGER.log(Level.INFO, "{} quadrangles are valid", quadrangles.size());
        request.setAttribute(RequestParameter.FILE_NAME, fileName);
        request.setAttribute(RequestParameter.QUADRANGLES, quadrangles);
        return PagePath.QUADRANGLE_DISPLAY;
    }
}
