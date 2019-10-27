package com.group17.towerdefense.graphic;

import com.group17.towerdefense.entity.title.ground.Mountain;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MountainDrawer implements DrawerEntity {
    private static Image mountainImage = new Image(Mountain.class.getResourceAsStream("/Retina/towerDefense_tile024.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height) {
        graphicsContext.drawImage(mountainImage, posX, posY, width, height);
    }
}
