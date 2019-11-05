package com.group17.towerdefense.mesurement;

public class TurningPoint {
    private Point point;
    private double angle;

    public TurningPoint(Point point, double angle) {
        this.point = new Point(point);
        this.angle = angle;
    }

    public Point getPoint() {
        return point;
    }

    public double getAngle() {
        return angle;
    }
}
