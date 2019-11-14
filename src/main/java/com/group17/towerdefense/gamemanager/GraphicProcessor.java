package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gameobject.bullet.SampleBullet;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
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

        for (GameEntity gameEntity: gameField.getAllGameEntity()) {
            pairGraphics.get(gameEntity.getClass()).draw(graphicsContext, gameEntity.getPosX(), gameEntity.getPosY(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight(), gameEntity.getAngle());
        }

        graphicsContext.fillText("Coins: " + this.gameField.getRecentStage().getCoins(), 20, 20);
        graphicsContext.fillText("Health: " + this.gameField.getRecentStage().getHealth(), 20, 40);

        if (this.gameField.getRecentStage().gameStatus() == GameFlag.GAME_LOOSE) {
            graphicsContext.fillText("Game Over", Config.SCREEN_WIDTH / 2 , Config.SCREEN_HEIGHT / 2);
            graphicsContext.strokeText("Game Over" , Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
        } else if (this.gameField.getRecentStage().gameStatus() == GameFlag.GAME_WIN) {
            graphicsContext.fillText("Winner", Config.SCREEN_WIDTH / 2 , Config.SCREEN_HEIGHT / 2);
            graphicsContext.strokeText("Winner" , Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
        }
    }
}