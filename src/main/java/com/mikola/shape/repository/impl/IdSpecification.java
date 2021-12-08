package com.mikola.shape.repository.impl;

import com.mikola.shape.entity.Ball;
import com.mikola.shape.repository.Specification;

public class IdSpecification implements Specification {
    private final long from;
    private final long to;

    public IdSpecification(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Ball ball) {
        return (ball.getId() >= from && ball.getId() <= to);
    }

}
