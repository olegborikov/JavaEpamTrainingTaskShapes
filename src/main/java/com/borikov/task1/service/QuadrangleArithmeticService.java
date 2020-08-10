package com.borikov.task1.service;

import com.borikov.task1.entity.Quadrangle;

public interface QuadrangleArithmeticService extends QuadrangleService {
    public double calculateSquare(Quadrangle quadrangle);

    public double calculatePerimeter(Quadrangle quadrangle);
}
