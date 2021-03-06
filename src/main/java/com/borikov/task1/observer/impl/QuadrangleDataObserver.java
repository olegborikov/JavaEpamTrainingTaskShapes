package com.borikov.task1.observer.impl;

import com.borikov.task1.entity.Quadrangle;
import com.borikov.task1.entity.QuadrangleDataHandler;
import com.borikov.task1.exception.IncorrectDataException;
import com.borikov.task1.observer.Observer;
import com.borikov.task1.observer.QuadrangleEvent;
import com.borikov.task1.service.QuadrangleArithmeticService;
import com.borikov.task1.service.impl.QuadrangleArithmeticServiceImpl;
import com.borikov.task1.warehouse.QuadrangleWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleDataObserver implements Observer<QuadrangleEvent> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void actionPerformed(QuadrangleEvent quadrangleEvent) {
        Quadrangle quadrangle = quadrangleEvent.getSource();
        try {
            QuadrangleArithmeticService quadrangleArithmeticService =
                    new QuadrangleArithmeticServiceImpl();
            double quadranglePerimeter =
                    quadrangleArithmeticService.calculatePerimeter(quadrangle);
            double quadrangleSquare =
                    quadrangleArithmeticService.calculateSquare(quadrangle);
            QuadrangleDataHandler quadrangleDataKeeper =
                    new QuadrangleDataHandler(quadranglePerimeter, quadrangleSquare);
            QuadrangleWarehouse quadrangleWarehouse = QuadrangleWarehouse.getInstance();
            quadrangleWarehouse.put(quadrangle.getQuadrangleId(), quadrangleDataKeeper);
        } catch (IncorrectDataException e) {
            LOGGER.log(Level.WARN, "Quadrangle wasn't add to warehouse: {}", quadrangle, e);
        }
    }
}
