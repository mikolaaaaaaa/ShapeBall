package com.mikola.shape.observer;

import com.mikola.shape.action.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.BallParameters;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BallStoreTest {
    private static final Ball BALL = new Ball(new Point(1, 1, 1), 2);;
    private static final BallStore ballStore = BallStore.getInstance();
    private static final BallLogic ballLogic = new BallLogic();

    @BeforeEach
    public void setUp() throws BallException {
        BALL.attach(ballStore);
        BALL.setRadius(3);
    }

    @Test
    public void testBallStoreVolumeShouldUpdateVolumeParameter() {
        double expected = ballLogic.calculateVolume(BALL);
        Map<Long, BallParameters> ballsMap = ballStore.getBallMap();
        double actual = ballsMap
                .get(BALL.getId())
                .getVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBallStoreSurfaceAreaShouldUpdateSurfaceAreaParameter() {
        double expected = ballLogic.calculateSurfaceArea(BALL);
        Map<Long, BallParameters> ballsMap = ballStore.getBallMap();
        double actual = ballsMap
                .get(BALL.getId())
                .getSurfaceArea();
        Assertions.assertEquals(expected, actual);
    }
}
