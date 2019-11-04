package com.group17.towerdefense.repositories.entity;

public interface GameEntity {
    double getPosX();
    double getPosY();
    double getAngle();
    double getWidth();
    double getHeight();
    void doUpdate(long tick);
    boolean isExist();
}
