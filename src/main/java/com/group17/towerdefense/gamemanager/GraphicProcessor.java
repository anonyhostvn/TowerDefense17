package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameobject.movable.bullet.SampleBullet;
import com.group17.towerdefense.gameobject.title.Spawner.SampleSpawner;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.gameobject.movable.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.title.ground.Mountain;
import com.group17.towerdefense.gameobject.title.ground.Road;
import com.group17.towerdefense.gameobject.title.tower.SampleTower;
import com.group17.towerdefense.graphic.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

import java.util.*;

public class GraphicProcessor {
    private GraphicsContext graphicsContext;
    private GameField gameField;

    private final Map<Class<? extends GameEntity>, Integer> entityOrder = new HashMap<Class<? extends GameEntity>, Integer>(Map.ofEntries(
            Map.entry(Mountain.class, 1),
            Map.entry(Road.class, 2),
            Map.entry(SampleEnemy.class, 3),
            Map.entry(SampleTower.class, 4),
            Map.entry(SampleBullet.class, 5),
            Map.entry(SampleSpawner.class, 6)
    ));


    private
    int entityOrderComparator(GameEntity A , GameEntity B) {
        return Integer.compare(entityOrder.get(A.getClass()), entityOrder.get(B.getClass()));
     }

    private final Map<?, DrawerEntity> pairGraphics = new HashMap<Class<? extends GameEntity>, DrawerEntity>(Map.ofEntries(
            Map.entry(Mountain.class, new MountainDrawer()),
            Map.entry(Road.class, new RoadDrawer()),
            Map.entry(SampleEnemy.class, new SampleEnemyDrawer()),
            Map.entry(SampleTower.class, new SampleTowerDrawer()),
            Map.entry(SampleBullet.class, new SampleBulletDrawer()),
            Map.entry(SampleSpawner.class, new SampleSpawnerDrawer())
    ));

    public GraphicProcessor(GraphicsContext graphicsContext, GameField gameField) {
        this.graphicsContext = graphicsContext;
        this.gameField = gameField;
    }

    public void render() {
        graphicsContext.fillRect(0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        GameEntity[] entityArray = new GameEntity[gameField.getAllGameEntity().size()];
        int cntEntity = 0;
        for (GameEntity gameEntity : gameField.getAllGameEntity()){
            entityArray[cntEntity++] = gameEntity;
        }
        Arrays.sort(entityArray, this::entityOrderComparator);

        for (GameEntity gameEntity: entityArray) {
            pairGraphics.get(gameEntity.getClass()).draw(graphicsContext, gameEntity.getPosX(), gameEntity.getPosY(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight(), gameEntity.getAngle());
        }

        graphicsContext.fillText("Coins: " + this.gameField.getRecentStage().getCoins(), 20, 20);
        graphicsContext.fillText("Health: " + this.gameField.getRecentStage().getHealth(), 20, 40);
    }
}