package com.group17.towerdefense.gameobject.ground;

import com.group17.towerdefense.mesurement.Point;

public class RockTwo extends AbstractGround{
    private Point position;
    private int width, height;

    public RockTwo(Point position, int width, int height) {
        this.position = new Point(position);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPosX() {
        return this.position.getX();
    }

    @Override
    public double getPosY() {
        return this.position.getY();
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void doUpdate(long tick) {

    }

    @Override
    public boolean isExist() {
        return true;
    }
}