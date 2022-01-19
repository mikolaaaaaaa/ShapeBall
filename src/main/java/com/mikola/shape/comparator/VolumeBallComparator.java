package com.mikola.shape.comparator;

import com.mikola.shape.action.BallLogic;
import com.mikola.shape.entity.Ball;

import java.util.Comparator;

public class VolumeBallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball firstBall, Ball secondBall) {
        BallLogic ballLogic = new BallLogic();
        double firstVolume = 0;
        double secondVolume = 0;
        firstVolume = ballLogic.calculateVolume(firstBall);
        secondVolume = ballLogic.calculateVolume(secondBall);
        return Double.compare(firstVolume, secondVolume);
    }
}
