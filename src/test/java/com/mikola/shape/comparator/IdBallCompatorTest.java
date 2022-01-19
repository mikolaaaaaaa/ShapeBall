package com.mikola.shape.comparator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdBallCompatorTest {
    private static final IdBallComparator comparator = new IdBallComparator();
    private static final Ball FIRST_BALL = new Ball(new Point(1, 1, 1), 1);
    private static final Ball SECOND_BALL = new Ball(new Point(2, 2, 2), 2);

    @Test
    public void testCompareShouldReturnMinusOne() {
        int expected = -1;
        int actual = comparator.compare(FIRST_BALL,SECOND_BALL);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testCompareShouldReturnOne() {
        int expected = 1;
        int actual = comparator.compare(SECOND_BALL,FIRST_BALL);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testCompareShouldReturnZero() {
        int expected = 0;
        int actual = comparator.compare(FIRST_BALL,FIRST_BALL);
        Assertions.assertEquals(expected,actual);
    }
}
