package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.GameEntity;
import com.group17.towerdefense.entity.title.ground.Road;
import com.group17.towerdefense.graphic.DrawerEntity;
import com.group17.towerdefense.graphic.MountainDrawer;
import com.group17.towerdefense.graphic.RoadDrawer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GraphicProcessor {
    private int numEntity;
    private GraphicsContext graphicsContext;
    private GameField gameField;
    private ArrayList<DrawerEntity> allDrawer;

    public GraphicProcessor(GraphicsContext graphicsContext, GameField gameField) {
        this.graphicsContext = graphicsContext;
        numEntity = 0;
        this.gameField = gameField;
    }

    public void render() {
        graphicsContext.fillRect(0,0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        for (GameEntity gameEntity: gameField.getAllGameEntity()) {
            if (gameEntity instanceof Road) {
                RoadDrawer roadDrawer = new RoadDrawer();
                roadDrawer.draw(graphicsContext, gameEntity.getPosY(), gameEntity.getPosX(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight());
            } else {
                MountainDrawer mountainDrawer = new MountainDrawer();
                mountainDrawer.draw(graphicsContext, gameEntity.getPosY(), gameEntity.getPosX(), (int) gameEntity.getWidth(), (int) gameEntity.getHeight());
            }
        }
    }
}
