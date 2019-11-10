package com.group17.towerdefense.gui;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.Controller;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.graphic.RoadDrawer;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class GameGUI {
    private Controller gameController;
    private HBox GUILayout;
    private GameFlag choosingTower;
    private GameStageGUI gameStageGUI;

    private static final Image sampleTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView sampleTowerIcon = new ImageView(sampleTowerImage);

    public GameGUI(Controller gameController) {
        this.gameController = gameController;

        this.gameStageGUI = new GameStageGUI(this.gameController.getGameField().getRecentStage());
        this.GUILayout = new HBox(gridLayout());
        this.GUILayout.getChildren().add(this.gameStageGUI.getGameStageGUI());

        sampleTowerIcon.setFitWidth(Config.ICON_WIDTH);
        sampleTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }

    public Button stopButton() {
        Button quitBtn = new Button("Stop game");
        quitBtn.setOnAction((e) -> {
            gameController.stopGame();
        });
        return quitBtn;
    }

    public Button startButton() {
        Button stopBtn = new Button("Start game");
        stopBtn.setOnAction((e) -> {
            gameController.startGame();
        });
        return stopBtn;
    }

    private Button sampleTower() {
        Button sampleTowerBtn = new Button("Sample tower", sampleTowerIcon);
        sampleTowerBtn.setOnMouseClicked((e) -> {
            System.out.println("Set sample tower");
            this.choosingTower = GameFlag.SAMPLE_TOWER;
        });
        return sampleTowerBtn;
    }

    public GridPane gridLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10 , 10));
        gridPane.add(startButton(), 0, 0, 2, 1);
        gridPane.add(stopButton(), 0, 1, 2, 1);
        gridPane.add(sampleTower(), 0, 2, 2, 1);
        return gridPane;
    }

    public void addText() {
        Text text = new Text();
        text.setText("Sample Text");

        this.GUILayout.getChildren().add(text);
    }

    public void handleClickEvent(MouseEvent e) {
        if (this.choosingTower == null) return;
        Point fieldPoint = Utility.fromScreenPointToFieldPoint(new Point(e.getX(), e.getY()));
        this.gameController.getGameField().createNewTower(fieldPoint, GameFlag.SAMPLE_TOWER);
        this.choosingTower = null;

    }

    public HBox getGUILayout() {
        return this.GUILayout;
    }
}
