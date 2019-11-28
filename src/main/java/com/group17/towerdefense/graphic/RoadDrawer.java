package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RoadDrawer implements DrawerEntity {
    private static final Image roadImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile257.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(roadImage, posX, posY, width, height);
    }
}