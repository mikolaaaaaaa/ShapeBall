package com.mikola.shape.repository;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;

import java.util.Comparator;
import java.util.List;

public interface Repository {

    public void add(Ball ball);

    public void remove(Ball ball);

    public void update(Ball ball);

    public List<Ball> query(Specification specification) throws BallException;

    public List<Ball> sort(Comparator<Ball> comparator);

}
