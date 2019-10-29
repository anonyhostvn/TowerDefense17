package com.group17.towerdefense.entity;

public interface GameEntity {
    double getPosX();
    double getPosY();
    double getWidth();
    double getHeight();
    void doUpdate(long tick);
    boolean isExist();
}
