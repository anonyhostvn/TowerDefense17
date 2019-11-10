package com.group17.towerdefense;
import com.group17.towerdefense.Config;

import com.group17.towerdefense.gui.GameGUI;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        final Controller controller = new Controller(graphicsContext);

        HBox root = new HBox();
        final GameGUI gameGUI = new GameGUI(controller);
        root.getChildren().addAll(canvas, gameGUI.getGUILayout());
        canvas.setOnMouseClicked((e) -> {
            gameGUI.handleClickEvent(e);
        });

        //Displaying the contents of the stage
        stage.setTitle(Config.GAME_NAME);
        stage.setResizable(false);
        stage.setScene(new Scene( new StackPane(root)));
        stage.show();

//        controller.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
