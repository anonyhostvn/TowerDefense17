package com.group17.towerdefense.repositories.entity;

import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.repositories.entity.GameEntity;

public interface MovableEntity extends GameEntity {
    public double getAbsVelocity();
    public DescartesVector getVectorVelocity();
    public void doMove();
}
