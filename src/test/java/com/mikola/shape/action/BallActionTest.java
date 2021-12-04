package com.mikola.shape.action;

import com.mikola.shape.action.impl.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallActionTest {

    Ball firstBall;
    Ball secondBall;
    Ball thirdBall;
    BallLogic ballService;

    @BeforeEach
    public void setUp() {
        firstBall = new Ball(new Point(1f,1f,1f),1f);
        secondBall = new Ball(new Point(2f,2f,2f),1);
        thirdBall = new Ball(new Point(1f,2f,3f),0);
        ballService = new BallLogic();
    }

    @Test
    public void testCalculateSurfaceArea() throws BallException {
        double expected = 4 * Math.PI * Math.pow(1, 2);
        double actual = ballService.calculateSurfaceArea(firstBall);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testCalculateVolume() throws BallException {
        double expected = Math.PI * Math.pow(1, 2) / 3;
        double actual = ballService.calculateVolume(firstBall);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void firstTestIsBall() throws BallException {
        boolean actual = ballService.isBall(firstBall);
        Assertions.assertTrue(actual);
    }

    @Test
    public void secondTestIsBall() throws BallException{
        boolean actual = ballService.isBall(thirdBall);
        Assertions.assertFalse(actual);
    }

    @Test
    public void firstTestIsPertainsCoordinatedPlanes() throws BallException {
        boolean actual = ballService.isPertainsCoordinatedPlanes(firstBall);
        Assertions.assertTrue(actual);
    }

    @Test
    public void secondTestIsPertainsCoordinatedPlanes() throws BallException {
        boolean actual = ballService.isPertainsCoordinatedPlanes(secondBall);
        Assertions.assertFalse(actual);
    }

}
