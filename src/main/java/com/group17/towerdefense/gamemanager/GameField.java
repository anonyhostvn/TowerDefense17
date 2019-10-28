package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.GameEntity;
import com.group17.towerdefense.entity.movable.enemy.SampleEnemy;
import com.group17.towerdefense.entity.title.ground.Mountain;
import com.group17.towerdefense.entity.title.ground.Road;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameField {
    private GameStage recentStage;
    private Set<GameEntity> allGameEntity;
    private long ticks;

    public GameField(GameStage gameStage) {
        ticks = 0;
        allGameEntity = new HashSet<GameEntity>();
        this.recentStage = gameStage;

        for (int i = 0; i < gameStage.getHeight(); i++)
            for (int j = 0; j < gameStage.getWidth(); j++)
                if (gameStage.getMapIn(i,j) == 0) {
                    allGameEntity.add(new Mountain(j * Config.SCREEN_HEIGHT_RATIO,i *  Config.SCREEN_WIDTH_RATIO,  Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                } else {
                    allGameEntity.add(new Road(j * Config.SCREEN_HEIGHT_RATIO, i * Config.SCREEN_WIDTH_RATIO, Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                }

        allGameEntity.add(new SampleEnemy(2, new DescartesVector(-0.2,0), Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()[1]), 50, 50 ));
        allGameEntity.add(new SampleEnemy(2, new DescartesVector(-0.2, 0), Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()[0]), 50, 50));
    }

    public void tick() {
        ticks++;
        for (GameEntity gameEntity : allGameEntity) gameEntity.doUpdate();
    }

    public void addEntity(GameEntity gameEntity) {
        allGameEntity.add(gameEntity);
    }

    public Set<GameEntity> getAllGameEntity() {
        return allGameEntity;
    }
}
