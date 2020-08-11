package com.borikov.task1.specification;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;

public class QuadrangleRangeSquareSpecification implements Specification {
    private double minSquare;
    private double maxSquare;

    public QuadrangleRangeSquareSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        boolean result;
        try {
            QuadrangleArithmeticService quadrangleArithmeticService = new QuadrangleArithmeticServiceImpl();
            double quadranglePerimeter = quadrangleArithmeticService.calculateSquare(quadrangle);
            result = quadranglePerimeter >= minSquare && quadranglePerimeter <= maxSquare;
        } catch (IncorrectDataException e) {
            result = false;
        }
        return result;
    }
}

