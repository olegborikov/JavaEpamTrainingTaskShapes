package com.borikov.task1.comparator;

import com.borikov.task1.entity.Quadrangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class QuadrangleIdComparatorTest {
    private QuadrangleIdComparator quadrangleIdComparator;

    @BeforeClass
    public void setUp() {
        quadrangleIdComparator = new QuadrangleIdComparator();
    }

    @AfterClass
    public void tearDown() {
        quadrangleIdComparator = null;
    }

    @DataProvider(name = "compareData")
    public Object[][] createCompareData() {
        int expected1 = -1;
        int expected2 = 1;
        Quadrangle quadrangle1 = new Quadrangle(null, null, null, null);
        Quadrangle quadrangle2 = new Quadrangle(null, null, null, null);
        Quadrangle quadrangle3 = new Quadrangle(null, null, null, null);
        Quadrangle quadrangle4 = new Quadrangle(null, null, null, null);
        return new Object[][]{
                {quadrangle1, quadrangle2, expected1},
                {quadrangle1, quadrangle3, expected1},
                {quadrangle3, quadrangle2, expected2},
                {quadrangle4, quadrangle1, expected2},
                {quadrangle1, quadrangle4, expected1}
        };
    }

    @Test(dataProvider = "compareData")
    public void compareTest(
            Quadrangle quadrangle1, Quadrangle quadrangle2, int expected) {
        int actual = quadrangleIdComparator.compare(quadrangle1, quadrangle2);
        assertEquals(actual, expected);
    }
}
