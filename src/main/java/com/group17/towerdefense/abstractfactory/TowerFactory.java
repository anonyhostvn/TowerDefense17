package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.tower.SampleTower;
import com.group17.towerdefense.mesurement.Point;

public class TowerFactory extends AbstractEntityFactory {
    public TowerFactory(GameField gameField) {
        super(gameField);
    }

    public SampleTower createSampleTower(Point position){
        return new SampleTower(position, recentGameField);
    }
}
