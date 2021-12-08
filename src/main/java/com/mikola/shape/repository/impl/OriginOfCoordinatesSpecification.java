package com.mikola.shape.repository.impl;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.Specification;

public class OriginOfCoordinatesSpecification implements Specification {
    private final double from;
    private final double to;

    public OriginOfCoordinatesSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) throws BallException {
        Point point = ball.getCenter();
        double distanceBetweenCenter = Math.sqrt(
                Math.pow(point.getX(),2)
                + Math.pow(point.getY(),2)
                + Math.pow((point.getZ()),2));
        double firstSumOfRadius = from + ball.getRadius();
        double secondSumOfRadius = to + ball.getRadius();
        return distanceBetweenCenter <= firstSumOfRadius || distanceBetweenCenter <= secondSumOfRadius;
    }
}
