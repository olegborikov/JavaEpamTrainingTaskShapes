package com.borikov.task1.repository;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository {
    private static QuadrangleRepository instance;
    private static List<Quadrangle> quadrangles = new ArrayList<>();

    private QuadrangleRepository() {
    }

    public static QuadrangleRepository getInstance() {
        if (instance == null) {
            instance = new QuadrangleRepository();
        }
        return instance;
    }

    public List<Quadrangle> query(Specification<Quadrangle> specification) {
        return quadrangles.stream().filter(q -> specification.specify(q))
                .collect(Collectors.toList());
    }

    public List<Quadrangle> sort(Comparator<Quadrangle> comparator) {
        return quadrangles.stream().sorted(comparator).collect(Collectors.toList());
    }

    public boolean add(Quadrangle quadrangle) {
        boolean result = false;
        if (quadrangles.stream().noneMatch(q -> q.equalsQuadrangle(quadrangle))) {
            result = quadrangles.add(quadrangle);
        }
        return result;
    }

    public boolean remove(Quadrangle quadrangle) {
        return quadrangles.remove(quadrangle);
    }

    public List<Quadrangle> getAll() {
        return Collections.unmodifiableList(quadrangles);
    }
}
