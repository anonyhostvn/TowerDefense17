package com.group17.towerdefense;

import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gamemanager.GameStage;
import com.group17.towerdefense.gamemanager.GraphicProcessor;
import com.group17.towerdefense.utility.ThreadFactoryBuilder;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
    private final Media backgroundSoundSource = new Media(getClass().getResource("/bg-sound.mp3").toString());
    private final MediaPlayer bgPlayer = new MediaPlayer(backgroundSoundSource);

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


    public Controller(GraphicsContext graphicsContext, String mapName) {
        this.graphicsContext = graphicsContext;
        gameStage = new GameStage(mapName);
        gameField = new GameField(gameStage);
        graphicProcessor = new GraphicProcessor(graphicsContext, gameField);

        graphicProcessor.render();
    }

    public void start() {
        this.scheduledFuture = SCHEDULER.scheduleAtFixedRate(this::tick, 0, Config.GAME_NSPT, TimeUnit.NANOSECONDS);
        super.start();
    }

    public GameField getGameField() {
        return gameField;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public void startGame() {
        bgPlayer.play();
        super.start();
    }

    public void stopGame() {
        super.stop();
        muteBgSound();
    }

    public void muteBgSound() {
        bgPlayer.setMute(true);
    }

    public void unMuteBgSound() {
        bgPlayer.setMute(false);
    }

    @Override
    public void handle(long l) {
        if (this.getGameStage().gameStatus() != GameFlag.GAME_CONTINUE) {

            return;
        }
        gameField.tick();
        if (this.getGameStage().gameStatus() == GameFlag.GAME_WIN) {
            Media winSound = new Media(Controller.class.getResource("/sound/win.mp3").toString());
            MediaPlayer winSoundPLayer = new MediaPlayer(winSound);
            winSoundPLayer.play();
        }
        graphicProcessor.render();
    }

    public void setIsMuteSoundEffect(boolean isMuteSoundEffect) {this.gameField.setIsMuteSoundEffect(isMuteSoundEffect);}
}
