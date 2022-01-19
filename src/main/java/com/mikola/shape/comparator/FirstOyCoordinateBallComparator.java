package com.mikola.shape.comparator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;

import java.util.Comparator;

public class FirstOyCoordinateBallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball firstBall, Ball secondBall) {
        Point firstCenter = firstBall.getCenter();
        Point secondCenter = secondBall.getCenter();
        double firstBallOyCoodinate = firstCenter.getY() - firstBall.getRadius();
        double secondBallOyCoordinate = secondCenter.getY() - secondBall.getRadius();
        return Double.compare(firstBallOyCoodinate, secondBallOyCoordinate);
    }
}
