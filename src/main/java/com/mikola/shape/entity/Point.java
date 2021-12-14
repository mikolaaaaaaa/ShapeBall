package com.mikola.shape.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {

    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.getX(), getX()) == 0 && Double.compare(point.getY(), getY()) == 0 && Double.compare(point.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long c = Double.doubleToLongBits(x);
        int hash = (int) (c ^ (c >>> 32));
        result = result * 31 + hash;
        c = Double.doubleToLongBits(y);
        hash = (int) (c ^ (c >>> 32));
        result = result * 31 + hash;
        c = Double.doubleToLongBits(z);
        hash = (int) (c ^ (c >>> 32));
        result = result * 31 + hash;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Point{")
                .append("x=").append(x)
                .append(", y=").append(y)
                .append(", z=").append(z)
                .append("}")
                .toString();

    }
}
