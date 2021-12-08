package com.mikola.shape.repository;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;

public interface Specification {
    public boolean specify(Ball ball) throws BallException;
}
