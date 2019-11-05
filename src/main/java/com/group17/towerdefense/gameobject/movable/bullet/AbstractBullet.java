package com.group17.towerdefense.gameobject.movable.bullet;

import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.DestroyableEntity;
import com.group17.towerdefense.repositories.entity.FireableSingleEntity;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.repositories.entity.MovableEntity;

public abstract class AbstractBullet implements MovableEntity {
    protected Point position;
    protected DescartesVector vectorVelocity;
    protected PolarVector directionVector;
    protected double width;
    protected double height;
    protected double absVelocity;
    protected boolean isExist;

    @Override
    public DescartesVector getVectorVelocity() {
        return this.vectorVelocity;
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
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getAbsVelocity() {
        return this.absVelocity;
    }

    public PolarVector getDirectionVector() {
        return this.directionVector;
    }

}
