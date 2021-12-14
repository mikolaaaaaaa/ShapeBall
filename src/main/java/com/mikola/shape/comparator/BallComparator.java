package com.mikola.shape.comparator;

import com.mikola.shape.action.impl.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.entity.Point;
import com.mikola.shape.exception.BallException;

import java.util.Comparator;

public class BallComparator {
    public Comparator<Ball> getIdComparator() {
        return new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return Long.compare(o1.getId(), o2.getId());
            }
        };
    }

    public Comparator<Ball> getVolumeComparator() {

        return new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                BallLogic ballLogic = new BallLogic();
                double volumeO1 = 0;
                double volumeO2 = 0;
                try {
                    volumeO1 = ballLogic.calculateVolume(o1);
                    volumeO2 = ballLogic.calculateVolume(o2);
                } catch (BallException e) {
                    e.printStackTrace();
                }
                return Double.compare(volumeO1, volumeO2);
            }
        };
    }

    public Comparator<Ball> getSurfaceAreaComparator() {

        return new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                BallLogic ballLogic = new BallLogic();
                double surfaceAreaO1 = 0;
                double surfaceAreaO2 = 0;
                try {
                    surfaceAreaO1 = ballLogic.calculateSurfaceArea(o1);
                    surfaceAreaO2 = ballLogic.calculateSurfaceArea(o2);
                } catch (BallException e) {
                    e.printStackTrace();
                }
                return Double.compare(surfaceAreaO1, surfaceAreaO2);
            }
        };
    }


    public Comparator<Ball> getFirstOxCoordinateComparator() {
        return new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                Point firstCenter = o1.getCenter();
                Point secondCenter = o2.getCenter();
                double firstOxCoordinate = firstCenter.getX() - o1.getRadius();
                double secondOxCoordinate = secondCenter.getX() - o2.getRadius();
                return Double.compare(firstOxCoordinate, secondOxCoordinate);
            }
        };
    }

    public Comparator<Ball> getFirstOyCoordinateComparator() {
        return new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                Point firstCenter = o1.getCenter();
                Point secondCenter = o2.getCenter();
                double firstOyO1 = firstCenter.getY() - o1.getRadius();
                double firstOyO2 = secondCenter.getY() - o2.getRadius();
                return Double.compare(firstOyO1, firstOyO2);
            }
        };
    }

}
