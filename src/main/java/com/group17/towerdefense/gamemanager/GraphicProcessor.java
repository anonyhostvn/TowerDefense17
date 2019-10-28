package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.GameEntity;
import com.group17.towerdefense.entity.movable.enemy.SampleEnemy;
import com.group17.towerdefense.entity.title.ground.Mountain;
import com.group17.towerdefense.entity.title.ground.Road;
import com.group17.towerdefense.graphic.DrawerEntity;
import com.group17.towerdefense.graphic.SampleEnemyDrawer;
import com.group17.towerdefense.graphic.MountainDrawer;
import com.group17.towerdefense.graphic.RoadDrawer;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Pair;

import java.util.*;

public class GraphicProcessor {
    private int numEntity;
    private GraphicsContext graphicsContext;
    private GameField gameField;
    private ArrayList<DrawerEntity> allDrawer;

    private final Map<Class<? extends GameEntity>, Integer> entityOrder = new HashMap<Class<? extends GameEntity>, Integer>(Map.ofEntries(
            Map.entry(Mountain.class, 1),
            Map.entry(Road.class, 2),
            Map.entry(SampleEnemy.class, 3)
    ));

    private int entityOrderComparator(GameEntity A , GameEntity B) {
        return Integer.compare(entityOrder.get(A.getClass()), entityOrder.get(B.getClass()));
     }

    private final Map<?, DrawerEntity> pairGraphics = new HashMap<Class<? extends GameEntity>, DrawerEntity>(Map.ofEntries(
            Map.entry(Mountain.class, new MountainDrawer()),
            Map.entry(Road.class, new RoadDrawer()),
            Map.entry(SampleEnemy.class, new SampleEnemyDrawer())
    ));

    public GraphicProcessor(GraphicsContext graphicsContext, GameField gameField) {
        this.graphicsContext = graphicsContext;
        numEntity = 0;
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
            pairGraphics.get(gameEntity.getClass()).draw(graphicsContext, gameEntity.getPosX(), gameEntity.getPosY(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight());
        }
    }
}
