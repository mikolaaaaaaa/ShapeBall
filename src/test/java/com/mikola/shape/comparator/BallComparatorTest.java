package com.mikola.shape.comparator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BallComparatorTest {
    private final Ball firstBall = new Ball(new Point(1, 1, 1), 1);
    private final Ball secondBall = new Ball(new Point(2, 2, 2), 2);
    private final Ball thirdBall = new Ball(new Point(3, 3, 3), 3);


    @Test
    public void testGetIdComparatorShouldCompareBallsById() {
        BallComparator ballComparator = new BallComparator();
        List<Ball> actual = new ArrayList<>(List.of(firstBall, thirdBall, secondBall));
        actual.sort(ballComparator.getIdComparator());
        List<Ball> expected = List.of(firstBall, secondBall, thirdBall);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstOxCoordinateComparatorShouldCompareByFirstOxCoordinate() {
        BallComparator ballComparator = new BallComparator();
        List<Ball> actual = new ArrayList<>(List.of(firstBall, thirdBall, secondBall));
        actual.sort(ballComparator.getFirstOxCoordinateComparator());
        List<Ball> expected = List.of(firstBall, thirdBall, secondBall);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstOyCoordinateComparatorShouldCompareByFirstOyCoordinate() {
        BallComparator ballComparator = new BallComparator();
        List<Ball> actual = new ArrayList<>(List.of(firstBall, thirdBall, secondBall));
        actual.sort(ballComparator.getVolumeComparator());
        List<Ball> expected = List.of(firstBall, secondBall, thirdBall);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetVolumeComparatorShouldCompareByVolume() {
        BallComparator ballComparator = new BallComparator();
        List<Ball> actual = new ArrayList<>(List.of(firstBall, thirdBall, secondBall));
        actual.sort(ballComparator.getVolumeComparator());
        List<Ball> expected = List.of(firstBall, secondBall, thirdBall);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetSurfaceAreaComparatorShouldCompareBySurfaceArea() {
        BallComparator ballComparator = new BallComparator();
        List<Ball> actual = new ArrayList<>(List.of(firstBall, thirdBall, secondBall));
        actual.sort(ballComparator.getSurfaceAreaComparator());
        List<Ball> expected = List.of(firstBall, secondBall, thirdBall);
        Assertions.assertEquals(expected, actual);
    }
}
