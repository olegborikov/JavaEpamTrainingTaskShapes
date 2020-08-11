package com.borikov.task1.specification;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;

public class QuadrangleRangePerimeterSpecification implements Specification {
    private double minPerimeter;
    private double maxPerimeter;

    public QuadrangleRangePerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        boolean result;
        try {
            QuadrangleArithmeticService quadrangleArithmeticService = new QuadrangleArithmeticServiceImpl();
            double quadranglePerimeter = quadrangleArithmeticService.calculatePerimeter(quadrangle);
            result = quadranglePerimeter >= minPerimeter && quadranglePerimeter <= maxPerimeter;
        } catch (IncorrectDataException e) {
            result = false;
        }
        return result;
    }
}

