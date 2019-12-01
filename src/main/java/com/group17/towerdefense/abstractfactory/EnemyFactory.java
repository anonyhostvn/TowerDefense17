package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.enemy.TankerEnemy;
import com.group17.towerdefense.mesurement.Point;

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

}
