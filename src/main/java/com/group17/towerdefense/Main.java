package com.group17.towerdefense;

import com.group17.towerdefense.gui.GameGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
