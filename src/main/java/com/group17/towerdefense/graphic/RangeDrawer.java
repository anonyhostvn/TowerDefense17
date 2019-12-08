package com.group17.towerdefense.graphic;

import com.group17.towerdefense.Config;
import javafx.scene.canvas.GraphicsContext;

public class RangeDrawer {
    public void draw(GraphicsContext graphicsContext, double posX, double posY, double radius) {
        graphicsContext.strokeOval(posX , posY, radius, radius);
    }
}
