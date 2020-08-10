package com.borikov.task1.reader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomFileReaderTest {
    private CustomFileReader customFileReader;

    @BeforeClass
    public void setUp() {
        customFileReader = new CustomFileReader();
    }

    @AfterClass
    public void tearDown() {
        customFileReader = null;
    }

    @Test
    public void readTextPositiveTest() {
        String fileName = "data/data.txt";
        List<String> expected = new ArrayList<>();
        expected.add("2 0.0 .0 3 2.0 6. 4 3.0");
        expected.add("2 0.0 .0 3 2.0 6. 4");
        expected.add("-1.5 -1.5 0 2.0 0 .0 1 0");
        expected.add("-2.5 -2.5 -2.5 2.5 2.5 2.5 2.5 -2.5");
        expected.add("3 0.0 -2 .0 -1 2 2.0 2.");
        expected.add("1..1 .2 3.5 1 2. 3 4.4 1");
        expected.add("-3.25 -3 1.2 4.4 7.1 1 6 -4.6");
        expected.add("");
        expected.add("0. 0 3 0 6. 0.0 3 3");
        expected.add("-3.25 3.25 1 1 2.v4 4.3 2.1 2.2");
        expected.add("0 0 2 3 6 3 4 0.0");
        expected.add("6.0 .0 3. 3 -2 -2.0 -2 3");
        expected.add("--3 2 1 2 3.1 3 1.1 2");
        expected.add("0 3.1 1.2 0 0 -3.1 -1.2 0");
        expected.add("-1.0 -1 -1 -3 -3. -3 -3.0 -1");
        expected.add("-1.0 -1 -1 -3 -3. -3 -3.0 -1000");
        List<String> actual = customFileReader.readText(fileName);
        assertEquals(actual, expected);
    }

    @Test
    public void readTextNegativeTest() {
        String fileName = "data/data.txt";
        List<String> expected = new ArrayList<>();
        expected.add("2 0.0 .0 3 2.0 6. 4 3.0");
        expected.add("2 0.0 .0 3 2.0 6. 4");
        expected.add("-1.5 -1.5 0 2.0 0 .0 1 0");
        expected.add("-2.5 -2.5 -2.5 2.5 2.5 2.5 2.5 -2.5");
        expected.add("3 0.0 -2 .0 -1 2 2.0 2.");
        expected.add("1..1 .2 3.5 1 2. 3 4.4 1");
        expected.add("-3.25 -3 1.2 4.4 7.1 1 6 -4.6");
        expected.add("\n");
        expected.add("0. 0 3 0 6. 0.0 3 3");
        expected.add("-3.25 3.25 1 1 2.v4 4.3 2.1 2.2");
        expected.add("0 0 2 3 6 3 4 0.0");
        expected.add("6.0 .0 3. 3 -2 -2.0 -2 3");
        expected.add("--3 2 1 2 3.1 3 1.1 2");
        expected.add("0 3.1 1.2 0 0 -3.1 -1.2 0");
        expected.add("-1.0 -1 -1 -3 -3. -3 -3.0 -1");
        expected.add("-1.0 -1 -1 -3 -3. -3 -3.0 -1000");
        List<String> actual = customFileReader.readText(fileName);
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void readTextExceptionTest() {
        customFileReader.readText("data.txt");
    }
}
