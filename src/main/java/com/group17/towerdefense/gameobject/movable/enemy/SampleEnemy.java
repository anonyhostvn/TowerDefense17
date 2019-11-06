package com.group17.towerdefense.gameobject.movable.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;

public class SampleEnemy extends AbstractGroundEnemy {

    public SampleEnemy (DescartesVector vectorVelocity, Point position, double width, double height, GameField gameField) {
        this.absVelocity = Config.SAMPLE_ENEMY_ABS_VELOCITY;
        this.width = width;
        this.height = height;
        this.position = new Point(position);
        this.vectorVelocity = vectorVelocity;
        this.health = Config.SAMPLE_ENEMY_INIT_HEALTH;
        this.recentGameField = gameField;
    }

    @Override
    public void doUpdate(long tick) {
        this.doMove();
    }

    @Override
    public void doMove() {
        Utility.modifyVectorVelocity(this.recentGameField.getRecentStage().getTurningPoints(), this.position, this);
        this.position = new Point(getPosX() + getVectorVelocity().getX(), getPosY() + getVectorVelocity().getY());
    }
}
