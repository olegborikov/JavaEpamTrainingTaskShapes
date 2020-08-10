package com.borikov.task1.repository;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.factory.QuadrangleCreator;
import com.borikov.task1.factory.impl.QuadrangleCreatorImpl;
import com.borikov.task1.specification.Specification;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository {
    private static QuadrangleRepository instance;
    private static List<Quadrangle> quadrangles;
    private static final String FILE_NAME = "data/data.txt";

    private QuadrangleRepository() {
    }

    public static QuadrangleRepository getInstance() {
        if (instance == null) {
            instance = new QuadrangleRepository();
            QuadrangleCreator quadrangleCreator = new QuadrangleCreatorImpl();
            quadrangles = quadrangleCreator.createQuadrangles(FILE_NAME);
        }
        return instance;
    }

    public List<Quadrangle> query(Specification specification) {
        return quadrangles.stream().filter(q -> specification.test(q))
                .collect(Collectors.toList());
    }

    public List<Quadrangle> query(Comparator<Quadrangle> comparator) {
        return quadrangles.stream().sorted(comparator).collect(Collectors.toList());
    }

    public boolean add(Quadrangle quadrangle) {
        return false;
    }

    public boolean remove(Quadrangle quadrangle) {
        return false;
    }

    public boolean update(Quadrangle quadrangle) {
        return false;
    }

    public List<Quadrangle> get() {
        return Collections.unmodifiableList(quadrangles);
    }
}
