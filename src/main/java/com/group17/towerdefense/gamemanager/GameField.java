package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.AbstractFactory.AbstractEntityFactory;
import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameobject.movable.bullet.SampleBullet;
import com.group17.towerdefense.gameobject.title.Spawner.AbstractSpawner;
import com.group17.towerdefense.gameobject.title.Spawner.SampleSpawner;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.title.ground.Mountain;
import com.group17.towerdefense.gameobject.title.ground.Road;
import com.group17.towerdefense.gameobject.title.tower.SampleTower;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameField {
    private GameStage recentStage;
    private Set<GameEntity> allGameEntity;
    private long ticks;
    private AbstractEntityFactory entityFactory;
    private AbstractSpawner recentSpawner;

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

        entityFactory = new AbstractEntityFactory(this);

//        GameEntity enemy1 = new SampleEnemy(Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()), this);
//        allGameEntity.add(enemy1);
        recentSpawner = new SampleSpawner(Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()),this.entityFactory, recentStage.getListEnemy(), this);
        allGameEntity.add(recentSpawner);
        allGameEntity.add(new SampleTower(new Point(15,7), this));
    }

    public void tick() {
        ticks++;
        try {
            for (GameEntity gameEntity : allGameEntity) {
                gameEntity.doUpdate(ticks);
            }
        } catch(Exception e) {
            System.out.println(allGameEntity.size());
        }

        ArrayList<GameEntity> removeList = new ArrayList<GameEntity>();
        for (GameEntity gameEntity: allGameEntity) if (!gameEntity.isExist()) removeList.add(gameEntity);
        for (GameEntity removedEntity : removeList) allGameEntity.remove(removedEntity);
     }

    public void addEntity(GameEntity gameEntity) {
        allGameEntity.add(gameEntity);
    }

    public Set<GameEntity> getAllGameEntity() {
        return allGameEntity;
    }

    public GameStage getRecentStage(){
        return this.recentStage;
    }
}
