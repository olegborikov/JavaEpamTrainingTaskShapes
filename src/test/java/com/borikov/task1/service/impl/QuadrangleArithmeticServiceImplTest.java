package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleArithmeticService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleArithmeticServiceImplTest {
    private QuadrangleArithmeticService quadrangleArithmeticService;

    @BeforeClass
    public void setUp() {
        quadrangleArithmeticService = new QuadrangleArithmeticServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        quadrangleArithmeticService = null;
    }

    @DataProvider(name = "calculatePerimeterPositiveData")
    public Object[][] createCalculatePerimeterPositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        double expected1 = 20;
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        double expected2 = 21.83;
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        double expected3 = 5.77;
        return new Object[][]{
                {quadrangle1, expected1},
                {quadrangle2, expected2},
                {quadrangle3, expected3}
        };
    }

    @Test(dataProvider = "calculatePerimeterPositiveData")
    public void calculatePerimeterPositiveTest(Quadrangle quadrangle, double expected) {
        try {
            double actual = quadrangleArithmeticService.calculatePerimeter(quadrangle);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "calculatePerimeterNegativeData")
    public Object[][] createCalculatePerimeterNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        double expected1 = 20;
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        double expected2 = 21.821;
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        double expected3 = 5.768;
        return new Object[][]{
                {quadrangle1, expected1},
                {quadrangle2, expected2},
                {quadrangle3, expected3}
        };
    }

    @Test(dataProvider = "calculatePerimeterNegativeData")
    public void calculatePerimeterNegativeTest(Quadrangle quadrangle, double expected) {
        try {
            double actual = quadrangleArithmeticService.calculatePerimeter(quadrangle);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "calculatePerimeterExceptionData")
    public Object[][] createCalculatePerimeterExceptionData() {
        Point point1 = new Point(0, 1000);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-4, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, null, point5, point5);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(0, 1.15);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "calculatePerimeterExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void calculatePerimeterExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleArithmeticService.calculatePerimeter(quadrangle);
    }

    @DataProvider(name = "calculateSquarePositiveData")
    public Object[][] createCalculateSquarePositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        double expected1 = 25;
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        double expected2 = 27.5;
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        double expected3 = 1.9;
        return new Object[][]{
                {quadrangle1, expected1},
                {quadrangle2, expected2},
                {quadrangle3, expected3}
        };
    }

    @Test(dataProvider = "calculateSquarePositiveData")
    public void calculateSquarePositiveTest(Quadrangle quadrangle, double expected) {
        try {
            double actual = quadrangleArithmeticService.calculateSquare(quadrangle);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "calculateSquareNegativeData")
    public Object[][] createCalculateSquareNegativeData() {
        Point point1 = new Point(0, 4);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        double expected1 = 25;
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        double expected2 = 27.49;
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        double expected3 = 1.91;
        return new Object[][]{
                {quadrangle1, expected1},
                {quadrangle2, expected2},
                {quadrangle3, expected3}
        };
    }

    @Test(dataProvider = "calculateSquareNegativeData")
    public void calculateSquareNegativeTest(Quadrangle quadrangle, double expected) {
        try {
            double actual = quadrangleArithmeticService.calculateSquare(quadrangle);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "calculateSquareExceptionData")
    public Object[][] createCalculateSquareExceptionData() {
        Point point1 = new Point(0, 1000);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-4, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, null, point5, point5);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(0, 1.15);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        Point point13 = new Point(3, 2);
        Point point14 = new Point(-2, -4);
        Point point15 = new Point(-3, 2);
        Point point16 = new Point(0, 0);
        Quadrangle quadrangle4 = new Quadrangle(point13, point14, point15, point16);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
                {quadrangle4}
        };
    }

    @Test(dataProvider = "calculateSquareExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void calculateSquareExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleArithmeticService.calculateSquare(quadrangle);
    }
}
