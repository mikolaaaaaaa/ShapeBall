package com.mikola.shape.action;

import com.mikola.shape.entity.Ball;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallLogic {
    private static final Logger LOGGER = LogManager.getLogger(BallLogic.class);

    public double calculateSurfaceArea(Ball ball) {
        double surfaceArea = 4 * Math.PI * Math.pow(ball.getRadius(), 2);
        LOGGER.debug("Surface area #{} is #{}", ball, surfaceArea);
        return surfaceArea;
    }


    public double calculateVolume(Ball ball) {
        double volume = Math.PI * Math.pow(ball.getRadius(), 2) / 3;
        LOGGER.debug("Volume #{} is #{}", ball, volume);
        return Math.PI * Math.pow(ball.getRadius(), 2) / 3;
    }

    public boolean isBall(Ball ball) {
        return ball.getRadius() > 0;
    }

    public boolean isPertainsCoordinatedPlanes(Ball ball) {
        double x = ball.getCenter().getX();
        double y = ball.getCenter().getY();
        double z = ball.getCenter().getZ();

        return (Double.compare(x, ball.getRadius()) == 0 ||
                Double.compare(y, ball.getRadius()) == 0 ||
                Double.compare(z, ball.getRadius()) == 0);
    }
}
