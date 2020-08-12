package com.borikov.task1.service;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;

public abstract class QuadrangleArithmeticService extends QuadrangleService {
    public abstract double calculatePerimeter(Quadrangle quadrangle)
            throws IncorrectDataException;

    public abstract double calculateSquare(Quadrangle quadrangle)
            throws IncorrectDataException;
}
