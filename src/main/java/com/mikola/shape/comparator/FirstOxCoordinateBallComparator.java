package com.mikola.shape.comparator;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;

import java.util.Comparator;

public class FirstOxCoordinateBallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball firstBall, Ball secondBall) {
        Point firstCenter = firstBall.getCenter();
        Point secondCenter = secondBall.getCenter();
        double firstBallOxCoordinate = firstCenter.getX() - firstBall.getRadius();
        double secondBallOxCoordinate = secondCenter.getX() - secondBall.getRadius();
        return Double.compare(firstBallOxCoordinate, secondBallOxCoordinate);
    }
}
