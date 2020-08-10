package com.borikov.task1.entity;

import com.borikov.task1.util.IdGenerator;

public class Quadrangle {
    private final long quadrangleId;
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Quadrangle(Point point1, Point point2, Point point3, Point point4) {
        quadrangleId = IdGenerator.generateId();
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public long getQuadrangleId() {
        return quadrangleId;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public boolean equalsQuadrangle(Quadrangle quadrangle) {
        if (this == quadrangle) {
            return true;
        }
        if (quadrangle == null) {
            return false;
        }
        if (point1 == null) {
            if (quadrangle.point1 != null) {
                return false;
            }
        } else {
            if (!point1.equalsPoint(quadrangle.point1)) {
                return false;
            }
        }
        if (point2 == null) {
            if (quadrangle.point2 != null) {
                return false;
            }
        } else {
            if (!point2.equalsPoint(quadrangle.point2)) {
                return false;
            }
        }
        if (point3 == null) {
            if (quadrangle.point3 != null) {
                return false;
            }
        } else {
            if (!point3.equalsPoint(quadrangle.point3)) {
                return false;
            }
        }
        if (point4 == null) {
            if (quadrangle.point4 != null) {
                return false;
            }
        } else {
            if (!point4.equalsPoint(quadrangle.point4)) {
                return false;
            }
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
        Quadrangle quadrangle = (Quadrangle) o;
        if (quadrangleId != quadrangle.quadrangleId) {
            return false;
        }
        if (point1 == null) {
            if (quadrangle.point1 != null) {
                return false;
            }
        } else {
            if (!point1.equals(quadrangle.point1)) {
                return false;
            }
        }
        if (point2 == null) {
            if (quadrangle.point2 != null) {
                return false;
            }
        } else {
            if (!point2.equals(quadrangle.point2)) {
                return false;
            }
        }
        if (point3 == null) {
            if (quadrangle.point3 != null) {
                return false;
            }
        } else {
            if (!point3.equals(quadrangle.point3)) {
                return false;
            }
        }
        if (point4 == null) {
            if (quadrangle.point4 != null) {
                return false;
            }
        } else {
            if (!point4.equals(quadrangle.point4)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * (int) quadrangleId;
        result = result + (point1 != null ? point1.hashCode() : 0);
        result = result + (point2 != null ? point2.hashCode() : 0);
        result = result + (point3 != null ? point3.hashCode() : 0);
        result = result + (point4 != null ? point4.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append("quadrangleId=").append(quadrangleId);
        sb.append(", point1=").append(point1);
        sb.append(", point2=").append(point2);
        sb.append(", point3=").append(point3);
        sb.append(", point4=").append(point4);
        sb.append('}');
        return sb.toString();
    }
}
