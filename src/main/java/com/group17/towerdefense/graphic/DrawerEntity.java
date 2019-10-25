package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;

public interface DrawerEntity {
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height);
}
