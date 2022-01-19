package com.mikola.shape.comparator;

import com.mikola.shape.action.BallLogic;
import com.mikola.shape.entity.Ball;

import java.util.Comparator;

public class SurfaceAreaBallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball firstBall, Ball secondBall) {
        BallLogic ballLogic = new BallLogic();
        double firstSurfaceArea = 0;
        double secondSurfaceArea = 0;
        firstSurfaceArea = ballLogic.calculateSurfaceArea(firstBall);
        secondSurfaceArea = ballLogic.calculateSurfaceArea(secondBall);
        return Double.compare(firstSurfaceArea, secondSurfaceArea);
    }
}
