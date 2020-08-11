package com.borikov.task1.warehouse;

import com.borikov.task1.entity.QuadrangleDataHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private static Map<Long, QuadrangleDataHandler> quadranglesData = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public QuadrangleDataHandler get(long key) {
        return quadranglesData.get(key);
    }

    public QuadrangleDataHandler put(long key, QuadrangleDataHandler value) {
        return quadranglesData.put(key, value);
    }

    public QuadrangleDataHandler remove(long key) {
        return quadranglesData.remove(key);
    }

    public Map<Long, QuadrangleDataHandler> getAll() {
        return Collections.unmodifiableMap(quadranglesData);
    }
}
