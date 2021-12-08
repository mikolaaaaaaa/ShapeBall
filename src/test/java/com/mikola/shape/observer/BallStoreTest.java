package com.mikola.shape.observer;

import com.mikola.shape.action.impl.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.BallParameters;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BallStoreTest {
    private Ball ball;
    private BallStore ballStore;
    private BallLogic ballService;

    @BeforeEach
    public void setUp() throws BallException {
        ball = new Ball(new Point(1,1,1),2);
        ballStore = BallStore.getInstance();
        ballService = new BallLogic();
        ball.attach(ballStore);
        ball.setRadius(3);
    }

    @Test
    public void testBallStoreVolume() throws BallException {
        double expected = ballService.calculateVolume(ball);
        Map<Long, BallParameters> ballsMap = ballStore.getBallMap();
        double actual = ballsMap
                .get(ball.getId())
                .getVolume();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testBallStoreSurfaceAres() throws BallException {
        double expected = ballService.calculateSurfaceArea(ball);
        Map<Long, BallParameters> ballsMap = ballStore.getBallMap();
        double actual = ballsMap
                .get(ball.getId())
                .getSurfaceArea();
        Assertions.assertEquals(expected,actual);
    }
}
