package com.mikola.shape.comparator;

import com.mikola.shape.action.impl.BallLogic;
import com.mikola.shape.entity.Ball;
import com.mikola.shape.exception.BallException;

import java.util.Comparator;

public class BallComparator {
    public Comparator<Ball> getIdComparator() {
        Comparator<Ball> idComparator = new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return Long.compare(o1.getId(),o2.getId());
            }
        };
        return idComparator;
    }
    public Comparator<Ball> getVolumeComparator() {
        Comparator<Ball> volumeComparator = new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                BallLogic ballLogic = new BallLogic();
                try {
                    double volumeO1 = ballLogic.calculateVolume(o1);
                    double volumeO2 = ballLogic.calculateVolume(o2);
                    return Double.compare(volumeO1,volumeO2);
                } catch (BallException e) {
                    e.printStackTrace();
                }
                finally {
                    return Double.compare(0,0);
                }
            }
        };
        return volumeComparator;
    }

}
