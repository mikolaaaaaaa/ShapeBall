package com.mikola.shape.creator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleBallFactory {
    private static final Logger LOGGER = LogManager.getLogger(SimpleBallFactory.class);

    public Ball create(Point point, double radius) {
        LOGGER.info("Ball object created");
        return new Ball(point, radius);
    }

}
