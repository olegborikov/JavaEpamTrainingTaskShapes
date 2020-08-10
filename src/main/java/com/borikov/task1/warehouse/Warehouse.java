package com.borikov.task1.warehouse;

import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private static Map<Long,> quadrangles;

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }
}
