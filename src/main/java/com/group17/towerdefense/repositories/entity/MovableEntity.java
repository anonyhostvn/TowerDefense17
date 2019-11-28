package com.group17.towerdefense.repositories.entity;

import com.group17.towerdefense.mesurement.DescartesVector;

public interface MovableEntity extends GameEntity {
    public double getAbsVelocity();
    public DescartesVector getVectorVelocity();
    public void setVectorVelocity(DescartesVector descartesVector);
    public void doMove();
}
