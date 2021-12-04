package com.mikola.shape.action;

import com.mikola.shape.entity.Ball;


public interface ShapeLogic {
    public double calculateSurfaceArea(Ball ball) throws Exception;
    public double calculateVolume(Ball ball) throws Exception;
    public boolean isBall(Ball ball) throws Exception;
    public boolean isPertainsCoordinatedPlanes(Ball ball) throws Exception;
}
