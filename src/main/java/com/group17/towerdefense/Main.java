package com.group17.towerdefense;
import com.group17.towerdefense.Config;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();



        //Displaying the contents of the stage
        stage.setTitle(Config.GAME_NAME);
        stage.setResizable(false);
        stage.setScene(new Scene( new StackPane(canvas)));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
