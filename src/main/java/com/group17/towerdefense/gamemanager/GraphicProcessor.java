package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gameobject.bullet.*;
import com.group17.towerdefense.gameobject.enemy.SampleEnemy;
import com.group17.towerdefense.gameobject.ground.Mountain;
import com.group17.towerdefense.gameobject.ground.Road;
import com.group17.towerdefense.gameobject.spawner.SampleSpawner;
import com.group17.towerdefense.gameobject.tower.*;
import com.group17.towerdefense.graphic.*;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;

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
            Map.entry(SampleSpawner.class, new SampleSpawnerDrawer()),
            Map.entry(SBarrelTower.class, new SBarrelTowerDrawer()),
            Map.entry(Bullet_1.class, new Bullet_1_Drawer()),
            Map.entry(DBarrelTower.class, new DBarrelTowerDrawer()),
            Map.entry(Bullet_2.class, new Bullet_2_Drawer()),
            Map.entry(SRocketTower.class, new SRocketTowerDrawer()),
            Map.entry(BigRocket.class, new BigRocketDrawer()),
            Map.entry(DRocketTower.class, new DRocketTowerDrawer()),
            Map.entry(Rocket.class, new RocketDrawer())
    ));

    private final DrawerEntity hoverRectDrawer = new HoverRectangleDrawer();

    public GraphicProcessor(GraphicsContext graphicsContext, GameField gameField) {
        this.graphicsContext = graphicsContext;
        this.gameField = gameField;
    }

    public void render() {
        graphicsContext.fillRect(0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        for (GameEntity gameEntity: gameField.getAllGameEntity()) {
            pairGraphics.get(gameEntity.getClass()).draw(graphicsContext, gameEntity.getPosX(), gameEntity.getPosY(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight(), gameEntity.getAngle());
        }

        if (this.gameField.getIsChooseATower() && this.gameField.getRecentMousePosition() != null) {
            Point drawerPosition = Utility.getTopLeftPositionOfBlock(gameField.getRecentMousePosition());
            hoverRectDrawer.draw(graphicsContext, drawerPosition.getX(), drawerPosition.getY(), Config.SCREEN_WIDTH_RATIO, Config.SCREEN_HEIGHT_RATIO, 0);
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