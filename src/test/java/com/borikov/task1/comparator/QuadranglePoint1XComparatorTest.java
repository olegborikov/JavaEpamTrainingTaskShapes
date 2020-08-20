package com.borikov.task1.comparator;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadranglePoint1XComparatorTest {
    private QuadranglePoint1XComparator quadranglePoint1XComparator;

    @BeforeClass
    public void setUp() {
        quadranglePoint1XComparator = new QuadranglePoint1XComparator();
    }

    @AfterClass
    public void tearDown() {
        quadranglePoint1XComparator = null;
    }

    @DataProvider(name = "comparePositiveData")
    public Object[][] createComparePositiveData() {
        int expected = 0;
        Quadrangle quadrangle1 = new Quadrangle(new Point(1, 2), null, null, null);
        Quadrangle quadrangle2 = new Quadrangle(new Point(1, 3), null, null, null);
        Quadrangle quadrangle3 = new Quadrangle(new Point(1, 5), null, null, null);
        Quadrangle quadrangle4 = new Quadrangle(new Point(1, 3), null, null, null);
        return new Object[][]{
                {quadrangle1, quadrangle2, expected},
                {quadrangle1, quadrangle3, expected},
                {quadrangle3, quadrangle2, expected},
                {quadrangle4, quadrangle1, expected},
                {quadrangle1, quadrangle4, expected}
        };
    }

    @Test(dataProvider = "comparePositiveData")
    public void comparePositiveTest(
            Quadrangle quadrangle1, Quadrangle quadrangle2, int expected) {
        int actual = quadranglePoint1XComparator.compare(quadrangle1, quadrangle2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNegativeData")
    public Object[][] createCompareNegativeData() {
        int expected1 = -1;
        int expected2 = 1;
        Quadrangle quadrangle1 = new Quadrangle(new Point(1, 4), null, null, null);
        Quadrangle quadrangle2 = new Quadrangle(new Point(2, 2), null, null, null);
        Quadrangle quadrangle3 = new Quadrangle(new Point(7, 6), null, null, null);
        Quadrangle quadrangle4 = new Quadrangle(new Point(3, 1), null, null, null);
        return new Object[][]{
                {quadrangle1, quadrangle2, expected1},
                {quadrangle1, quadrangle3, expected1},
                {quadrangle3, quadrangle2, expected2},
                {quadrangle4, quadrangle1, expected2},
                {quadrangle1, quadrangle4, expected1},
                {quadrangle3, quadrangle4, expected2},
        };
    }

    @Test(dataProvider = "compareNegativeData")
    public void compareNegativeTest(
            Quadrangle quadrangle1, Quadrangle quadrangle2, int expected) {
        int actual = quadranglePoint1XComparator.compare(quadrangle1, quadrangle2);
        assertEquals(actual, expected);
    }
}
