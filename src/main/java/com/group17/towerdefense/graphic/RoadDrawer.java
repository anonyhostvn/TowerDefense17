package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RoadDrawer implements DrawerEntity {
    public Image roadImage = new Image(getClass().getClassLoader().getResourceAsStream("./Retina/towerDefense_tile050.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height) {
        graphicsContext.drawImage(roadImage, posX, posY, width, height);
    }
}