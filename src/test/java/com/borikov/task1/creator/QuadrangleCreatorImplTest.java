package com.borikov.task1.creator;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleCreatorImplTest {
    private QuadrangleCreator quadrangleCreator;

    @BeforeClass
    public void setUp() {
        quadrangleCreator = new QuadrangleCreator();
    }

    @AfterClass
    public void tearDown() {
        quadrangleCreator = null;
    }

    @DataProvider(name = "createQuadranglePositiveData")
    public Object[][] createCreateQuadranglePositiveData() {
        List<Double> numbers1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        Quadrangle quadrangle1 = createQuadrangle(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        List<Double> numbers2 = Arrays.asList(-1.0, -.0, 6.0, 4.0, 5.0, 2.0, 7.0, 3.0);
        Quadrangle quadrangle2 = createQuadrangle(-1.0, -.0, 6.0, 4.0, 5.0, 2.0, 7.0, 3.0);
        return new Object[][]{
                {numbers1, quadrangle1},
                {numbers2, quadrangle2}
        };
    }

    @Test(dataProvider = "createQuadranglePositiveData")
    public void createQuadranglePositiveTest(
            List<Double> numbers, Quadrangle expected) {
        Quadrangle actual = quadrangleCreator.createQuadrangle(numbers);
        boolean result = actual.equalsQuadrangle(expected);
        assertTrue(result);
    }

    @DataProvider(name = "createQuadrangleNegativeData")
    public Object[][] createCreateQuadrangleNegativeData() {
        List<Double> numbers1 = Arrays.asList(1., 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        Quadrangle quadrangle1 = createQuadrangle(-1, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        List<Double> numbers2 = Arrays.asList(-1.0, -.0, 6.0, 4.0, 5.0, 2.0, 7.0, 3.0);
        Quadrangle quadrangle2 = createQuadrangle(-1.0, .0, 6.0, 4.0, 5.0, 2.0, 7.0, 3.0);
        return new Object[][]{
                {numbers1, quadrangle1},
                {numbers2, quadrangle2}
        };
    }

    @Test(dataProvider = "createQuadrangleNegativeData")
    public void createQuadrangleNegativeTest(
            List<Double> numbers, Quadrangle expected) {
        Quadrangle actual = quadrangleCreator.createQuadrangle(numbers);
        boolean result = actual.equalsQuadrangle(expected);
        assertFalse(result);
    }

    private boolean equalsQuadrangleList(
            List<Quadrangle> quadrangles1, List<Quadrangle> quadrangles2) {
        boolean result = false;
        if (quadrangles1.size() == quadrangles2.size()) {
            result = true;
            for (int i = 0; i < quadrangles1.size() && result; i++) {
                result = quadrangles1.get(i).equalsQuadrangle(quadrangles2.get(i));
            }
        }
        return result;
    }

    private Quadrangle createQuadrangle(double point1X, double point1Y,
                                        double point2X, double point2Y,
                                        double point3X, double point3Y,
                                        double point4X, double point4Y) {
        Point point1 = new Point(point1X, point1Y);
        Point point2 = new Point(point2X, point2Y);
        Point point3 = new Point(point3X, point3Y);
        Point point4 = new Point(point4X, point4Y);
        return new Quadrangle(point1, point2, point3, point4);
    }
}
