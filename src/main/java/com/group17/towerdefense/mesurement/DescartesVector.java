package com.group17.towerdefense.mesurement;

public class DescartesVector {
    private double x;
    private double y;

    public DescartesVector(Point point_1, Point point_2) {
        this.x = point_2.getX() - point_1.getX();
        this.y = point_2.getY() - point_1.getY();
    }

    public DescartesVector(PolarVector polarVector) {
        this(polarVector.getD() * Math.cos(polarVector.getFi()) , polarVector.getD() * Math.sin(polarVector.getFi()));
    }

    public DescartesVector(DescartesVector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public DescartesVector(double x, double y) {
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
