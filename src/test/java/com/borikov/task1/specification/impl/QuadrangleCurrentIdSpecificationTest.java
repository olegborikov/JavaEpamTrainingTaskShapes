package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.Specification;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleCurrentIdSpecificationTest {
    @Test
    public void specifyPositiveTest() {
        Quadrangle quadrangle = new Quadrangle(null, null, null, null);
        Specification<Quadrangle> specification =
                new QuadrangleCurrentIdSpecification(quadrangle.getQuadrangleId());
        boolean actual = specification.specify(quadrangle);
        assertTrue(actual);
    }

    @Test
    public void specifyNegativeTest() {
        Quadrangle quadrangle = new Quadrangle(null, null, null, null);
        Specification<Quadrangle> specification =
                new QuadrangleCurrentIdSpecification(quadrangle.getQuadrangleId() + 1);
        boolean actual = specification.specify(quadrangle);
        assertFalse(actual);
    }
}
