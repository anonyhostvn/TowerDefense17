package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BigRocketDrawer implements DrawerEntity {
    private static final Image bigRocket = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile252.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(Utility.rotateImage(bigRocket, angle), posX, posY, width, height);
    }
}
