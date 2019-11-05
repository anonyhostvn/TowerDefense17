package com.group17.towerdefense.repositories.entity;

public interface FireableSingleEntity {
    public GameEntity getTarget();
    public int getDamage();
}