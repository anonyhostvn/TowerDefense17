package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MountainDrawer implements DrawerEntity {
    public Image mountainImage = new Image(getClass().getClassLoader().getResourceAsStream("./Retina/towerDefense_tile024.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height) {
        graphicsContext.drawImage(mountainImage, posX, posY, width, height);
    }
}
