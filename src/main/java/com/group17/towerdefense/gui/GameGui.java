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

public class GameGui {
    private Controller gameController;
    private HBox GUILayout;
    private GameFlag choosingTower;
    private Point choosingPosition;

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Stage windowStage;

    private static final Image sampleTowerImage = new Image(RoadDrawer.class.getResourceAsStream("/Retina/towerDefense_tile249.png"));
    private static final ImageView sampleTowerIcon = new ImageView(sampleTowerImage);
    static {
        sampleTowerIcon.setFitWidth(Config.ICON_WIDTH);
        sampleTowerIcon.setFitHeight(Config.ICON_HEIGHT);
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
        });
        return sampleTowerBtn;
    }

    private Button sellButton() {
        Button sampleTowerBtn = new Button("Sell", sellIconView);
        sampleTowerBtn.setOnMouseClicked((e) -> {
            this.gameController.getGameField().sellChooseTower();
        });
        return sampleTowerBtn;
    }

    private GridPane gridLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setPadding(new Insets(10, 10, 10 , 10));
        gridPane.add(titleText(), 0, 0, 2, 1);
        gridPane.add(startButton(), 0, 1, 2, 1);
        gridPane.add(stopButton(), 0, 2, 2, 1);
        gridPane.add(restartButton(), 0, 3, 2, 1);
        gridPane.add(sellButton(), 0, 4, 3,1);
        gridPane.add(sampleTower(), 0, 5, 2, 1);
        return gridPane;
    }

    private Text titleText() {
        Text text = new Text();
        text.setText("Tower Defense");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        return text;
    }

    private void handleClickEvent(MouseEvent e) {
        if (this.choosingTower != null) {
            Point fieldPoint = Utility.fromScreenPointToFieldPoint(new Point(e.getX(), e.getY()));
            this.gameController.getGameField().createNewTower(fieldPoint, GameFlag.SAMPLE_TOWER);
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
        gameController = new Controller(graphicsContext);

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
