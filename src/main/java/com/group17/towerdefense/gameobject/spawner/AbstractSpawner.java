package com.group17.towerdefense.gameobject.spawner;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.repositories.entity.GameEntity;

public abstract class AbstractSpawner implements GameEntity {
    public abstract int getFrameGap();
    public abstract int getFrameCount();
    public abstract void resetFrameCount();
    public abstract void incFrameCount();
    public abstract GameField getRecentGameField();
}
