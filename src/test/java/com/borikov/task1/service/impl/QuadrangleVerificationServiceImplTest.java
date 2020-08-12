package com.borikov.task1.service.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.service.QuadrangleVerificationService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleVerificationServiceImplTest {
    private QuadrangleVerificationService quadrangleVerificationService;

    @BeforeClass
    public void setUp() {
        quadrangleVerificationService = new QuadrangleVerificationServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        quadrangleVerificationService = null;
    }

    @DataProvider(name = "isPointsMakeQuadranglePositiveData")
    public Object[][] createIsPointsMakeQuadranglePositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        return new Object[][]{
                {point1, point2, point3, point4},
                {point5, point6, point7, point8},
                {point9, point10, point11, point12},
        };
    }

    @Test(dataProvider = "isPointsMakeQuadranglePositiveData")
    public void isPointsMakeQuadranglePositiveTest(
            Point point1, Point point2, Point point3, Point point4) {
        try {
            boolean actual = quadrangleVerificationService.isPointsMakeQuadrangle(
                    point1, point2, point3, point4);
            assertTrue(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isPointsMakeQuadrangleNegativeData")
    public Object[][] createIsPointsMakeQuadrangleNegativeData() {
        Point point1 = new Point(10, 7);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Point point5 = new Point(-4, -3);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(0, 1.15);
        Point point12 = new Point(0, 0);
        return new Object[][]{
                {point1, point2, point3, point4},
                {point5, point5, point2, point4},
                {point9, point10, point11, point12},
        };
    }

    @Test(dataProvider = "isPointsMakeQuadrangleNegativeData")
    public void isPointsMakeQuadrangleNegativeTest(
            Point point1, Point point2, Point point3, Point point4) {
        try {
            boolean actual = quadrangleVerificationService.isPointsMakeQuadrangle(
                    point1, point2, point3, point4);
            assertFalse(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isPointsMakeQuadrangleExceptionData")
    public Object[][] createIsPointsMakeQuadrangleExceptionData() {
        Point point1 = new Point(10, 1000);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Point point5 = new Point(-4, -3);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(0, 1.15);
        return new Object[][]{
                {point1, point2, point3, point4},
                {point5, point5, point2, point1},
                {point9, point10, point11, null},
        };
    }

    @Test(dataProvider = "isPointsMakeQuadrangleExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void isPointsMakeQuadrangleExceptionTest(
            Point point1, Point point2, Point point3, Point point4)
            throws IncorrectDataException {
        quadrangleVerificationService.isPointsMakeQuadrangle(point1, point2, point3, point4);
    }

    @DataProvider(name = "isQuadrangleConvexPositiveData")
    public Object[][] createIsQuadrangleConvexPositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(0, 1.5);
        Point point10 = new Point(1, 2);
        Point point11 = new Point(1.15, 0);
        Point point12 = new Point(0, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
        };
    }

    @Test(dataProvider = "isQuadrangleConvexPositiveData")
    public void isQuadrangleConvexPositiveTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleConvex(quadrangle);
            assertTrue(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleConvexNegativeData")
    public Object[][] createIsQuadrangleConvexNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 5);
        Point point3 = new Point(2, 2);
        Point point4 = new Point(5, 2);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(2.5, 1);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(0, 0);
        Point point10 = new Point(0, 2);
        Point point11 = new Point(2, 0);
        Point point12 = new Point(2, 2);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "isQuadrangleConvexNegativeData")
    public void isQuadrangleConvexNegativeTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleConvex(quadrangle);
            assertFalse(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleConvexExceptionData")
    public Object[][] createIsQuadrangleConvexExceptionData() {
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
                {quadrangle3},
        };
    }

    @Test(dataProvider = "isQuadrangleConvexExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void isQuadrangleConvexExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleVerificationService.isQuadrangleConvex(quadrangle);
    }

    @DataProvider(name = "isQuadrangleSquarePositiveData")
    public Object[][] createIsQuadrangleSquarePositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-1, -1);
        Point point6 = new Point(-1, 1);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, -1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2}
        };
    }

    @Test(dataProvider = "isQuadrangleSquarePositiveData")
    public void isQuadrangleSquarePositiveTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleSquare(quadrangle);
            assertTrue(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleSquareNegativeData")
    public Object[][] createIsQuadrangleSquareNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-1, -1);
        Point point6 = new Point(-1, 1.01);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, -1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(1, 0);
        Point point10 = new Point(0, 2);
        Point point11 = new Point(1, 4);
        Point point12 = new Point(2, 2);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "isQuadrangleSquareNegativeData")
    public void isQuadrangleSquareNegativeTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleSquare(quadrangle);
            assertFalse(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleSquareExceptionData")
    public Object[][] createIsQuadrangleSquareExceptionData() {
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
                {quadrangle3},
        };
    }

    @Test(dataProvider = "isQuadrangleSquareExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void isQuadrangleSquareExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleVerificationService.isQuadrangleSquare(quadrangle);
    }

    @DataProvider(name = "isQuadrangleRhombusPositiveData")
    public Object[][] createIsQuadrangleRhombusPositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-1, -1);
        Point point6 = new Point(-1, 1);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, -1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(1, 0);
        Point point10 = new Point(0, 2);
        Point point11 = new Point(1, 4);
        Point point12 = new Point(2, 2);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        Point point13 = new Point(1, 2);
        Point point14 = new Point(7, 4);
        Point point15 = new Point(13, 2);
        Point point16 = new Point(7, 0);
        Quadrangle quadrangle4 = new Quadrangle(point13, point14, point15, point16);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
                {quadrangle4}
        };
    }

    @Test(dataProvider = "isQuadrangleRhombusPositiveData")
    public void isQuadrangleRhombusPositiveTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleRhombus(quadrangle);
            assertTrue(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleRhombusNegativeData")
    public Object[][] createIsQuadrangleRhombusNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 1);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-2, 2);
        Point point6 = new Point(1, 4);
        Point point7 = new Point(2, 4);
        Point point8 = new Point(-1, 2);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(-4, -3);
        Point point10 = new Point(-1, 2);
        Point point11 = new Point(3, 2);
        Point point12 = new Point(3, -3);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3}
        };
    }

    @Test(dataProvider = "isQuadrangleRhombusNegativeData")
    public void isQuadrangleRhombusNegativeTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleRhombus(quadrangle);
            assertFalse(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleRhombusExceptionData")
    public Object[][] createIsQuadrangleRhombusExceptionData() {
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
                {quadrangle3},
        };
    }

    @Test(dataProvider = "isQuadrangleRhombusExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void isQuadrangleRhombusExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleVerificationService.isQuadrangleRhombus(quadrangle);
    }

    @DataProvider(name = "isQuadrangleTrapezoidPositiveData")
    public Object[][] createIsQuadrangleTrapezoidPositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 1);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-4, -3);
        Point point6 = new Point(-1, 2);
        Point point7 = new Point(3, 2);
        Point point8 = new Point(3, -3);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2}
        };
    }

    @Test(dataProvider = "isQuadrangleTrapezoidPositiveData")
    public void isQuadrangleTrapezoidPositiveTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleTrapezoid(quadrangle);
            assertTrue(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleTrapezoidNegativeData")
    public Object[][] createIsQuadrangleTrapezoidNegativeData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-1, -1);
        Point point6 = new Point(-1, 1);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, -1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(1, 0);
        Point point10 = new Point(0, 2);
        Point point11 = new Point(1, 4);
        Point point12 = new Point(2, 2);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        Point point13 = new Point(-2, 2);
        Point point14 = new Point(1, 4);
        Point point15 = new Point(2, 4);
        Point point16 = new Point(-1, 2);
        Quadrangle quadrangle4 = new Quadrangle(point13, point14, point15, point16);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
                {quadrangle4}
        };
    }

    @Test(dataProvider = "isQuadrangleTrapezoidNegativeData")
    public void isQuadrangleTrapezoidNegativeTest(Quadrangle quadrangle) {
        try {
            boolean actual = quadrangleVerificationService.isQuadrangleTrapezoid(quadrangle);
            assertFalse(actual);
        } catch (IncorrectDataException e) {
            fail("Incorrect data");
        }
    }

    @DataProvider(name = "isQuadrangleTrapezoidExceptionData")
    public Object[][] createIsQuadrangleTrapezoidExceptionData() {
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
                {quadrangle3},
        };
    }

    @Test(dataProvider = "isQuadrangleTrapezoidExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void isQuadrangleTrapezoidExceptionTest(Quadrangle quadrangle)
            throws IncorrectDataException {
        quadrangleVerificationService.isQuadrangleTrapezoid(quadrangle);
    }
}
