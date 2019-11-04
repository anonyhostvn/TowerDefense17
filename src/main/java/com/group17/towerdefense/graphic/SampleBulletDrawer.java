package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SampleBulletDrawer implements DrawerEntity{
    private static final Image sampleBulletImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile251.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(Utility.rotateImage(sampleBulletImage, angle), posX, posY, width, height);
    }
}
