package com.group17.towerdefense.gameobject.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.bullet.AbstractBullet;
import com.group17.towerdefense.gameobject.bullet.BigRocket;
import com.group17.towerdefense.gameobject.enemy.*;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class SRocketTower extends AbstractTower{
    private final Class<? extends AbstractBullet> ownBulletClass = BigRocket.class;
    private final double range = Config.SINGLE_ROCKET_TOWER_RANGE;
    private final double damage = Config.BIG_ROCKET_DAMAGE;
    private final double frameGap = Config.SINGLE_ROCKET_TOWER_FRAME_GAP;
    private GameEntity targetObj = null;
    private final ArrayList<Class<? extends GameEntity>> targetClass = new ArrayList<Class<? extends GameEntity>>(
                List.of(
                        SampleEnemy.class,
                        JetPlaneEnemy.class,
                        PlaneEnemy.class
                )
        );

    public SRocketTower(Point fieldPoint, GameField gameField) {
        this.fieldPoint = new Point(fieldPoint);
        this.gameField = gameField;
    }

    @Override
    public double getDps() {
        return Config.SINGLE_ROCKET_TOWER_DPS;
    }

    @Override
    public double getRange() {
        return this.range;
    }

    @Override
    public ArrayList<Class<? extends GameEntity>> getTargetClass() {
        return targetClass;
    }

    @Override
    public void doAttack() {
        double minRange = Double.MAX_VALUE;

        this.targetObj = null;

        for (GameEntity gameEntity : this.gameField.getAllGameEntity())
            if (this.getTargetClass().contains(gameEntity.getClass())){
                double distance = Utility.calculateDistance(this, gameEntity);
                if (distance < this.getRange() && minRange > distance) {
                    minRange = distance;
                    targetObj = gameEntity;
                }
            }

        if (targetObj != null){
            countingFrame = 0;
            this.gameField.addEntity(new BigRocket(new Point(getPosX(), getPosY()), targetObj));
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
        if (countingFrame < frameGap) this.countingFrame += 2;
        if (countingFrame >= frameGap) {
            doAttack();
        }

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
