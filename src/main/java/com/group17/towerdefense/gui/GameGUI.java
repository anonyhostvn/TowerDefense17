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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameGUI {
    private Controller gameController;
    private HBox GUILayout;
    private GameFlag choosingTower;

    private static final Image sampleTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView sampleTowerIcon = new ImageView(sampleTowerImage);

    //Add imageView for single-barrel tower button
    private static final Image singleBarrelTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView singleBarrelTowerIcon =  new ImageView(singleBarrelTowerImage);

    private static final Image singleRocketTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile206.png"));
    private static final ImageView singleRocketTowerIcon =  new ImageView(singleRocketTowerImage);

    public GameGUI(Controller gameController) {
        this.gameController = gameController;

        sampleTowerIcon.setFitWidth(Config.ICON_WIDTH);
        sampleTowerIcon.setFitHeight(Config.ICON_HEIGHT);

        //Set the configuration for the single-barrel tower icon
        singleBarrelTowerIcon.setFitWidth(Config.ICON_WIDTH);
        singleBarrelTowerIcon.setFitHeight(Config.ICON_HEIGHT);
        //Set the configuration for the single-rocket tower icon
        singleRocketTowerIcon.setFitWidth(Config.ICON_WIDTH);
        singleRocketTowerIcon.setFitHeight(Config.ICON_HEIGHT);
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

    //Add button for single-barrel tower
    private Button singleBarrelTower() {
        Button singleBarrelTowerBtn = new Button("Single-barrel tower", singleBarrelTowerIcon);
        singleBarrelTowerBtn.setOnMouseClicked((e) -> {
            System.out.println("Set single-barrel tower");
            this.choosingTower = GameFlag.SINGLE_BARREL_TOWER;
        });
        return singleBarrelTowerBtn;
    }

    //Add button for single-rocket tower
    private Button singleRocketTower() {
        Button singleRocketTowerBtn = new Button("Single-rocket tower", singleRocketTowerIcon);
        singleRocketTowerBtn.setOnMouseClicked((e) -> {
            System.out.println("Set single-rocket tower");
            this.choosingTower = GameFlag.SINGLE_ROCKET_TOWER;
        });
        return singleRocketTowerBtn;
    }

    public GridPane gridLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setPadding(new Insets(10, 10, 10 , 10));
        gridPane.add(titleText(), 0, 0, 2, 1);
        gridPane.add(startButton(), 0, 1, 2, 1);
        gridPane.add(stopButton(), 0, 2, 2, 1);
        gridPane.add(sampleTower(), 0, 3, 2, 1);

        //Add two new towers' button
        gridPane.add(singleBarrelTower(), 0, 4, 2, 1);
        gridPane.add(singleRocketTower(), 0, 5, 2, 1);
        return gridPane;
    }

    public Text titleText() {
        Text text = new Text();
        text.setText("Tower Defense");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        return text;
    }

    public void handleClickEvent(MouseEvent e) {
        if (this.choosingTower == null) return;
        Point fieldPoint = Utility.fromScreenPointToFieldPoint(new Point(e.getX(), e.getY()));
        if(this.choosingTower == GameFlag.SAMPLE_TOWER) {
            this.gameController.getGameField().createNewTower(fieldPoint, GameFlag.SAMPLE_TOWER);
        }

        /* (for test only)
        if(this.choosingTower == GameFlag.SINGLE_BARREL_TOWER) {
            this.gameController.getGameField().createNewTower(fieldPoint, GameFlag.SINGLE_BARREL_TOWER);
        }
        if(this.choosingTower == GameFlag.SINGLE_ROCKET_TOWER) {
            this.gameController.getGameField().createNewTower(fieldPoint, GameFlag.SINGLE_ROCKET_TOWER);
        }*/
        this.choosingTower = null;
    }

    public HBox getGUILayout() {
        this.GUILayout = new HBox(gridLayout());
        return this.GUILayout;
    }
}
