package com.mikola.shape.action.impl;

import com.mikola.shape.action.ShapeLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallLogic implements ShapeLogic {
    private static final Logger logger = LogManager.getLogger(BallLogic.class);

    @Override
    public double calculateSurfaceArea(Ball ball) throws BallException {
        if (ball == null) {
            throw new BallException("Given object is null");
        }
        double surfaceArea = 4 * Math.PI * Math.pow(ball.getRadius(), 2);
        logger.debug("Surface area #{} is #{}", ball, surfaceArea);
        return surfaceArea;
    }

    @Override
    public double calculateVolume(Ball ball) throws BallException {
        if (ball == null) {
            throw new BallException("Given object is null");
        }
        double volume = Math.PI * Math.pow(ball.getRadius(), 2) / 3;
        logger.debug("Volume #{} is #{}", ball, volume);
        return Math.PI * Math.pow(ball.getRadius(), 2) / 3;
    }

    @Override
    public boolean isBall(Ball ball) throws BallException {
        if (ball == null) {
            throw new BallException("Given object is null");
        }
        return (ball.getRadius() > 0);
    }

    @Override
    public boolean isPertainsCoordinatedPlanes(Ball ball) throws BallException {
        if (ball == null) {
            throw new BallException("Given object is null");
        }

        double x = ball.getCenter().getX();
        double y = ball.getCenter().getY();
        double z = ball.getCenter().getZ();

        return (Double.compare(x, ball.getRadius()) == 0 ||
                Double.compare(y, ball.getRadius()) == 0 ||
                Double.compare(z, ball.getRadius()) == 0);
    }
}
