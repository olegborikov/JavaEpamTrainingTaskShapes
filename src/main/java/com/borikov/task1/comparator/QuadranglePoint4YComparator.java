package com.borikov.task1.comparator;

import com.borikov.task1.entity.Quadrangle;

import java.util.Comparator;

public class QuadranglePoint4YComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        return Double.compare(o1.getPoint4().getY(), o2.getPoint4().getY());
    }
}
