package com.borikov.task1.specification;

import com.borikov.task1.entity.Quadrangle;

public class QuadrangleMaxIdSpecification implements Specification {
    private long maxId;

    public QuadrangleMaxIdSpecification(long maxId) {
        this.maxId = maxId;
    }

    @Override
    public boolean test(Quadrangle quadrangle) {
        return quadrangle.getQuadrangleId() < maxId;
    }
}
