package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SingleBarrelBulletDrawer implements DrawerEntity {
    private static final Image bullet = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile272.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(Utility.rotateImage(bullet, angle), posX, posY, width, height);
    }
}
