package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gameobject.bullet.SampleBullet;
import com.group17.towerdefense.gameobject.enemy.BossEnemy;
import com.group17.towerdefense.gameobject.enemy.PlaneEnemy;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.enemy.TankerEnemy;
import com.group17.towerdefense.gameobject.ground.Mountain;
import com.group17.towerdefense.gameobject.ground.Road;
import com.group17.towerdefense.gameobject.spawner.SampleSpawner;
import com.group17.towerdefense.gameobject.tower.SampleTower;
import com.group17.towerdefense.graphic.*;
import com.group17.towerdefense.repositories.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphicProcessor {
    private GraphicsContext graphicsContext;
    private GameField gameField;

    private final Map<Class<? extends GameEntity>, Integer> entityOrder = new HashMap<Class<? extends GameEntity>, Integer>(Map.ofEntries(
            Map.entry(Mountain.class, 1),
            Map.entry(Road.class, 2),
            Map.entry(SampleEnemy.class, 3),
            Map.entry(SampleTower.class, 4),
            Map.entry(SampleBullet.class, 5),
            Map.entry(SampleSpawner.class, 6),
            Map.entry(TankerEnemy.class, 7),
            Map.entry(BossEnemy.class, 8),
            Map.entry(PlaneEnemy.class, 9)
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
            Map.entry(SampleSpawner.class, new SampleSpawnerDrawer()),
            Map.entry(TankerEnemy.class, new TankerEnemyDrawer()),
            Map.entry(BossEnemy.class, new BossEnemyDrawer()),
            Map.entry(PlaneEnemy.class, new PlaneEnemyDrawer())
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
        graphicsContext.fillText("Level: " + this.gameField.getRecentStage().getLevel(), 20, 60);

        if (this.gameField.getRecentStage().gameStatus() == GameFlag.GAME_LOOSE) {
            graphicsContext.fillText("Game Over", Config.SCREEN_WIDTH / 2 , Config.SCREEN_HEIGHT / 2);
            graphicsContext.strokeText("Game Over" , Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
        } else if (this.gameField.getRecentStage().gameStatus() == GameFlag.GAME_WIN) {
            graphicsContext.fillText("Winner", Config.SCREEN_WIDTH / 2 , Config.SCREEN_HEIGHT / 2);
            graphicsContext.strokeText("Winner" , Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
        }
    }
}