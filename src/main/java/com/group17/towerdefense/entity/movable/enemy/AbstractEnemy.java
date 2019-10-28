package com.group17.towerdefense.entity.movable.enemy;

import com.group17.towerdefense.entity.movable.MovableEntity;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public abstract class AbstractEnemy implements MovableEntity {
    protected double absVelocity;
    protected double width, height;
    protected Point position;
    protected DescartesVector vectorVelocity;
    protected int health;


    @Override
    public double getAbsVelocity() {
        return absVelocity;
    }

    @Override
    public double getPosX() {
        return position.getX();
    }

    @Override
    public double getPosY() {
        return position.getY();
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public boolean isDeath() {
        return this.health <= 0;
    }

    public void decreaseHealth(int decHealth) {
        this.health -= decHealth;
        if (this.health < 0) this.health = 0;
    }
}
