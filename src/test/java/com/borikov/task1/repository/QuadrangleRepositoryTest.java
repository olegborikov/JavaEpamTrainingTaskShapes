package com.borikov.task1.repository;

import com.borikov.task1.comparator.QuadrangleIdComparator;
import com.borikov.task1.comparator.QuadranglePoint1XComparator;
import com.borikov.task1.comparator.QuadranglePoint4YComparator;
import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.QuadrangleSpecification;
import com.borikov.task1.specification.impl.QuadrangleCurrentIdSpecification;
import com.borikov.task1.specification.impl.QuadrangleInsideFirstQuadrantSpecification;
import com.borikov.task1.specification.impl.QuadrangleInsideFourthQuadrantSpecification;
import com.borikov.task1.specification.impl.QuadrangleRangePerimeterSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleRepositoryTest {
    private QuadrangleRepository quadrangleRepository;
    private Quadrangle quadrangle1;
    private Quadrangle quadrangle2;
    private Quadrangle quadrangle3;
    private Quadrangle quadrangle4;
    private Quadrangle quadrangle5;

    @BeforeClass
    public void setUp() {
        quadrangleRepository = QuadrangleRepository.getInstance();
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 1);
        quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(0, 0);
        Point point6 = new Point(0, 1);
        Point point7 = new Point(5, 5);
        Point point8 = new Point(5, 0);
        quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(1, 2);
        Point point10 = new Point(7, 4);
        Point point11 = new Point(13, 2);
        Point point12 = new Point(7, 0);
        quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        Point point13 = new Point(0, 1.5);
        Point point14 = new Point(1, 2);
        Point point15 = new Point(1.15, 0);
        Point point16 = new Point(0, 0);
        quadrangle4 = new Quadrangle(point13, point14, point15, point16);
        Point point17 = new Point(0, 0);
        Point point18 = new Point(0, 0);
        Point point19 = new Point(0, 0);
        Point point20 = new Point(0, 0);
        quadrangle5 = new Quadrangle(point17, point18, point19, point20);
    }

    @AfterClass
    public void tearDown() {
        quadrangleRepository = null;
        quadrangle1 = null;
        quadrangle2 = null;
        quadrangle3 = null;
        quadrangle4 = null;
        quadrangle5 = null;
    }

    @DataProvider(name = "addData")
    public Object[][] createAddData() {
        return new Object[][]{
                {quadrangle1},
                {quadrangle2},
                {quadrangle3},
                {quadrangle4},
                {quadrangle5}
        };
    }

    @Test(dataProvider = "addData", priority = 1)
    public void addTest(Quadrangle quadrangle) {
        boolean actual = quadrangleRepository.add(quadrangle);
        assertTrue(actual);
    }

    @Test(priority = 2)
    public void getAllTest() {
        List<Quadrangle> expected = new ArrayList<>();
        expected.add(quadrangle1);
        expected.add(quadrangle2);
        expected.add(quadrangle3);
        expected.add(quadrangle4);
        expected.add(quadrangle5);
        List<Quadrangle> actual = quadrangleRepository.getAll();
        assertEquals(actual, expected);
    }

    @Test(priority = 3)
    public void removeTest() {
        quadrangleRepository.remove(quadrangle5);
        List<Quadrangle> expected = new ArrayList<>();
        expected.add(quadrangle1);
        expected.add(quadrangle2);
        expected.add(quadrangle3);
        expected.add(quadrangle4);
        List<Quadrangle> actual = quadrangleRepository.getAll();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "queryPositiveData")
    public Object[][] createQueryPositiveData() {
        QuadrangleSpecification specification1 =
                new QuadrangleCurrentIdSpecification(quadrangle1.getQuadrangleId());
        List<Quadrangle> expected1 = new ArrayList<>();
        expected1.add(quadrangle1);
        QuadrangleSpecification specification2 =
                new QuadrangleInsideFirstQuadrantSpecification();
        List<Quadrangle> expected2 = new ArrayList<>();
        expected2.add(quadrangle1);
        expected2.add(quadrangle2);
        expected2.add(quadrangle3);
        expected2.add(quadrangle4);
        QuadrangleSpecification specification3 =
                new QuadrangleInsideFourthQuadrantSpecification();
        List<Quadrangle> expected3 = new ArrayList<>();
        QuadrangleSpecification specification4 =
                new QuadrangleRangePerimeterSpecification(0, 6);
        List<Quadrangle> expected4 = new ArrayList<>();
        expected4.add(quadrangle4);
        return new Object[][]{
                {specification1, expected1},
                {specification2, expected2},
                {specification3, expected3},
                {specification4, expected4}
        };
    }

    @Test(dataProvider = "queryPositiveData", priority = 4)
    public void queryPositiveTest
            (QuadrangleSpecification specification, List<Quadrangle> expected) {
        List<Quadrangle> actual = quadrangleRepository.query(specification);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "queryNegativeData")
    public Object[][] createQueryNegativeData() {
        QuadrangleSpecification specification1 =
                new QuadrangleCurrentIdSpecification(quadrangle1.getQuadrangleId());
        List<Quadrangle> expected1 = new ArrayList<>();
        expected1.add(quadrangle1);
        expected1.add(quadrangle1);
        QuadrangleSpecification specification2 =
                new QuadrangleInsideFirstQuadrantSpecification();
        List<Quadrangle> expected2 = new ArrayList<>();
        expected2.add(quadrangle1);
        expected2.add(quadrangle2);
        expected2.add(quadrangle3);
        QuadrangleSpecification specification3 =
                new QuadrangleInsideFourthQuadrantSpecification();
        List<Quadrangle> expected3 = null;
        QuadrangleSpecification specification4 =
                new QuadrangleRangePerimeterSpecification(0, 6);
        List<Quadrangle> expected4 = new ArrayList<>();
        expected4.add(quadrangle3);
        return new Object[][]{
                {specification1, expected1},
                {specification2, expected2},
                {specification3, expected3},
                {specification4, expected4}
        };
    }

    @Test(dataProvider = "queryNegativeData", priority = 4)
    public void queryNegativeTest(
            QuadrangleSpecification specification, List<Quadrangle> expected) {
        List<Quadrangle> actual = quadrangleRepository.query(specification);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "sortPositiveData")
    public Object[][] createSortPositiveData() {
        Comparator<Quadrangle> comparator1 = new QuadrangleIdComparator();
        List<Quadrangle> expected1 = new ArrayList<>();
        expected1.add(quadrangle1);
        expected1.add(quadrangle2);
        expected1.add(quadrangle3);
        expected1.add(quadrangle4);
        Comparator<Quadrangle> comparator2 = new QuadranglePoint1XComparator();
        List<Quadrangle> expected2 = new ArrayList<>();
        expected2.add(quadrangle2);
        expected2.add(quadrangle4);
        expected2.add(quadrangle1);
        expected2.add(quadrangle3);
        Comparator<Quadrangle> comparator3 = new QuadranglePoint4YComparator();
        List<Quadrangle> expected3 = new ArrayList<>();
        expected3.add(quadrangle2);
        expected3.add(quadrangle3);
        expected3.add(quadrangle4);
        expected3.add(quadrangle1);
        return new Object[][]{
                {comparator1, expected1},
                {comparator2, expected2},
                {comparator3, expected3}
        };
    }

    @Test(dataProvider = "sortPositiveData", priority = 5)
    public void sortPositiveTest(
            Comparator<Quadrangle> comparator, List<Quadrangle> expected) {
        List<Quadrangle> actual = quadrangleRepository.sort(comparator);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "sortNegativeData")
    public Object[][] createSortNegativeData() {
        Comparator<Quadrangle> comparator1 = new QuadrangleIdComparator();
        List<Quadrangle> expected1 = new ArrayList<>();
        expected1.add(quadrangle1);
        expected1.add(quadrangle2);
        expected1.add(quadrangle3);
        Comparator<Quadrangle> comparator2 = new QuadranglePoint1XComparator();
        List<Quadrangle> expected2 = new ArrayList<>();
        expected2.add(quadrangle2);
        expected2.add(quadrangle4);
        expected2.add(quadrangle3);
        expected2.add(quadrangle1);
        Comparator<Quadrangle> comparator3 = new QuadranglePoint4YComparator();
        List<Quadrangle> expected3 = new ArrayList<>();
        expected3.add(quadrangle3);
        expected3.add(quadrangle2);
        expected3.add(quadrangle4);
        expected3.add(quadrangle1);
        return new Object[][]{
                {comparator1, expected1},
                {comparator2, expected2},
                {comparator3, expected3}
        };
    }

    @Test(dataProvider = "sortNegativeData", priority = 5)
    public void sortNegativeTest(
            Comparator<Quadrangle> comparator, List<Quadrangle> expected) {
        List<Quadrangle> actual = quadrangleRepository.sort(comparator);
        assertNotEquals(actual, expected);
    }
}
