package com.group17.towerdefense.gameobject.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;

public class SampleEnemy extends AbstractGroundEnemy {

    public SampleEnemy (Point position, GameField gameField) {
        this.absVelocity = Config.SAMPLE_ENEMY_ABS_VELOCITY;
        this.width = Config.SAMPLE_ENEMY_WIDTH;
        this.height = Config.SAMPLE_ENEMY_HEIGHT;
        this.position = new Point(position);
        this.vectorVelocity = new DescartesVector(0,0);
        this.health = Config.SAMPLE_ENEMY_INIT_HEALTH;
        this.recentGameField = gameField;
    }

    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.recentGameField.getRecentStage().changeCoins(Config.SAMPLE_ENEMY_AWARD);
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
