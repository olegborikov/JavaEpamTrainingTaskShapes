package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;
import com.borikov.task1.specification.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleRangePerimeterSpecification implements Specification {
    private final double minPerimeter;
    private final double maxPerimeter;
    private static final Logger LOGGER = LogManager.getLogger();

    public QuadrangleRangePerimeterSpecification(
            double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        boolean result = false;
        try {
            QuadrangleArithmeticService quadrangleArithmeticService =
                    new QuadrangleArithmeticServiceImpl();
            double quadranglePerimeter =
                    quadrangleArithmeticService.calculatePerimeter(quadrangle);
            result = quadranglePerimeter >= minPerimeter
                    && quadranglePerimeter <= maxPerimeter;
        } catch (IncorrectDataException e) {
            LOGGER.log(Level.INFO, "Error with quadrangle: {}", quadrangle, e);
        }
        return result;
    }
}
