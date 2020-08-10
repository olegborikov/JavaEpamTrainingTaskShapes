package com.borikov.task1.validator;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {
    private QuadrangleValidator quadrangleValidator;

    @BeforeClass
    public void setUp() {
        quadrangleValidator = new QuadrangleValidator();
    }

    @AfterClass
    public void tearDown() {
        quadrangleValidator = null;
    }

    @DataProvider(name = "isLineConformQuadranglePositiveData")
    public Object[][] createIsLineConformQuadranglePositiveData() {
        return new Object[][]{
                {"-1. 0.1 1. 0.1 1. 0.1 1. -.1"},
                {"1111.321 333.1 .1 3.1 1. 03.1 1.4 0.1"},
                {"101 11 .011 11.11 11.0 1.1 11. 1.1"},
                {"-101 -11 .011 11.11 -11.0 1.1 -11. -1.1"},
        };
    }

    @Test(dataProvider = "isLineConformQuadranglePositiveData")
    public void isLineConformQuadranglePositiveTest(String line) {
        boolean actual = quadrangleValidator.isLineConformQuadrangle(line);
        assertTrue(actual);
    }

    @DataProvider(name = "isLineConformQuadrangleNegativeData")
    public Object[][] createIsLineConformQuadrangleNegativeData() {
        return new Object[][]{
                {"1. 0.1 1. 0.1 1. 0.1 1. 0.1 "},
                {"1. 0.1 1. 0.1 1. 0.1 1."},
                {"1. 0.1 1.b 0.1 1. 0.1 1. 0.1"},
                {"1"},
                {"1. 0.1 1. 0.1 1. 0.1 1. 0.1 0.1"},
                {"1. 0..1 1. 0.1 1. 0.1 1. 0.1"},
                {"1. 0.1. 1. 0.1 1. 0.1 1. 0.1"},
                {"1. --0.1 1. 0.1 1. 0.1 1. 0.1"},
                {""},
                {null}
        };
    }

    @Test(dataProvider = "isLineConformQuadrangleNegativeData")
    public void isLineConformQuadrangleNegativeTest(String line) {
        boolean actual = quadrangleValidator.isLineConformQuadrangle(line);
        assertFalse(actual);
    }

    @DataProvider(name = "isQuadrangleCorrectPositiveData")
    public Object[][] createIsQuadrangleCorrectPositiveData() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(99, 999);
        Point point4 = new Point(-999, 999);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-999, 999);
        Point point6 = new Point(-999, 999);
        Point point7 = new Point(-999, 999);
        Point point8 = new Point(-999, 999);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2}
        };
    }

    @Test(dataProvider = "isQuadrangleCorrectPositiveData")
    public void isQuadrangleCorrectPositiveTest(Quadrangle quadrangle) {
        boolean actual = quadrangleValidator.isQuadrangleCorrect(quadrangle);
        assertTrue(actual);
    }

    @DataProvider(name = "isQuadrangleCorrectNegativeData")
    public Object[][] createIsQuadrangleCorrectNegativeData() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(99, 999);
        Point point4 = new Point(-999, 1000);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point6 = new Point(-999, 999);
        Point point7 = new Point(-999, 999);
        Point point8 = new Point(-999, 999);
        Quadrangle quadrangle2 = new Quadrangle(null, point6, point7, point8);
        Quadrangle quadrangle3 = new Quadrangle(null, null, null, null);
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
                {null}
        };
    }

    @Test(dataProvider = "isQuadrangleCorrectNegativeData")
    public void isQuadrangleCorrectNegativeTest(Quadrangle quadrangle) {
        boolean actual = quadrangleValidator.isQuadrangleCorrect(quadrangle);
        assertFalse(actual);
    }
}
