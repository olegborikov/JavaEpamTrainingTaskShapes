package com.borikov.task1.validator;

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
}
