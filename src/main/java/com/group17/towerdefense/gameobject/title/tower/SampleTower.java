package com.group17.towerdefense.gameobject.title.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.movable.bullet.AbstractBullet;
import com.group17.towerdefense.gameobject.movable.bullet.SampleBullet;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleTower extends AbstractTower {
    private final Class<? extends AbstractBullet> ownBulletClass = SampleBullet.class;
    private final double range = Config.SAMPLE_TOWER_RANGE;
    private final double damage = Config.SAMPLE_BULLET_DAMAGE;
    private final double frameGap = 300;

    public SampleTower(Point fieldPoint, GameField gameField){
        this.fieldPoint = new Point(fieldPoint);
        this.gameField = gameField;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void doUpdate(long ticks) {
        this.countingFrame ++;
        if (countingFrame >= frameGap) {
            doAttack();
            countingFrame = 0;
        } else countingFrame ++;
    }

    @Override
    public boolean isExist() {
        return isExist;
    }

    @Override
    public double getDps() {
        return Config.SAMPLE_TOWER_DPS;
    }

    @Override
    public double getRange() {
        return this.range;
    }

    @Override
    public ArrayList<Class<? extends GameEntity>> getTargetClass() {
        return new ArrayList<Class<? extends GameEntity>>(
                List.of(
                        SampleEnemy.class
                )
        );
    }

    @Override
    public void doAttack()  {
        double minRange = Double.MAX_VALUE;
        GameEntity targetObject = null;

        for (GameEntity gameEntity : this.gameField.getAllGameEntity())
            if (this.getTargetClass().contains(gameEntity.getClass())){
                double distance = Utility.calculateDistance(this, gameEntity);
                if (distance < this.getRange() && minRange > this.getRange()) {
                    minRange = distance;
                    targetObject = gameEntity;
                }
            }

        if (targetObject != null)
            this.gameField.addEntity(new SampleBullet(new Point(getPosX(), getPosY()), targetObject));
    }
}