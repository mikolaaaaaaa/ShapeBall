package com.mikola.shape.observer;

import com.mikola.shape.exception.BallException;

public interface Observable {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObserver() throws BallException;
}
