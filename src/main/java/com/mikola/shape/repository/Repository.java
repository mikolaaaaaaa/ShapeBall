package com.mikola.shape.repository;

import com.mikola.shape.entity.Ball;

import java.util.Comparator;

public interface BallRepository {

    public void add(Ball ball);
    public void remove(Ball ball);
    public void update(Ball ball);
    public void query();
    public void sort(Comparator<Ball> comparator);

}
