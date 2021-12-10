package com.mikola.shape.entity;

import com.mikola.shape.exception.BallException;
import com.mikola.shape.observer.Observable;
import com.mikola.shape.observer.Observer;
import com.mikola.shape.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ball implements Observable {
    private Point center;
    private double radius;
    private long id;
    private List<Observer> observers = new ArrayList<>();

    public Ball() {

    }

    public Ball(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.id = IdGenerator.generateId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws BallException {
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.getRadius(), getRadius()) == 0 && Objects.equals(getCenter(), ball.getCenter());
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius + (center == null ? 0 : center.hashCode()));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Ball{")
                .append("center=").append(center)
                .append(", radius=").append(radius)
                .append("}")
                .toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() throws BallException {
        for (Observer i : observers) {
            i.update(this);
        }
    }
}
