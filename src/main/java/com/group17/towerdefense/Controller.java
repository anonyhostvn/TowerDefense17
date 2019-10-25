package com.group17.towerdefense;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gamemanager.GameStage;
import com.group17.towerdefense.gamemanager.GraphicProcessor;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class Controller extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final GameField gameField;
    private final GameStage gameStage;
    private final GraphicProcessor graphicProcessor;

    public Controller(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        gameStage = new GameStage();
        gameField = new GameField(gameStage);
        graphicProcessor = new GraphicProcessor(graphicsContext, gameField);
    }

    @Override
    public void handle(long l) {
        gameField.tick();
        graphicProcessor.render();
    }

}
