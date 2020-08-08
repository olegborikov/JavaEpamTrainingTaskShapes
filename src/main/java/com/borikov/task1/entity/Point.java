package com.borikov.task1.entity;

import com.borikov.task1.util.IdGenerator;

public class Point {
    private final long pointId;
    private double x;
    private double y;

    public Point(int x, int y) {
        pointId = IdGenerator.generateId();
        this.x = x;
        this.y = y;
    }

    public long getPointId() {
        return pointId;
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

    public boolean equalsPoint(Point point) {
        if (this == point) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (Double.compare(x, point.x) != 0) {
            return false;
        }
        if (Double.compare(y, point.y) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        if (pointId != point.pointId) {
            return false;
        }
        if (Double.compare(x, point.x) != 0) {
            return false;
        }
        if (Double.compare(y, point.y) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * (int) pointId;
        result = result + Double.valueOf(x).hashCode();
        result = result + Double.valueOf(y).hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("pointId=").append(pointId);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
