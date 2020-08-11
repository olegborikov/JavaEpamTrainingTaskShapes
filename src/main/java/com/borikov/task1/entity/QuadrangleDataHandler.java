package com.borikov.task1.entity;

public class QuadrangleDataHandler {
    private double perimeter;
    private double square;

    public QuadrangleDataHandler(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuadrangleDataHandler quadrangleDataHandler = (QuadrangleDataHandler) o;
        if (Double.compare(perimeter, quadrangleDataHandler.perimeter) != 0) {
            return false;
        }
        if (Double.compare(square, quadrangleDataHandler.square) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * Double.valueOf(perimeter).hashCode();
        result = result + Double.valueOf(square).hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleDataKeeper{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(square);
        sb.append('}');
        return sb.toString();
    }
}
