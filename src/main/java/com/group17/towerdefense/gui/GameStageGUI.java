package com.group17.towerdefense.gui;

import com.group17.towerdefense.gamemanager.GameStage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameStageGUI {
    private GameStage recentStage;
    private HBox gameStageGUI;

    public GameStageGUI(GameStage recentStage) {
        this.recentStage = recentStage;
        gameStageGUI = new HBox(getGridPane());
    }

    public Text coinsText() {
        Text coinsText = new Text();
        coinsText.setText("Coins : " + this.recentStage.getCoins());
        return coinsText;
    }

    public GridPane getGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.add(coinsText(), 0, 1, 2, 1);
        return gridPane;
    }

    public HBox getGameStageGUI() {
        return this.gameStageGUI;
    }
}
