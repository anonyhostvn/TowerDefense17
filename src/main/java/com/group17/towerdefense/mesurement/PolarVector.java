package com.group17.towerdefense.mesurement;

public class PolarVector {
    private double d, fi;
    public PolarVector(double d, double fi) {
        this.d = d;
        this.fi = fi;
    }

    public PolarVector(DescartesVector descartesVector) {
        this.d = Math.sqrt(descartesVector.getX() * descartesVector.getX() + descartesVector.getY() * descartesVector.getY());
        this.fi = Math.atan(descartesVector.getY() / descartesVector.getX());
    }

    public PolarVector(Point point_1, Point point_2) {
        this(new DescartesVector(point_1, point_2));
    }

    public double getD() {return d;}
    public double getFi() {return fi;}
}
