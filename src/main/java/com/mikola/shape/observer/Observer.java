package com.mikola.shape.observer;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;

public interface Observer {
    public void update(Ball ball) throws BallException;
}
