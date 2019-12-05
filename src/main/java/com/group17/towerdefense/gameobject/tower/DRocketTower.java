package com.group17.towerdefense.gameobject.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.bullet.AbstractBullet;
import com.group17.towerdefense.gameobject.bullet.Rocket;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DRocketTower extends AbstractTower{
    private final Class<? extends AbstractBullet> ownBulletClass = Rocket.class;
    private final double range = Config.DOUBLE_ROCKET_TOWER_RANGE;
    private final double damage = Config.ROCKET_DAMAGE;
    private final double frameGap = Config.DOUBLE_ROCKET_TOWER_FRAME_GAP;
    private GameEntity targetObj = null;

    public DRocketTower(Point fieldPoint, GameField gameField) {
        this.fieldPoint = new Point(fieldPoint);
        this.gameField = gameField;
    }

    @Override
    public double getDps() {
        return Config.DOUBLE_ROCKET_TOWER_DPS;
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
    public void doAttack() {
        double minRange = Double.MAX_VALUE;

        this.targetObj = null;

        for (GameEntity gameEntity : this.gameField.getAllGameEntity())
            if (this.getTargetClass().contains(gameEntity.getClass())){
                double distance = Utility.calculateDistance(this, gameEntity);
                if (distance < this.getRange() && minRange > this.getRange()) {
                    minRange = distance;
                    targetObj = gameEntity;
                }
            }

        if (targetObj != null) {
            double toBarrelHeadX;
            double toBarrelHeadY;
            if(this.getAngle() > 0 && this.getAngle() <= 90) {
                toBarrelHeadX = 5 * Math.sin(Math.toRadians(90 - this.getAngle()));
                toBarrelHeadY = 5 * Math.cos(Math.toRadians(90 - this.getAngle()));
            }
            else if(this.getAngle() > -90 && this.getAngle() <= 0) {
                toBarrelHeadX = 5 * Math.cos(Math.toRadians(-this.getAngle()));
                toBarrelHeadY = -5 * Math.sin(Math.toRadians(-this.getAngle()));
            }
            else if(this.getAngle() > 90 && this.getAngle() <= 180) {
                toBarrelHeadX = -5 * Math.sin(Math.toRadians(this.getAngle() - 90));
                toBarrelHeadY = 5 * Math.cos(Math.toRadians(this.getAngle() - 90));
            }
            else {
                toBarrelHeadX = -5 * Math.sin(Math.toRadians(270 - this.getAngle()));
                toBarrelHeadY = -5 * Math.cos(Math.toRadians(270 - this.getAngle()));
            }
            Random r = new Random();
            int n = r.nextInt() % 2;
            if(n == 0)
                this.gameField.addEntity(new Rocket(new Point(this.getPosX() + toBarrelHeadX, this.getPosY() + toBarrelHeadY), targetObj));
            else this.gameField.addEntity(new Rocket(new Point(this.getPosX() - toBarrelHeadX, this.getPosY() - toBarrelHeadY), targetObj));
        }
    }

    @Override
    public double getAngle() {
        if (targetObj != null) {
            PolarVector direction = new PolarVector(new Point(getPosX(), getPosY()) , new Point(targetObj.getPosX(), targetObj.getPosY()));
            return Math.toDegrees(direction.getFi()) + 90;
        }
        return 0;
    }

    @Override
    public void doUpdate(long tick) {
        this.countingFrame ++;
        if (countingFrame >= frameGap) {
            doAttack();
            countingFrame = 0;
        } else countingFrame ++;

        if (this.gameField.getRemoveTowerPosition() != null && this.gameField.getRemoveTowerPosition().equal(this.fieldPoint)) {
            this.isExist = false;
            this.gameField.setRemoveTowerPosition(null);
            this.gameField.getRecentStage().changeCoins(Config.SINGLE_ROCKET_TOWER_SELL_PRICE);
        }
    }

    @Override
    public boolean isExist() {
        return isExist;
    }
}
