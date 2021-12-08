package com.mikola.shape.repository.impl;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.repository.BallRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BallRepositoryImpl implements BallRepository {

    private Map<Long, Ball> store = new HashMap<>();

    @Override
    public void add(Ball ball) {
        store.put(ball.getId(), ball);
    }

    @Override
    public void remove(Ball ball) {
        store.remove(ball);
    }

    @Override
    public void update(Ball ball) {
    }

    @Override
    public void query(Ball ball) {

    }

    @Override
    public void sort(Comparator<Ball> comparator) {

    }
}
