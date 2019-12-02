package com.group17.towerdefense.gameobject.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.Point;

public class JetPlaneEnemy extends PlaneEnemy {
    public JetPlaneEnemy(Point pos, GameField gameField) {
        super(pos, gameField);
        this.absVelocity+=0.5;
        this.health -= 30;
    }
    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.recentGameField.getRecentStage().changeCoins(Config.PLANE_ENEMY_AWARD-30);
    }
}
