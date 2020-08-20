package com.borikov.task1.specification.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.QuadrangleSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleInsideThirdQuadrantSpecificationTest {
    private QuadrangleSpecification specification;

    @BeforeClass
    public void setUp() {
        specification = new QuadrangleInsideThirdQuadrantSpecification();
    }

    @AfterClass
    public void tearDown() {
        specification = null;
    }

    @DataProvider(name = "specifyPositiveData")
    public Object[][] createSpecifyPositiveData() {
        Point point1 = new Point(-1, 0);
        Point point2 = new Point(-3, -9);
        Point point3 = new Point(-3, -2);
        Point point4 = new Point(-2, -2);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(0, 0);
        Point point6 = new Point(-2, -6);
        Point point7 = new Point(-4, -8);
        Point point8 = new Point(-5, -2);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(0, 0);
        Point point10 = new Point(0, -1);
        Point point11 = new Point(-5, -5);
        Point point12 = new Point(-5, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "specifyPositiveData")
    public void specifyPositiveTest(Quadrangle quadrangle) {
        boolean actual = specification.specify(quadrangle);
        assertTrue(actual);
    }

    @DataProvider(name = "specifyNegativeData")
    public Object[][] createSpecifyNegativeData() {
        Point point1 = new Point(-1, 0);
        Point point2 = new Point(3, 9);
        Point point3 = new Point(3, 2);
        Point point4 = new Point(2, 2);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(0, 0);
        Point point6 = new Point(-2, -6);
        Point point7 = new Point(-4, 8);
        Point point8 = new Point(-5, -2);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(0, 0);
        Point point10 = new Point(0, 1);
        Point point11 = new Point(-5, 5);
        Point point12 = new Point(5, 0);
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
