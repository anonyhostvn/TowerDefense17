package com.group17.towerdefense.repositories.entity;

public interface DestroyableEntity {
    public boolean isExist();
    public int getHealth();
    public void beAttacked(int damage);
}
