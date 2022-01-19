package com.mikola.shape.action;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallActionTest {

    private static final Ball FIRST_BALL = new Ball(new Point(1f, 1f, 1f), 1f);
    private static final Ball SECOND_BALL = new Ball(new Point(2f, 2f, 2f), 1);
    private static final Ball THIRD_BALL = new Ball(new Point(1f, 2f, 3f), 0);
    private static final BallLogic ballLogic = new BallLogic();


    @Test
    public void testCalculateSurfaceAreaShouldCalculateSurfaceArea() throws BallException {
        double expected = 4 * Math.PI * Math.pow(1, 2);
        double actual = ballLogic.calculateSurfaceArea(FIRST_BALL);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateVolumeShouldCalculateVolume() throws BallException {
        double expected = Math.PI * Math.pow(1, 2) / 3;
        double actual = ballLogic.calculateVolume(FIRST_BALL);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstTestIsBallShouldCheckGoodData() throws BallException {
        boolean actual = ballLogic.isBall(FIRST_BALL);
        Assertions.assertTrue(actual);
    }

    @Test
    public void secondTestIsBallShouldCheckBadData() throws BallException {
        boolean actual = ballLogic.isBall(THIRD_BALL);
        Assertions.assertFalse(actual);
    }

    @Test
    public void firstTestIsPertainsCoordinatedPlanesShouldCheckGoodData() throws BallException {
        boolean actual = ballLogic.isPertainsCoordinatedPlanes(FIRST_BALL);
        Assertions.assertTrue(actual);
    }

    @Test
    public void secondTestIsPertainsCoordinatedPlanesShouldCheckBadData() throws BallException {
        boolean actual = ballLogic.isPertainsCoordinatedPlanes(SECOND_BALL);
        Assertions.assertFalse(actual);
    }

}
