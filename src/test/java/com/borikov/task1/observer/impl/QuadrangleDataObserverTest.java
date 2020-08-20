package com.borikov.task1.observer.impl;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.entity.QuadrangleDataHandler;
import com.borikov.task1.observer.QuadrangleEvent;
import com.borikov.task1.warehouse.Warehouse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuadrangleDataObserverTest {
    private QuadrangleDataObserver quadrangleDataObserver;
    private Warehouse warehouse;

    @BeforeClass
    public void setUp() {
        quadrangleDataObserver = new QuadrangleDataObserver();
        warehouse = Warehouse.getInstance();
    }

    @AfterClass
    public void tearDown() {
        quadrangleDataObserver = null;
        warehouse = null;
    }

    @DataProvider(name = "actionPerformedPositiveData")
    public Object[][] createActionPerformedPositiveData() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Point point5 = new Point(-1, -1);
        Point point6 = new Point(-1, 1);
        Point point7 = new Point(1, 1);
        Point point8 = new Point(1, -1);
        Quadrangle quadrangle2 = new Quadrangle(point5, point6, point7, point8);
        Point point9 = new Point(0, 0);
        Point point10 = new Point(0, 1);
        Point point11 = new Point(5, 5);
        Point point12 = new Point(5, 0);
        Quadrangle quadrangle3 = new Quadrangle(point9, point10, point11, point12);
        return new Object[][]{
                {new QuadrangleEvent(quadrangle1)},
                {new QuadrangleEvent(quadrangle2)},
                {new QuadrangleEvent(quadrangle3)}
        };
    }

    @Test(dataProvider = "actionPerformedPositiveData")
    public void actionPerformedPositiveTest(QuadrangleEvent quadrangleEvent) {
        quadrangleDataObserver.actionPerformed(quadrangleEvent);
        QuadrangleDataHandler quadrangleDataHandler =
                warehouse.get(quadrangleEvent.getSource().getQuadrangleId());
        assertNotNull(quadrangleDataHandler);
    }

    @DataProvider(name = "actionPerformedNegativeData")
    public Object[][] createActionPerformedNegativeData() {
        Point point1 = new Point(10, 7);
        Point point2 = new Point(0, 5);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(5, 0);
        Quadrangle quadrangle1 = new Quadrangle(point1, point2, point3, point4);
        Quadrangle quadrangle2 = new Quadrangle(point1, point1, point3, point4);
        Quadrangle quadrangle3 = new Quadrangle(point1, null, point3, point4);
        return new Object[][]{
                {new QuadrangleEvent(quadrangle1)},
                {new QuadrangleEvent(quadrangle2)},
                {new QuadrangleEvent(quadrangle3)}
        };
    }

    @Test(dataProvider = "actionPerformedNegativeData")
    public void actionPerformedNegativeTest(QuadrangleEvent quadrangleEvent) {
        quadrangleDataObserver.actionPerformed(quadrangleEvent);
        QuadrangleDataHandler quadrangleDataHandler =
                warehouse.get(quadrangleEvent.getSource().getQuadrangleId());
        assertNull(quadrangleDataHandler);
    }
}
