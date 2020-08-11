package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.Specification;

public class QuadrangleCurrentIdSpecification implements Specification {
    private long currentId;

    public QuadrangleCurrentIdSpecification(long currentId) {
        this.currentId = currentId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangle.getQuadrangleId() == currentId;
    }
}
