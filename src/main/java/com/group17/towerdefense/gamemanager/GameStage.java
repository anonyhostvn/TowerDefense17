package com.group17.towerdefense.gamemanager;

import com.group17.towerdefense.Main;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.TurningPoint;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class GameStage {
    private int[][] map;
    private Point startPoint;
    private int width;
    private int height;
    private long score;
    private TurningPoint[] turningPoints;
    private int[] listEnemy;

    private int health, coins;

    public GameStage() {
        try {
            final InputStream inpStream = getClass().getClassLoader().getResourceAsStream("./map-info.txt");

            Scanner scannerInp = new Scanner(inpStream);

            height = scannerInp.nextInt();
            width = scannerInp.nextInt();
            this.startPoint = new Point (scannerInp.nextInt(), scannerInp.nextInt());

            this.map = new int[height][width];
            for (int i = 0; i < height; i++)
                for (int j = 0; j < width; j++) map[i][j] = scannerInp.nextInt();
            this.health = 5;
            this.coins = 0;

            int cntTurningPoint = scannerInp.nextInt();
            turningPoints = new TurningPoint[cntTurningPoint];
            for (int i = 0; i < cntTurningPoint; i++) {
                turningPoints[i] = new TurningPoint(new Point(scannerInp.nextInt(), scannerInp.nextInt()), scannerInp.nextInt());
            }

            int cntEnemy = scannerInp.nextInt();
            listEnemy = new int[cntEnemy];
            for (int i = 0; i < cntEnemy; i++) listEnemy[i] = scannerInp.nextInt();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Resource not found");
        }
    }

    public void doUpdate() {

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

    public int getMapIn(int x, int y) {
        return map[x][y];
    }

    public TurningPoint[] getTurningPoints() {
        return this.turningPoints;
    }
}
