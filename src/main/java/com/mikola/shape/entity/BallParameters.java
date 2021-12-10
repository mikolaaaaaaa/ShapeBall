package com.mikola.shape.entity;

import java.util.Objects;

public class BallParameters {
    private double volume;
    private double surfaceArea;

    public BallParameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallParameters that = (BallParameters) o;
        return Double.compare(that.getVolume(), getVolume()) == 0 && Double.compare(that.getSurfaceArea(), getSurfaceArea()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(getVolume() + getSurfaceArea());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BallParameters{")
                .append("volume=").append(volume)
                .append(", surfaceArea=").append(surfaceArea)
                .append('}')
                .toString();
    }
}
