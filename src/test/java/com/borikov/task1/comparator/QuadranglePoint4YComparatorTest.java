package com.borikov.task1.comparator;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadranglePoint4YComparatorTest {
    private QuadranglePoint4YComparator quadranglePoint4YComparator;

    @BeforeClass
    public void setUp() {
        quadranglePoint4YComparator = new QuadranglePoint4YComparator();
    }

    @AfterClass
    public void tearDown() {
        quadranglePoint4YComparator = null;
    }

    @DataProvider(name = "comparePositiveData")
    public Object[][] createComparePositiveData() {
        int expected = 0;
        Quadrangle quadrangle1 = new Quadrangle(null, null, null, new Point(2, 1));
        Quadrangle quadrangle2 = new Quadrangle(null, null, null, new Point(3, 1));
        Quadrangle quadrangle3 = new Quadrangle(null, null, null, new Point(5, 1));
        Quadrangle quadrangle4 = new Quadrangle(null, null, null, new Point(3, 1));
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
        int actual = quadranglePoint4YComparator.compare(quadrangle1, quadrangle2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNegativeData")
    public Object[][] createCompareNegativeData() {
        int expected1 = -1;
        int expected2 = 1;
        Quadrangle quadrangle1 = new Quadrangle(null, null, null, new Point(4, 1));
        Quadrangle quadrangle2 = new Quadrangle(null, null, null, new Point(2, 2));
        Quadrangle quadrangle3 = new Quadrangle(null, null, null, new Point(6, 7));
        Quadrangle quadrangle4 = new Quadrangle(null, null, null, new Point(1, 3));
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
        int actual = quadranglePoint4YComparator.compare(quadrangle1, quadrangle2);
        assertEquals(actual, expected);
    }
}
