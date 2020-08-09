package com.borikov.task1.factory;

import com.borikov.task1.entity.Quadrangle;

import java.util.List;

public interface QuadrangleCreator {
    List<Quadrangle> createQuadrangles(String fileName);
}
