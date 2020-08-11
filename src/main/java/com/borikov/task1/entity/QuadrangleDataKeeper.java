package com.borikov.task1.entity;

public class QuadrangleDataKeeper {
    private double square;
    private double perimeter;

    public QuadrangleDataKeeper(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuadrangleDataKeeper quadrangleDataKeeper = (QuadrangleDataKeeper) o;
        if (Double.compare(square, quadrangleDataKeeper.square) != 0) {
            return false;
        }
        if (Double.compare(perimeter, quadrangleDataKeeper.perimeter) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * Double.valueOf(square).hashCode();
        result = result + Double.valueOf(perimeter).hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleDataKeeper{");
        sb.append("square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
