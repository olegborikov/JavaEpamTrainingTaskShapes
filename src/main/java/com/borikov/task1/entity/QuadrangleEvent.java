package com.borikov.task1.entity;

import com.borikov.task1.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {
    public QuadrangleEvent(Object source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle) super.getSource();
    }
}
