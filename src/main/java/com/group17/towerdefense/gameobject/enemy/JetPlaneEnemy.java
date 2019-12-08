package com.group17.towerdefense.gameobject.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;

public class JetPlaneEnemy extends AbstractAirEnemy {
    public JetPlaneEnemy(Point position, GameField gameField) {
        this.absVelocity = Config.JET_PLANE_ENEMY_ABS_VELOCITY;
        this.width = Config.JET_PLANE_ENEMY_WIDTH;
        this.height = Config.JET_PLANE_ENEMY_HEIGHT;
        this.position = new Point(position);
        this.vectorVelocity = new DescartesVector(0,0);
        this.health = Config.JET_PLANE_ENEMY_INIT_HEALTH;
        this.recentGameField = gameField;
    }
    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.recentGameField.getRecentStage().changeCoins(Config.JET_PLANE_ENEMY_AWARD);
    }

    @Override
    public void doUpdate(long tick) {
        this.doMove();
    }
}
