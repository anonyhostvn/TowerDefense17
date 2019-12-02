package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.enemy.BossEnemy;
import com.group17.towerdefense.gameobject.enemy.PlaneEnemy;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.enemy.TankerEnemy;
import com.group17.towerdefense.gameobject.enemy.JetPlaneEnemy;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.repositories.entity.GameEntity;

public class EnemyFactory extends AbstractEntityFactory {

    public EnemyFactory(GameField gameField) {
        super(gameField);
    }

    public SampleEnemy createSampleEnemy(Point position) {
        return new SampleEnemy(position, recentGameField);
    }

    // SUPPLEMENT ENEMY
    public TankerEnemy createTankerEnemy(Point position) {
        return new TankerEnemy(position, recentGameField);
    }

    public BossEnemy createBossEnemy(Point position) {
        return new BossEnemy(position, recentGameField);
    }

    public PlaneEnemy createPlaneEnemy(Point position) {
        return new PlaneEnemy(position, recentGameField);
    }

    public JetPlaneEnemy createJetPlaneEnemy(Point position) {
        return new JetPlaneEnemy(position, recentGameField);
    }

}
