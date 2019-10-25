package com.group17.towerdefense.entity.title.ground;

public class Mountain implements GroundEntity {
    private double posX, posY;

    public Mountain(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    @Override
    public double getPosX() {
        return posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    @Override
    public void doUpdate() {
    }
}
