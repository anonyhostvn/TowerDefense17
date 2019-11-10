package com.group17.towerdefense.graphic;

import com.group17.towerdefense.utility.Utility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SampleTowerDrawer implements DrawerEntity {
    private static final Image under = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile181.png"));
    private static final Image guns = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));

    @Override
    public void draw(GraphicsContext graphicsContext, double posX, double posY, int width, int height, double angle) {
        graphicsContext.drawImage(under, posX, posY, width, height);
        graphicsContext.drawImage(Utility.rotateImage(guns, angle), posX, posY, width, height);
    }
}
