package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SingleBarrelTowerDrawer implements DrawerEntity {
    private static final Image base = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile180.png"));
    private static final Image gun = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(base, posX, posY, width, height);
        graphicsContext.drawImage(Utility.rotateImage(gun, angle), posX, posY, width, height);
    }
}
