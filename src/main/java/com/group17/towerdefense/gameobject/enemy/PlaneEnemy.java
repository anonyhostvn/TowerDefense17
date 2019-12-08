package com.group17.towerdefense.gameobject.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public class PlaneEnemy extends AbstractAirEnemy {
    public PlaneEnemy (Point position, GameField gameField) {
        this.absVelocity = Config.PLANE_ENEMY_ABS_VELOCITY;
        this.width = Config.PLANE_ENEMY_WIDTH;
        this.height = Config.PLANE_ENEMY_HEIGHT;
        this.position = new Point(position);
        this.vectorVelocity = new DescartesVector(0,0);
        this.health = Config.PLANE_ENEMY_INIT_HEALTH;
        this.recentGameField = gameField;
    }

    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.recentGameField.getRecentStage().changeCoins(Config.PLANE_ENEMY_AWARD);
    }

    @Override
    public void doUpdate(long tick) {
        this.doMove();
    }
}
