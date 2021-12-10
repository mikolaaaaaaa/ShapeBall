package com.mikola.shape.creator;


import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleBallFactoryTest {
    @Test
    public void testCreateBallShouldCreateBall() throws BallException {
        //given
        Point center = new Point(1, 1, 1);
        double radius = 1;
        Ball expected = new Ball(center, radius);
        SimpleBallFactory simpleBallFactory = new SimpleBallFactory();
        //when
        Ball actual = simpleBallFactory.createBall(center, radius);
        //then
        Assertions.assertEquals(expected, actual);
    }
}
