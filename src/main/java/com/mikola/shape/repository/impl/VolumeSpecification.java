package com.mikola.shape.repository.impl;

import com.mikola.shape.action.impl.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.Specification;

public class VolumeSpecification implements Specification {
    private final double from;
    private final double to;

    public VolumeSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) throws BallException {
        BallLogic ballLogic = new BallLogic();
        double volume = ballLogic.calculateVolume(ball);
        return volume >= from && volume <= to;
    }
}
