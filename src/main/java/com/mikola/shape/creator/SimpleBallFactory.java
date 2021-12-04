package com.mikola.shape.creator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleBallFactory {
    private static final Logger logger = LogManager.getLogger(SimpleBallFactory.class);

    public Ball createBall(Point point, double radius) throws BallException {
        if (point == null) {
            throw new BallException("Given point is null");
        }
        logger.info("Ball object created");
        return new Ball(point,radius);
    }

}
