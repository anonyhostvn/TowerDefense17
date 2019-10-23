package com.group17.towerdefense.graphic;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;

public class GraphicProcessor {
    private int numEntity;
    private DrawerEntity[] all;
    private GraphicsContext graphicsContext;

    public GraphicProcessor(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        all = new DrawerEntity[Config.MAX_ENTITY];
        numEntity = 0;
    }

    public void render() {

    }
}
