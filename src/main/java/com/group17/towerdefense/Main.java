package com.group17.towerdefense;

import com.group17.towerdefense.gui.GameGui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        GameGui game = new GameGui(stage);

        //Displaying the contents of the stage
        stage.setTitle(Config.GAME_NAME);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
