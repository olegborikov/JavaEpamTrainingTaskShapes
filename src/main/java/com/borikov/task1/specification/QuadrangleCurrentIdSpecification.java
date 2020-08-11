package com.borikov.task1.specification;

import com.borikov.task1.entity.Quadrangle;

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
