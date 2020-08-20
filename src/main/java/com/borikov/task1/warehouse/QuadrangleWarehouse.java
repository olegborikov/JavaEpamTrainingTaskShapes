package com.borikov.task1.warehouse;

import com.borikov.task1.entity.QuadrangleDataHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QuadrangleWarehouse {
    private static QuadrangleWarehouse instance;
    private static Map<Long, QuadrangleDataHandler> quadrangleData = new HashMap<>();

    private QuadrangleWarehouse() {
    }

    public static QuadrangleWarehouse getInstance() {
        if (instance == null) {
            instance = new QuadrangleWarehouse();
        }
        return instance;
    }

    public QuadrangleDataHandler get(long key) {
        return quadrangleData.get(key);
    }

    public QuadrangleDataHandler put(long key, QuadrangleDataHandler value) {
        return quadrangleData.put(key, value);
    }

    public QuadrangleDataHandler remove(long key) {
        return quadrangleData.remove(key);
    }

    public Map<Long, QuadrangleDataHandler> getAll() {
        return Collections.unmodifiableMap(quadrangleData);
    }
}
