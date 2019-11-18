package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.title.tower.SampleTower;
import com.group17.towerdefense.gameobject.title.tower.SingleBarrelTower;
import com.group17.towerdefense.gameobject.title.tower.SingleRocketTower;
import com.group17.towerdefense.mesurement.Point;

public class TowerFactory extends AbstractEntityFactory {
    public TowerFactory(GameField gameField) {
        super(gameField);
    }

    public SampleTower createSampleTower(Point position){
        return new SampleTower(position, recentGameField);
    }

    //Add single-barrel tower
    public SingleBarrelTower createSingleBarrelTower(Point position) {
        return new SingleBarrelTower(position, recentGameField);
    }

    //Add single-rocket tower
    public SingleRocketTower createSingleRocketTower(Point position) {
        return new SingleRocketTower(position, recentGameField);
    }
}
