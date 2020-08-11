package com.borikov.task1.observer.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.entity.QuadrangleDataHandler;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.observer.Observer;
import com.borikov.task1.entity.QuadrangleEvent;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;
import com.borikov.task1.warehouse.Warehouse;

public class QuadrangleDataObserver implements Observer<QuadrangleEvent> {

    @Override
    public void actionPerformed(QuadrangleEvent quadrangleEvent) {
        try {
            Quadrangle quadrangle = quadrangleEvent.getSource();
            QuadrangleArithmeticService quadrangleArithmeticService = new QuadrangleArithmeticServiceImpl();
            double quadranglePerimeter = quadrangleArithmeticService.calculatePerimeter(quadrangle);
            double quadrangleSquare = quadrangleArithmeticService.calculateSquare(quadrangle);
            QuadrangleDataHandler quadrangleDataKeeper = new QuadrangleDataHandler(quadranglePerimeter, quadrangleSquare);
            Warehouse warehouse = Warehouse.getInstance();
            warehouse.put(quadrangle.getQuadrangleId(), quadrangleDataKeeper);
        } catch (IncorrectDataException e) {
            // TODO: 11.08.2020 log
        }
    }
}
