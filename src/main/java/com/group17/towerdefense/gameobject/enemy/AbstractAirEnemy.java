package com.group17.towerdefense.gameobject.enemy;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.DestroyableEntity;
import com.group17.towerdefense.repositories.entity.MovableEntity;
import com.group17.towerdefense.utility.Utility;

public abstract class AbstractAirEnemy implements DestroyableEntity, MovableEntity {
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

    @Override
    public void doMove() {
        Utility.modifyVectorVelocity(this.recentGameField.getRecentStage().getTurningPoints(), this.position, this);
        this.position = new Point(getPosX() + getVectorVelocity().getX(), getPosY() + getVectorVelocity().getY());
    }
}