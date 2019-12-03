package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.tower.*;
import com.group17.towerdefense.mesurement.Point;

public class TowerFactory extends AbstractEntityFactory {
    public TowerFactory(GameField gameField) {
        super(gameField);
    }

    public SampleTower createSampleTower(Point position){
        return new SampleTower(position, recentGameField);
    }

    public SBarrelTower createSBarrelTower(Point position) {
        return new SBarrelTower(position, recentGameField);
    }

    public DBarrelTower createDBarrelTower(Point position) {
        return new DBarrelTower(position, recentGameField);
    }

    public SRocketTower createSRocketTower(Point position) {
        return new SRocketTower(position, recentGameField);
    }

    public DRocketTower createDRocketTower(Point position) {
        return new DRocketTower(position, recentGameField);
    }
}
