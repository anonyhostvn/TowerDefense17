package com.group17.towerdefense.gameobject.title.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.repositories.entity.AttackableEntity;
import com.group17.towerdefense.repositories.entity.GameTile;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.Point;


public abstract class AbstractTower implements GameTile, AttackableEntity {

    protected Point fieldPoint;
    protected GameField gameField;

    protected int level = 0;
    protected boolean isExist = true;
    protected long countingFrame = 0;
    protected final int width = Config.SCREEN_WIDTH_RATIO * 2;
    protected final int height = Config.SCREEN_HEIGHT_RATIO * 2;

    @Override
    public double getPosX() {
        return fieldPoint.getX() * Config.SCREEN_WIDTH_RATIO;
    }

    @Override
    public double getPosY() {
        return fieldPoint.getY() * Config.SCREEN_HEIGHT_RATIO;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

}
