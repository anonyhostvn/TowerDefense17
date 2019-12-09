package com.group17.towerdefense.gui;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.Controller;
import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.graphic.RoadDrawer;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.utility.Utility;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class GameGui {
    private Controller gameController;
    private HBox GUILayout;
    private GameFlag choosingTower;
    private Point choosingPosition;

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Stage windowStage;
    private String mapName = "HANOI";


    // CHOOSE MAP FIELD
    ComboBox selectMap = new ComboBox();
    {
        selectMap.getItems().addAll(
                Config.mapNameConst.get("HANOI"),
                Config.mapNameConst.get("HCM"),
                Config.mapNameConst.get("HP")
        );
        selectMap.setValue(Config.mapNameConst.get("HANOI"));
    }

    // SAMPLE TOWER
    private static final Image sampleTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView sampleTowerIcon = new ImageView(sampleTowerImage);
    static {
        sampleTowerIcon.setFitWidth(Config.ICON_WIDTH);
        sampleTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }

    // SINGLE-BARREL TOWER
    private static final Image SBarrelTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView SBarrelTowerIcon = new ImageView(SBarrelTowerImage);
    static {
        SBarrelTowerIcon.setFitWidth(Config.ICON_WIDTH);
        SBarrelTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }

    // DOUBLE-BARREL TOWER
    private static final Image DBarrelTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile250.png"));
    private static final ImageView DBarrelTowerIcon = new ImageView(DBarrelTowerImage);
    static {
        DBarrelTowerIcon.setFitWidth(Config.ICON_WIDTH);
        DBarrelTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }

    // SINGLE-ROCKET TOWER
    private static final Image SRocketTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile206.png"));
    private static final ImageView SRocketTowerIcon = new ImageView(SRocketTowerImage);
    static {
        SRocketTowerIcon.setFitWidth(Config.ICON_WIDTH);
        SRocketTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }

    // DOUBLE-ROCKET TOWER
    private static final Image DRocketTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile205.png"));
    private static final ImageView DRocketTowerIcon = new ImageView(DRocketTowerImage);
    static {
        DRocketTowerIcon.setFitWidth(Config.ICON_WIDTH);
        DRocketTowerIcon.setFitHeight(Config.ICON_HEIGHT);
    }


    private static final Image sellIcon = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile287.png"));
    private static final ImageView sellIconView = new ImageView(sellIcon);
    static {
        sellIconView.setFitWidth(Config.ICON_WIDTH);
        sellIconView.setFitHeight(Config.ICON_HEIGHT);
    }

    public GameGui(Stage gameStage) {

        this.windowStage = gameStage;
        this.choosingPosition = null;

        initGame();
    }

    private Button muteBgSoundButton() {
        Button muteBtn = new Button("Mute background sound");
        muteBtn.setOnAction((e) -> {
            gameController.muteBgSound();
        });
        return muteBtn;
    }

    private Button unMuteBgSoundButton() {
        Button muteBtn = new Button("Turn on background sound");
        muteBtn.setOnAction((e) -> {
            gameController.unMuteBgSound();
        });
        return muteBtn;
    }

    private Button muteSoundEffectButton() {
        Button muteBtn = new Button("Mute sound effect");
        muteBtn.setOnAction((e) -> {
            gameController.setIsMuteSoundEffect(true);
        });
        return muteBtn;
    }

    private Button unMuteSoundEffectButton() {
        Button muteBtn = new Button("Turn on sound effect");
        muteBtn.setOnAction((e) -> {
            gameController.setIsMuteSoundEffect(false);
        });
        return muteBtn;
    }

    private Button stopButton() {
        Button quitBtn = new Button("Stop game");
        quitBtn.setOnAction((e) -> {
            gameController.stopGame();
        });
        return quitBtn;
    }

    private Button startButton() {
        Button startBtn = new Button("Start game");
        startBtn.setOnAction((e) -> {
            gameController.startGame();
        });
        return startBtn;
    }

    private Button restartButton() {
        Button restartBtn = new Button("Restart game");
        restartBtn.setOnAction((e) -> {
            this.initGame();
        });
        return restartBtn;
    }

    private Button sampleTower() {
        Button sampleTowerBtn = new Button("Sample tower", sampleTowerIcon);
        sampleTowerBtn.setOnMouseClicked((e) -> {
            this.choosingTower = GameFlag.SAMPLE_TOWER;
            this.gameController.getGameField().setIsChooseATower(true);
            this.gameController.getGameField().setRecentHoverRange(Config.SAMPLE_TOWER_RANGE);
        });
        return sampleTowerBtn;
    }

    // SINGLE-BARREL TOWER
    private Button SBarrelTower() {
        Button SBarrelTowerBtn = new Button("30 Coins", SBarrelTowerIcon);
        SBarrelTowerBtn.setOnMouseClicked((e) -> {
            this.choosingTower = GameFlag.SINGLE_BARREL_TOWER;
            this.gameController.getGameField().setIsChooseATower(true);
            this.gameController.getGameField().setRecentHoverRange(Config.SINGLE_BARREL_TOWER_RANGE);
        });
        return SBarrelTowerBtn;
    }

    // DOUBLE-BARREL TOWER
    private Button DBarrelTower() {
        Button DBarrelTowerBtn = new Button("50 Coins", DBarrelTowerIcon);
        DBarrelTowerBtn.setOnMouseClicked((e) -> {
            this.choosingTower = GameFlag.DOUBLE_BARREL_TOWER;
            this.gameController.getGameField().setIsChooseATower(true);
            this.gameController.getGameField().setRecentHoverRange(Config.DOUBLE_BARREL_TOWER_RANGE);
        });
        return DBarrelTowerBtn;
    }

    // SINGLE-ROCKET TOWER
    private Button SRocketTower() {
        Button SRocketTowerBtn = new Button("120 Coins", SRocketTowerIcon);
        SRocketTowerBtn.setOnMouseClicked((e) -> {
            this.choosingTower = GameFlag.SINGLE_ROCKET_TOWER;
            this.gameController.getGameField().setIsChooseATower(true);
            this.gameController.getGameField().setRecentHoverRange(Config.SINGLE_ROCKET_TOWER_RANGE);
        });
        return SRocketTowerBtn;
    }

    // DOUBLE-ROCKET TOWER
    private Button DRocketTower() {
        Button DRocketTowerBtn = new Button("80 Coins", DRocketTowerIcon);
        DRocketTowerBtn.setOnMouseClicked((e) -> {
            this.choosingTower = GameFlag.DOUBLE_ROCKET_TOWER;
            this.gameController.getGameField().setIsChooseATower(true);
            this.gameController.getGameField().setRecentHoverRange(Config.DOUBLE_ROCKET_TOWER_RANGE);
        });
        return DRocketTowerBtn;
    }

    private Button sellButton() {
        Button sampleTowerBtn = new Button("Sell", sellIconView);
        sampleTowerBtn.setOnMouseClicked((e) -> {
            this.gameController.getGameField().sellChooseTower();
        });
        return sampleTowerBtn;
    }

    private Button activeMapButton() {
        Button activeMapBtn = new Button("Active map");
        activeMapBtn.setOnMouseClicked(e -> {
            String chooseValue = selectMap.getValue().toString();
            for (Map.Entry<String, String> entry : Config.mapNameConst.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                if (chooseValue.compareTo(val) == 0) this.mapName = key;
            }
            initGame();
        });
        return activeMapBtn;
    }

    private GridPane gridLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setPadding(new Insets(10, 10, 10 , 10));
        gridPane.add(textField("Tower defense 17"), 0, 0, 2, 1);
        gridPane.add(startButton(), 0, 1, 2, 1);
        gridPane.add(stopButton(), 1, 1, 2, 1);
        gridPane.add(restartButton(), 0, 3, 2, 1);
        gridPane.add(sellButton(), 1, 3, 3,1);
        gridPane.add(SBarrelTower(), 0, 6, 1, 1);
        gridPane.add(DBarrelTower(), 1, 6, 1, 1);
        gridPane.add(SRocketTower(), 0, 7, 1, 1);
        gridPane.add(DRocketTower(), 1, 7, 1, 1);
        gridPane.add(activeMapButton(), 0, 8, 1, 1);
        gridPane.add(selectMap, 1, 8 , 1, 1);
        gridPane.add(muteBgSoundButton(), 0, 9 , 1 , 1);
        gridPane.add(unMuteBgSoundButton(), 1, 9 , 1 , 1);
        gridPane.add(muteSoundEffectButton(), 0, 10 , 1 , 1);
        gridPane.add(unMuteSoundEffectButton(), 1, 10 , 1 , 1);
        return gridPane;
    }

    private Text textField(String str) {
        Text text = new Text();
        text.setText(str);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        return text;
    }

    private void handleClickEvent(MouseEvent e) {
        if (this.choosingTower != null) {
            Point fieldPoint = Utility.fromScreenPointToFieldPoint(new Point(e.getX(), e.getY()));
            this.gameController.getGameField().createNewTower(fieldPoint, this.choosingTower);
            this.choosingTower = null;
        } else {
            this.choosingPosition = new Point(e.getX(), e.getY());
            this.gameController.getGameField().setChoosingPosition(new Point(choosingPosition));
        }

        this.gameController.getGameField().setIsChooseATower(false);
    }

    private HBox getGUILayout() {
        this.GUILayout = new HBox(gridLayout());
        return this.GUILayout;
    }

    private void initGame() {
        canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        gameController = new Controller(graphicsContext, mapName);

        canvas.setOnMouseClicked(this::handleClickEvent);
        canvas.setOnMouseMoved((e) -> {
            this.gameController.getGameField().setRecentMousePosition(new Point(e.getX(), e.getY()));
        });

        canvas.setOnMouseExited((e) -> {
            this.gameController.getGameField().setRecentMousePosition(null);
        });
        displayGameScreen();
    }

    public void displayGameScreen() {
        HBox root = new HBox();
        root.getChildren().addAll(canvas, getGUILayout());
        windowStage.setScene(new Scene( new StackPane(root)));
    }
}
