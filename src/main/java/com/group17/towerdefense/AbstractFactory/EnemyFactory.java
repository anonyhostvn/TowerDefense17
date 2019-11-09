package com.group17.towerdefense.AbstractFactory;

import com.group17.towerdefense.AbstractFactory.AbstractEntityFactory;
import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gamemanager.GameStage;
import com.group17.towerdefense.gameobject.movable.enemy.AbstractGroundEnemy;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.mesurement.Point;

public class EnemyFactory extends AbstractEntityFactory {

    public EnemyFactory(GameField gameField) {
        super(gameField);
    }

    public SampleEnemy createSampleEnemy(Point position) {
        return new SampleEnemy(position, recentGameField);
    }

}
