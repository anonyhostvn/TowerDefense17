package com.group17.towerdefense.graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HoverRectangleDrawer implements DrawerEntity {
    private static Image rectImage = new Image(HoverRectangleDrawer.class.getResourceAsStream("/Retina/towerDefense_tile068.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(rectImage, posX, posY, width, height);
    }
}