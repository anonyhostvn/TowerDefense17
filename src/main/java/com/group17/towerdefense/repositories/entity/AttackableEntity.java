package com.group17.towerdefense.repositories.entity;

import java.util.ArrayList;

public interface AttackableEntity {
    public double getDps();
    public double getRange();
    public ArrayList<Class<? extends GameEntity>> getTargetClass();
    public void doAttack();
}
