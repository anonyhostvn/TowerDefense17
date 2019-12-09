package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.abstractfactory.AbstractEntityFactory;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gameobject.enemy.AbstractAirEnemy;
import com.group17.towerdefense.gameobject.enemy.AbstractGroundEnemy;
import com.group17.towerdefense.gameobject.ground.*;
import com.group17.towerdefense.gameobject.spawner.AbstractSpawner;
import com.group17.towerdefense.gameobject.spawner.SampleSpawner;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

import java.util.*;

public class GameField {
    private GameStage recentStage;
    private ArrayList<GameEntity> allGameEntity;
    private List<GameEntity> addingGameEntity;
    private AbstractEntityFactory entityFactory;
    private AbstractSpawner recentSpawner;
    private Point recentMousePosition;
    private boolean isChooseATower;
    private Point choosingPosition;
    private Point removeTowerPosition = null;
    private double recentHoverRange = 0;
    private boolean isMuteSoundEffect = false;

    private long ticks;

    public GameField(GameStage gameStage) {
        ticks = 0;
        allGameEntity = new ArrayList<GameEntity>();
        this.recentStage = gameStage;

        for (int i = 0; i < gameStage.getHeight(); i++)
            for (int j = 0; j < gameStage.getWidth(); j++)
                if (gameStage.getMapIn(i,j) == GameFlag.MOUNTAIN) {
                    allGameEntity.add(new Mountain(j * Config.SCREEN_HEIGHT_RATIO,i *  Config.SCREEN_WIDTH_RATIO,  Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));

                    double rate = Math.random();
                    if (rate <= 0.02)
                        allGameEntity.add(new RockOnes(Utility.fromFieldPointToScreenPoint(new Point(j,i)), Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                    else if (rate <= 0.03){
                        allGameEntity.add(new RockTwo(Utility.fromFieldPointToScreenPoint(new Point(j,i)), Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                    } else if (rate <= 0.06) {
                        allGameEntity.add(new BushOne(Utility.fromFieldPointToScreenPoint(new Point(j,i)), Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                    }
                } else {
                    allGameEntity.add(new Road(j * Config.SCREEN_HEIGHT_RATIO, i * Config.SCREEN_WIDTH_RATIO, Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO));
                }

        entityFactory = new AbstractEntityFactory(this);

        recentSpawner = new SampleSpawner(Utility.fromFieldPointToScreenPoint(gameStage.getStartPoint()),this.entityFactory, recentStage.getListEnemy(), this);
        allGameEntity.add(recentSpawner);
        recentMousePosition = null;
        this.isChooseATower = false;
        this.addingGameEntity = new ArrayList<GameEntity>();
        this.choosingPosition = null;
    }

    private void checkEnemyReachGoal() {
        for (GameEntity gameEntity : allGameEntity){
            if ( (gameEntity instanceof AbstractGroundEnemy) && gameEntity.getPosX() < 0)  {
                ((AbstractGroundEnemy) gameEntity).beAttacked(10000);
                this.recentStage.decreaseHealth();
            }else  if ( (gameEntity instanceof AbstractAirEnemy) && gameEntity.getPosX() < 0)  {
                ((AbstractAirEnemy) gameEntity).beAttacked(10000);
                this.recentStage.decreaseHealth();
            }
        }
    }

    public void tick() {
        ticks++;
        try {
            for (GameEntity gameEntity : allGameEntity) {
                gameEntity.doUpdate(ticks);
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error when update : " + allGameEntity.size());
        }

        checkEnemyReachGoal();


        ArrayList<GameEntity> removeList = new ArrayList<GameEntity>();
        for (GameEntity gameEntity: allGameEntity) if (!gameEntity.isExist()) {
            if (
                    gameEntity instanceof AbstractGroundEnemy
                    || gameEntity instanceof AbstractAirEnemy
            ) this.getRecentStage().destroyEnemy();
            removeList.add(gameEntity);
        }
        for (GameEntity removedEntity : removeList) {
            allGameEntity.remove(removedEntity);
        }

        allGameEntity.addAll(addingGameEntity);

        addingGameEntity.clear();

        Collections.sort(this.allGameEntity, Config::entityOrderComparator);
    }

    public void setRecentMousePosition(Point position) {
        this.recentMousePosition = position;
    }

    public Point getRecentMousePosition() {
        return recentMousePosition;
    }

    public void setIsChooseATower(boolean isChooseATower) {
        this.isChooseATower = isChooseATower;
    }

    public boolean getIsChooseATower() {
        return isChooseATower;
    }

    public void addEntity(GameEntity gameEntity) {
        addingGameEntity.add(gameEntity);
    }

    public ArrayList<GameEntity> getAllGameEntity() {
        return allGameEntity;
    }

    public GameStage getRecentStage(){
        return this.recentStage;
    }

    public void setChoosingPosition(Point position) {
        this.choosingPosition = position;
    }

    public Point getChoosingPosition() {
        return this.choosingPosition;
    }

    public void sellChoosingPosition() {
        Point fieldPoint = Utility.fromScreenPointToFieldPoint(this.choosingPosition);
    }

    public void sellChooseTower() {
        if (this.getChoosingPosition() == null) return;
        Point fieldPosition = Utility.fromScreenPointToFieldPoint(this.getChoosingPosition());
        this.setRemoveTowerPosition(fieldPosition);
        this.setChoosingPosition(null);
    }

    public void setRemoveTowerPosition(Point position) {
        this.removeTowerPosition = position;
    }

    public Point getRemoveTowerPosition() {
        return this.removeTowerPosition;
    }

    public double getRecentHoverRange() {return this.recentHoverRange ;}
    public void setRecentHoverRange(double recentHoverRange) {this.recentHoverRange = recentHoverRange; }

    public AbstractEntityFactory getEntityFactory() {
        return this.entityFactory;
    }

    public void createNewTower(Point fieldPoint, GameFlag tower) {
        this.setChoosingPosition(null);
        int X = (int) fieldPoint.getX(), Y = (int) fieldPoint.getY();
        GameFlag obj = recentStage.getMapIn(Y,X);
        if (obj == GameFlag.MOUNTAIN){

            if (tower == GameFlag.SAMPLE_TOWER && recentStage.getCoins() >= Config.SAMPLE_TOWER_PRICE) {
                addEntity(entityFactory.createTowerFactory().createSampleTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SAMPLE_TOWER);
                this.getRecentStage().changeCoins(-Config.SAMPLE_TOWER_PRICE);
            }

            else if (tower == GameFlag.SINGLE_BARREL_TOWER && recentStage.getCoins() >= Config.SINGLE_BARREL_TOWER_PRICE) {
                addEntity(entityFactory.createTowerFactory().createSBarrelTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SINGLE_BARREL_TOWER);
                this.getRecentStage().changeCoins(-Config.SINGLE_BARREL_TOWER_PRICE);
            }

            else if (tower == GameFlag.DOUBLE_BARREL_TOWER && recentStage.getCoins() >= Config.DOUBLE_BARREL_TOWER_PRICE) {
                addEntity(entityFactory.createTowerFactory().createDBarrelTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.DOUBLE_BARREL_TOWER);
                this.getRecentStage().changeCoins(-Config.DOUBLE_BARREL_TOWER_PRICE);
            }

            else if (tower == GameFlag.SINGLE_ROCKET_TOWER && recentStage.getCoins() >= Config.SINGLE_ROCKET_TOWER_PRICE) {
                addEntity(entityFactory.createTowerFactory().createSRocketTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.SINGLE_ROCKET_TOWER);
                this.getRecentStage().changeCoins(-Config.SINGLE_ROCKET_TOWER_PRICE);
            }

            else if (tower == GameFlag.DOUBLE_ROCKET_TOWER && recentStage.getCoins() >= Config.DOUBLE_ROCKET_TOWER_PRICE) {
                addEntity(entityFactory.createTowerFactory().createDRocketTower(fieldPoint));
                recentStage.setMap(Y,X,GameFlag.DOUBLE_ROCKET_TOWER);
                this.getRecentStage().changeCoins(-Config.DOUBLE_ROCKET_TOWER_PRICE);
            }
        }
    }

    public void setIsMuteSoundEffect(boolean isMuteSoundEffect) {this.isMuteSoundEffect = isMuteSoundEffect;}
    public boolean getIsMuteSoundEffect() {return this.isMuteSoundEffect;}
}
