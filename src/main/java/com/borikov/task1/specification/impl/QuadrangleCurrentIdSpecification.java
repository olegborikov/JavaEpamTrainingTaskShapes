package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.QuadrangleSpecification;

public class QuadrangleCurrentIdSpecification implements QuadrangleSpecification {
    private final long currentId;

    public QuadrangleCurrentIdSpecification(long currentId) {
        this.currentId = currentId;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        return quadrangle.getQuadrangleId() == currentId;
    }
}
