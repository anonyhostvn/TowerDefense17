package com.group17.towerdefense.gameobject.movable.enemy;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.PolarVector;
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
    protected GameField recentGameField;

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

    @Override
    public void setVectorVelocity(DescartesVector descartesVector) {
        this.vectorVelocity = new DescartesVector(descartesVector);
    }

    @Override
    public DescartesVector getVectorVelocity() {
        return this.vectorVelocity;
    }


    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean isExist() {
        return health > 0;
    }

    @Override
    public double getAngle() {
        PolarVector polarVector = new PolarVector(this.vectorVelocity);
        return Math.toDegrees(polarVector.getFi());
    }
}
