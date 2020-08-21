package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.Specification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleRangeSquareSpecificationTest {
    private Specification<Quadrangle> specification;

    @BeforeClass
    public void setUp() {
        specification = new QuadrangleRangeSquareSpecification(5, 16);
    }

    @AfterClass
    public void tearDown() {
        specification = null;
    }

    @DataProvider(name = "specifyPositiveData")
    public Object[][] createSpecifyPositiveData() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 1);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(1, 5);
        Point point6 = new Point(5, 1);
        Point point7 = new Point(3, 0);
        Point point8 = new Point(0, 0);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2}
        };
    }

    @Test(dataProvider = "specifyPositiveData")
    public void specifyPositiveTest(Quadrangle quadrangle) {
        boolean actual = specification.specify(quadrangle);
        assertTrue(actual);
    }

    @DataProvider(name = "specifyNegativeData")
    public Object[][] createSpecifyNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(0, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(1, 1);
        Point point6 = new Point(1, 2);
        Point point7 = new Point(2, 2);
        Point point8 = new Point(2, 1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(1, 20);
        Point point10 = new Point(5, 15);
        Point point11 = new Point(3, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "specifyNegativeData")
    public void specifyNegativeTest(Quadrangle quadrangle) {
        boolean actual = specification.specify(quadrangle);
        assertFalse(actual);
    }
}
