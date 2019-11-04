package com.group17.towerdefense;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gamemanager.GameStage;
import com.group17.towerdefense.gamemanager.GraphicProcessor;
import com.group17.towerdefense.utility.ThreadFactoryBuilder;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Controller extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final GameField gameField;
    private final GameStage gameStage;
    private final GraphicProcessor graphicProcessor;
    private long ticks = 0;

    private void tick() {
        this.ticks ++;
    }

    private static final ScheduledExecutorService SCHEDULER = Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryBuilder()
                    .setNamePrefix("Tick")
                    .setDaemon(true)
                    .setPriority(Thread.NORM_PRIORITY)
                    .build()
    );
    private ScheduledFuture<?> scheduledFuture;


    public Controller(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        gameStage = new GameStage();
        gameField = new GameField(gameStage);
        graphicProcessor = new GraphicProcessor(graphicsContext, gameField);
    }

    public void start() {
//        this.scheduledFuture = SCHEDULER.scheduleAtFixedRate(this::tick, 0, Config.GAME_NSPT, TimeUnit.NANOSECONDS);
        super.start();
    }

    @Override
    public void handle(long l) {
        gameField.tick();
        graphicProcessor.render();
    }

}
