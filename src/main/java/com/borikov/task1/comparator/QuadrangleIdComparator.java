package com.borikov.task1.comparator;

import com.borikov.task1.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        return Long.compare(o1.getQuadrangleId(), o2.getQuadrangleId());
    }
}
