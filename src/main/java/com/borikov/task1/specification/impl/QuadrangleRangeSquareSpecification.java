package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;
import com.borikov.task1.specification.QuadrangleSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleRangeSquareSpecification implements QuadrangleSpecification {
    private final double minSquare;
    private final double maxSquare;
    private static final Logger LOGGER = LogManager.getLogger();

    public QuadrangleRangeSquareSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean result = false;
        try {
            QuadrangleArithmeticService quadrangleArithmeticService =
                    new QuadrangleArithmeticServiceImpl();
            double quadrangleSquare =
                    quadrangleArithmeticService.calculateSquare(quadrangle);
            result = quadrangleSquare >= minSquare
                    && quadrangleSquare <= maxSquare;
        } catch (IncorrectDataException e) {
            LOGGER.log(Level.WARN, "Error with quadrangle: {}", quadrangle, e);
        }
        return result;
    }
}

