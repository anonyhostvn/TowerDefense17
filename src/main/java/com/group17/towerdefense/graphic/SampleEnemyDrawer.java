package com.group17.towerdefense.graphic;

import com.group17.towerdefense.gameobject.title.ground.Mountain;
import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SampleEnemyDrawer implements DrawerEntity {
    private static Image enemyImage = new Image(Mountain.class.getResourceAsStream("/Retina/towerDefense_tile246.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(Utility.rotateImage(enemyImage, angle), posX, posY, width, height);
    }
}
