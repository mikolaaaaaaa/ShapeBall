package com.mikola.shape.comparator;

import com.mikola.shape.entity.Ball;

import java.util.Comparator;

public class IdBallComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball firstBall, Ball secondBall) {
        return Long.compare(firstBall.getId(), secondBall.getId());
    }
}
