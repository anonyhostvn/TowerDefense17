package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.abstractfactory.AbstractEntityFactory;
import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.title.Spawner.AbstractSpawner;
import com.group17.towerdefense.gameobject.title.Spawner.SampleSpawner;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.gameobject.title.ground.Mountain;
import com.group17.towerdefense.gameobject.title.ground.Road;
import com.group17.towerdefense.gameobject.title.tower.SampleTower;
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
                if (gameStage.getMapIn(i,j) == GameFlag.MOUNTAIN) {
                    allGameEntity.add(new Mountain(j * Config.SCREEN_HEIGHT_RATIO,i *  Config.SCREEN_WIDTH_RATIO,  Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                } else {
                    allGameEntity.add(new Road(j * Config.SCREEN_HEIGHT_RATIO, i * Config.SCREEN_WIDTH_RATIO, Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                }

        entityFactory = new AbstractEntityFactory(this);

        recentSpawner = new SampleSpawner(Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()),this.entityFactory, recentStage.getListEnemy(), this);
        allGameEntity.add(recentSpawner);
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
        for (GameEntity removedEntity : removeList) {
            allGameEntity.remove(removedEntity);
        }
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

    public void createNewTower(Point fieldPoint, GameFlag tower) {
        int X = (int) fieldPoint.getX(), Y = (int) fieldPoint.getY();
        GameFlag obj = recentStage.getMapIn(Y,X);
        if (tower == GameFlag.SAMPLE_TOWER) {
            if (obj == GameFlag.MOUNTAIN){
                addEntity(entityFactory.createTowerFactory().createSampleTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SAMPLE_TOWER);
                this.getRecentStage().changeCoins(-Config.SAMPLE_TOWER_PRICE);
            }
        }

        //For test(delete if necessary)
        /*if (tower == GameFlag.SINGLE_BARREL_TOWER) {
            if (obj == GameFlag.MOUNTAIN){
                addEntity(entityFactory.createTowerFactory().createSingleBarrelTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SINGLE_BARREL_TOWER);
                this.getRecentStage().changeCoins(-Config.SINGLE_BARREL_TOWER_PRICE);
            }
        }
        if (tower == GameFlag.SINGLE_ROCKET_TOWER) {
            if (obj == GameFlag.MOUNTAIN){
                addEntity(entityFactory.createTowerFactory().createSingleRocketTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SINGLE_ROCKET_TOWER);
                this.getRecentStage().changeCoins(-Config.SINGLE_ROCKET_TOWER_PRICE);
            }
        }*/
    }
}
