package com.mikola.shape.repository.impl;

import com.mikola.shape.action.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.Specification;

public class SurfaceAreaSpecification implements Specification {
    private final double from;
    private final double to;

    public SurfaceAreaSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) throws BallException {
        BallLogic ballLogic = new BallLogic();
        double surfaceArea = ballLogic.calculateSurfaceArea(ball);
        return surfaceArea >= from && surfaceArea <= to;
    }
}
