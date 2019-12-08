package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RockOnesDrawer implements DrawerEntity {
    private static final Image rockImage = new Image(RockOnesDrawer.class.getResourceAsStream("/Retina/towerDefense_tile136.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(Utility.rotateImage(rockImage, angle), posX, posY, width, height);
    }
}
