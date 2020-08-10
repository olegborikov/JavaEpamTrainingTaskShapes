package com.borikov.task1.validator;

import com.borikov.task1.entity.Point;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointValidatorTest {
    private PointValidator pointValidator;

    @BeforeClass
    public void setUp() {
        pointValidator = new PointValidator();
    }

    @AfterClass
    public void tearDown() {
        pointValidator = null;
    }

    @DataProvider(name = "isPointInLimitPositiveData")
    public Object[][] createIsPointInLimitPositiveData() {
        return new Object[][]{
                {new Point(999, -999)},
                {new Point(0, 999)},
                {new Point(999, 999)},
                {new Point(-999, -999)}
        };
    }

    @Test(dataProvider = "isPointInLimitPositiveData")
    public void isPointInLimitPositiveTest(Point point) {
        boolean actual = pointValidator.isPointInLimit(point);
        assertTrue(actual);
    }

    @DataProvider(name = "isPointInLimitNegativeData")
    public Object[][] createIsPointInLimitNegativeData() {
        return new Object[][]{
                {new Point(1000, -1000)},
                {new Point(0, 1000)},
                {new Point(1000, 1000)},
                {new Point(-1000, -1000)},
                {null}
        };
    }

    @Test(dataProvider = "isPointInLimitNegativeData")
    public void isPointInLimitNegativeTest(Point point) {
        boolean actual = pointValidator.isPointInLimit(point);
        assertFalse(actual);
    }

    @DataProvider(name = "isCoordinateInLimitPositiveData")
    public Object[][] createIsCoordinateInLimitPositiveData() {
        return new Object[][]{
                {999},
                {-999},
                {0},
                {123}
        };
    }

    @Test(dataProvider = "isCoordinateInLimitPositiveData")
    public void isCoordinateInLimitPositiveTest(double coordinate) {
        boolean actual = pointValidator.isCoordinateInLimit(coordinate);
        assertTrue(actual);
    }

    @DataProvider(name = "isCoordinateInLimitNegativeData")
    public Object[][] createIsCoordinateInLimitNegativeData() {
        return new Object[][]{
                {1000},
                {-1000},
                {1230}
        };
    }

    @Test(dataProvider = "isCoordinateInLimitNegativeData")
    public void isCoordinateInLimitNegativeTest(double coordinate) {
        boolean actual = pointValidator.isCoordinateInLimit(coordinate);
        assertFalse(actual);
    }
}
