package com.mikola.shape.exception;

public class BallException extends Exception{

    public BallException(String message) {
        super(message);
    }

    public BallException(String message,Exception e) {
        super(message,e);
    }

    public BallException(Exception e) {
        super(e);
    }

}
