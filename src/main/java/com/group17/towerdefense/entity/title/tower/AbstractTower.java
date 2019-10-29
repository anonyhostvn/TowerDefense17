package com.group17.towerdefense.entity.title.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.GameEntity;
import com.group17.towerdefense.entity.title.GameTile;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.Point;


public abstract class AbstractTower implements GameTile {
    protected int level;

    protected final double range;
    protected final int damage;
    protected final Point fieldPoint;
    protected long countingFrame;
    protected final int frameGap;
    protected final GameField gameField;
    protected boolean isExist;

    protected final int width = Config.SCREEN_WIDTH_RATIO * 2;
    protected final int height = Config.SCREEN_HEIGHT_RATIO * 2;

    private AbstractTower() {
        this.range = 0;
        this.damage = 0;
        this.level = 0;
        this.fieldPoint = null;
        this.frameGap = 0;
        this.gameField = null;
    };

    protected AbstractTower(double range, int damage, Point fieldPoint, int DPS, int FPS, GameField gameField) {
        this.range = range;
        this.damage = damage;
        this.fieldPoint = new Point(fieldPoint);
        this.countingFrame = 0;
        frameGap = damage * FPS / DPS;
        this.gameField = gameField;
        this.isExist = true;
    }


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
