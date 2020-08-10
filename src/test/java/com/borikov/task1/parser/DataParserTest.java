package com.borikov.task1.parser;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {
    private DataParser dataParser;

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @AfterClass
    public void tearDown() {
        dataParser = null;
    }

    @DataProvider(name = "parseLineToNumberListPositiveData")
    public Object[][] createParseLineToNumberListPositiveData() {
        String quadrangleLine1 = "1 2 3 4";
        List<Double> expected1 = new ArrayList<>();
        expected1.add(1.0);
        expected1.add(2.0);
        expected1.add(3.0);
        expected1.add(4.0);
        String quadrangleLine2 = "-1 2.3 0. -.3";
        List<Double> expected2 = new ArrayList<>();
        expected2.add(-1.0);
        expected2.add(2.3);
        expected2.add(0.0);
        expected2.add(-0.3);
        String quadrangleLine3 = "2.0 2.0 2.0 2.0 2.0 2.0 2.0 2.0";
        List<Double> expected3 = new ArrayList<>();
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        expected3.add(2.0);
        return new Object[][]{
                {quadrangleLine1, expected1},
                {quadrangleLine2, expected2},
                {quadrangleLine3, expected3},
                {null, new ArrayList<>()},
        };
    }

    @Test(dataProvider = "parseLineToNumberListPositiveData")
    public void parseLineToNumberListPositiveTest(
            String quadrangleLine, List<Double> expected) {
        List<Double> actual = dataParser.parseLineToNumberList(quadrangleLine);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "parseLineToNumberListNegativeData")
    public Object[][] createParseLineToNumberListNegativeData() {
        String quadrangleLine1 = "1 2 3 4.6";
        List<Double> expected1 = new ArrayList<>();
        String quadrangleLine2 = "-1 2.3 0. -.3";
        List<Double> expected2 = new ArrayList<>();
        expected2.add(-1.0);
        expected2.add(2.3);
        expected2.add(0.0);
        expected2.add(-3.0);
        String quadrangleLine3 = "2.0 2.0 2.0";
        List<Double> expected3 = new ArrayList<>();
        expected3.add(2.0);
        return new Object[][]{
                {quadrangleLine1, expected1},
                {quadrangleLine2, expected2},
                {quadrangleLine3, expected3}
        };
    }

    @Test(dataProvider = "parseLineToNumberListNegativeData")
    public void parseLineToNumberListNegativeTest(
            String quadrangleLine, List<Double> expected) {
        List<Double> actual = dataParser.parseLineToNumberList(quadrangleLine);
        assertNotEquals(actual, expected);
    }
}
