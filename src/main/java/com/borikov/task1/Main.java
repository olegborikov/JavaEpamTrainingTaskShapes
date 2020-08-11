package com.borikov.task1;

import com.borikov.task1.entity.Point;
import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = Warehouse.getInstance();
        Point point1 = new Point(1,1);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(2, 2);
        Point point4 = new Point(2,1);
        System.out.println(warehouse.getAll());
        Quadrangle quadrangle = new Quadrangle(point1, point2, point3, point4);
        System.out.println(warehouse.getAll());
    }
}
