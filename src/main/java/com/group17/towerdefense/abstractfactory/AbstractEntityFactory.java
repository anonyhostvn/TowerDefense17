package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;

public class AbstractEntityFactory {
    protected GameField recentGameField;

    public AbstractEntityFactory(GameField gameField) {
        this.recentGameField = gameField;
    }

    public EnemyFactory createEnemyFactory() {
        return new EnemyFactory(this.recentGameField);
    }

    public TowerFactory createTowerFactory() {return new TowerFactory(this.recentGameField);}
}
