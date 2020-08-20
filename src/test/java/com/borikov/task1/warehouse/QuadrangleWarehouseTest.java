package com.borikov.task1.warehouse;

import com.borikov.task1.entity.QuadrangleDataHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class QuadrangleWarehouseTest {
    private QuadrangleWarehouse quadrangleWarehouse;
    private QuadrangleDataHandler quadrangleDataHandler1;
    private QuadrangleDataHandler quadrangleDataHandler2;
    private QuadrangleDataHandler quadrangleDataHandler3;
    private QuadrangleDataHandler quadrangleDataHandler4;
    private QuadrangleDataHandler quadrangleDataHandler5;

    @BeforeClass
    public void setUp() {
        quadrangleWarehouse = QuadrangleWarehouse.getInstance();
        quadrangleDataHandler1 = new QuadrangleDataHandler(1, 10);
        quadrangleDataHandler2 = new QuadrangleDataHandler(2, 20);
        quadrangleDataHandler3 = new QuadrangleDataHandler(4, 40);
        quadrangleDataHandler4 = new QuadrangleDataHandler(3, 30);
        quadrangleDataHandler5 = new QuadrangleDataHandler(5, 50);
    }

    @AfterClass
    public void tearDown() {
        quadrangleWarehouse = null;
        quadrangleDataHandler1 = null;
        quadrangleDataHandler2 = null;
        quadrangleDataHandler3 = null;
        quadrangleDataHandler4 = null;
        quadrangleDataHandler5 = null;
    }

    @DataProvider(name = "putData")
    public Object[][] createPutData() {
        return new Object[][]{
                {1, quadrangleDataHandler1},
                {2, quadrangleDataHandler2},
                {3, quadrangleDataHandler3},
                {4, quadrangleDataHandler4},
                {5, quadrangleDataHandler5}
        };
    }

    @Test(dataProvider = "putData")
    public void putTest(long key, QuadrangleDataHandler quadrangleDataHandler) {
        quadrangleWarehouse.put(key, quadrangleDataHandler);
    }

    @Test(dependsOnMethods = {"putTest"})
    public void getAllTest() {
        Map<Long, QuadrangleDataHandler> expected = new HashMap<>();
        expected.put(1L, quadrangleDataHandler1);
        expected.put(2L, quadrangleDataHandler2);
        expected.put(3L, quadrangleDataHandler3);
        expected.put(4L, quadrangleDataHandler4);
        expected.put(5L, quadrangleDataHandler5);
        Map<Long, QuadrangleDataHandler> actual = quadrangleWarehouse.getAll();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "getData")
    public Object[][] createGetData() {
        return new Object[][]{
                {1, quadrangleDataHandler1},
                {2, quadrangleDataHandler2},
                {3, quadrangleDataHandler3},
                {4, quadrangleDataHandler4},
                {5, quadrangleDataHandler5}
        };
    }

    @Test(dataProvider = "getData", dependsOnMethods = {"getAllTest"})
    public void getTest(long key, QuadrangleDataHandler expected) {
        QuadrangleDataHandler actual = quadrangleWarehouse.get(key);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = {"getTest"})
    public void removeTest() {
        quadrangleWarehouse.remove(3);
        Map<Long, QuadrangleDataHandler> expected = new HashMap<>();
        expected.put(1L, quadrangleDataHandler1);
        expected.put(2L, quadrangleDataHandler2);
        expected.put(4L, quadrangleDataHandler4);
        expected.put(5L, quadrangleDataHandler5);
        Map<Long, QuadrangleDataHandler> actual = quadrangleWarehouse.getAll();
        assertEquals(actual, expected);
    }
}
