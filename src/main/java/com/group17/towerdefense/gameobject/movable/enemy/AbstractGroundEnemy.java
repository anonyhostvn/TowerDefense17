package com.group17.towerdefense.gameobject.movable.enemy;

import com.group17.towerdefense.repositories.entity.DestroyableEntity;
import com.group17.towerdefense.repositories.entity.MovableEntity;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public abstract class AbstractGroundEnemy implements MovableEntity, DestroyableEntity {
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
}
