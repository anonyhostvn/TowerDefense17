package com.group17.towerdefense.entity.title.ground;

public class Road implements GroundEntity {
    private double x;
    private double y;

    public Road(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getPosX() {
        return x;
    }

    @Override
    public double getPosY() {
        return y;
    }

    @Override
    public void doUpdate() {

    }
}
