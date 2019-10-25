package com.group17.towerdefense.entity.movable;

import com.group17.towerdefense.entity.GameEntity;

public interface MovableEntity extends GameEntity {
    public double getVelocity();
    public void doUpdate();
}
