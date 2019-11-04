package com.group17.towerdefense.gameobject.title;

import com.group17.towerdefense.repositories.entity.GameEntity;

public class Spawner implements GameEntity {
    @Override
    public double getPosX() {
        return 0;
    }

    @Override
    public double getPosY() {
        return 0;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void doUpdate(long tick) {

    }

    @Override
    public boolean isExist() {
        return false;
    }
}
