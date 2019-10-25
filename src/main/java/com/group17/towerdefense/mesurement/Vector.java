package com.group17.towerdefense.mesurement;

public class Vector {
    private double x;
    private double y;

    public Vector(Point point_1, Point point_2) {
        this.x = point_2.getX() - point_1.getX();
        this.y = point_2.getY() - point_1.getY();
    }

    public Vector(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt (x * x + y * y);
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
}
