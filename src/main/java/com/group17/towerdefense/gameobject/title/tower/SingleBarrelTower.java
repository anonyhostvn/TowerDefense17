package com.group17.towerdefense.gameobject.title.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.movable.bullet.AbstractBullet;
import com.group17.towerdefense.gameobject.movable.bullet.SingleBarrelBullet;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class SingleBarrelTower extends AbstractTower{
    private final Class<? extends AbstractBullet> ownBulletClass = SingleBarrelBullet.class;
    private final double range = Config.SINGLE_BARREL_TOWER_RANGE;
    private final double damage = Config.SINGLE_BARREL_BULLET_DAMAGE;
    private final double frameGap = Config.SINGLE_BARREL_TOWER_FRAME_GAP;
    private GameEntity targetObj = null;

    public SingleBarrelTower(Point fieldPoint, GameField gameField) {
        this.fieldPoint = fieldPoint;
        this.gameField = gameField;
    }

    @Override
    public double getDps() {
        return Config.SINGLE_BARREL_TOWER_DPS;
    }

    @Override
    public double getRange() {
        return Config.SINGLE_BARREL_TOWER_RANGE;
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
    public void doAttack() {
        double minRange = Double.MAX_VALUE;

        this.targetObj = null;

        for(GameEntity gameEntity : this.gameField.getAllGameEntity()) {
            if(this.getTargetClass().contains(gameEntity.getClass())) {
                double distance = Utility.calculateDistance(this, gameEntity);
                if (distance < this.getRange() && minRange > this.getRange()) {
                    minRange = distance;
                    targetObj = gameEntity;
                }
            }
        }

        if(targetObj != null) {
            this.gameField.addEntity(new SingleBarrelBullet(new Point(getPosX(), getPosY()), targetObj));
        }
    }

    @Override
    public double getAngle() {
        if(targetObj != null) {
            PolarVector direction = new PolarVector(new Point(this.getPosX(), this.getPosY()), new Point(targetObj.getPosX(), targetObj.getPosY()));
            return Math.toDegrees(direction.getFi()) + 90;
        }
        return 0;
    }

    @Override
    public void doUpdate(long tick) {
        this.countingFrame++;
        if(countingFrame >= frameGap) {
            doAttack();
            this.countingFrame = 0;
        } else countingFrame++;
    }

    @Override
    public boolean isExist() {
        return isExist;
    }
}
