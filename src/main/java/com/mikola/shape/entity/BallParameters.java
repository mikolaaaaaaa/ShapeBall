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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BallParameters that = (BallParameters) object;
        return Double.compare(that.getVolume(), getVolume()) == 0 && Double.compare(that.getSurfaceArea(), getSurfaceArea()) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long c = Double.doubleToLongBits(volume);
        int hash = (int) (c ^ (c >>> 32));
        result = result * 31 + hash;
        c = Double.doubleToLongBits(surfaceArea);
        hash = (int) (c ^ (c >>> 32));
        result = result * 31 + hash;
        return result;
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
