package com.group17.towerdefense.entity.title.tower;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.movable.enemy.SampleEnemy;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.Point;

public class SampleTower extends AbstractTower {
    private SampleTower(){
        super(0,0,null,0,0, null);
    }

    public SampleTower(int damage, double range, Point fieldPoint, GameField gameField){
        super(range, damage, fieldPoint, Config.SAMPLE_TOWER_DPS, Config.GAME_TPS, gameField);
    }

    @Override
    public void doUpdate(long ticks) {
        this.countingFrame ++;
        if (countingFrame >= frameGap) {
            // DO SHOOT BULLET
            countingFrame = 0;
        } else countingFrame ++;
    }

    @Override
    public boolean isExist() {
        return isExist;
    }
}