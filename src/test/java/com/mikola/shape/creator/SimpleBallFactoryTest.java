package com.mikola.shape.creator;


import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleBallFactoryTest {
    @Test
    public void testCreateBall() throws BallException {
        Ball expected = new Ball(new Point(1d,1d,1d),1);
        SimpleBallFactory simpleBallFactory = new SimpleBallFactory();
        Ball actual = simpleBallFactory.createBall(new Point(1d,1d,1d),1);
        Assertions.assertEquals(expected,actual);
    }
}
