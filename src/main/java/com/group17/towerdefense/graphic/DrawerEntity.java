package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;

public interface DrawerEntity {
    public void draw(GraphicsContext graphicsContext, int posX, int posY, int width, int height);
}
