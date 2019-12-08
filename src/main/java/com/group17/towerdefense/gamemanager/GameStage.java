package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.gameflag.GameFlag;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.TurningPoint;

import java.io.InputStream;
import java.util.Scanner;

public class GameStage {
    private GameFlag[][] map;
    private Point startPoint;
    private int width;
    private int height;
    private long score;
    private TurningPoint[] turningPoints;
    private int[] listEnemy;
    private int remainEnemy;

    private int health, coins;

    public GameStage(String mapName) {
        try {
            final InputStream inpStream = getClass().getClassLoader().getResourceAsStream("./map-info-" + mapName + ".txt");

            Scanner scannerInp = new Scanner(inpStream);

            height = scannerInp.nextInt();
            width = scannerInp.nextInt();
            this.startPoint = new Point (scannerInp.nextInt(), scannerInp.nextInt());

            this.map = new GameFlag[height][width];
            for (int i = 0; i < height; i++)
                for (int j = 0; j < width; j++) {
                    int temp = scannerInp.nextInt();
                    if (temp == 0) map[i][j] = GameFlag.MOUNTAIN;
                    else map[i][j] = GameFlag.ROAD;
//                    map[i][j] = scannerInp.nextInt();
                }
            this.health = 5;
            this.coins = 100;

            int cntTurningPoint = scannerInp.nextInt();
            turningPoints = new TurningPoint[cntTurningPoint];
            for (int i = 0; i < cntTurningPoint; i++) {
                turningPoints[i] = new TurningPoint(new Point(scannerInp.nextInt(), scannerInp.nextInt()), scannerInp.nextInt());
            }

            System.out.println(mapName);
            for (TurningPoint tp : turningPoints) {
                tp.getPoint().print("Turning points :");
            }

            int cntEnemy = scannerInp.nextInt();
            listEnemy = new int[cntEnemy];
            for (int i = 0; i < cntEnemy; i++) listEnemy[i] = scannerInp.nextInt();
            this.remainEnemy = listEnemy.length;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Resource not found");
        }
    }

    public void doUpdate() {

    }

    public void destroyEnemy() {
        this.remainEnemy --;
    }

    public GameFlag gameStatus(){
        if (this.health > 0 && this.remainEnemy == 0) return GameFlag.GAME_WIN;
        else if (this.health <= 0) return GameFlag.GAME_LOOSE;
        return GameFlag.GAME_CONTINUE;
    }

    public int[] getListEnemy() {
        return listEnemy;
    }

    public boolean changeCoins(int changeCoins) {
        if (this.coins + changeCoins < 0) return false;
        this.coins += changeCoins;
        return true;
    }

    public boolean decreaseHealth() {
        this.health --;
        return this.health != 0;
    }

    public void sellTower(int x, int y) {
        this.map[x][y] = GameFlag.MOUNTAIN;
    }

    public boolean isLose() {
        return this.health == 0;
    }

    public long getScore() {
        return this.score;
    }

    public int getHealth() {
        return this.health;
    }

    public int getCoins() {
        return this.coins;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameFlag getMapIn(int x, int y) {
        return map[x][y];
    }

    public TurningPoint[] getTurningPoints() {
        return this.turningPoints;
    }

    public void setMap(int x, int y, GameFlag obj) {
        this.map[x][y] = obj;
    }
}
