package com.mikola.shape.repository.impl;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;
import com.mikola.shape.repository.Repository;
import com.mikola.shape.repository.Specification;

import java.util.*;

public class BallRepository implements Repository {

    private Map<Long, Ball> store = new HashMap<>();

    public Map<Long,Ball> getStore() {
        return Collections.unmodifiableMap(store);
    }

    @Override
    public void add(Ball ball) {
        store.put(ball.getId(), ball);
    }

    @Override
    public void remove(Ball ball) {
        store.remove(ball.getId());
    }

    @Override
    public void update(Ball ball) {
        store.put(ball.getId(),ball);
    }

    @Override
    public List<Ball> query(Specification specification) throws BallException {
        List<Ball> balls = new ArrayList<>();
        for(Ball ball : store.values()) {
            if (specification.specify(ball)) {
                balls.add(ball);
            }
        }
        return balls;
    }

    @Override
    public List<Ball> sort(Comparator<Ball> comparator) {
        List<Ball> balls = (List<Ball>) store.values();
        balls.sort(comparator);
        return balls;
    }

}
