package com.group17.towerdefense.gameobject.title.Spawner;

import com.group17.towerdefense.abstractfactory.AbstractEntityFactory;
import com.group17.towerdefense.abstractfactory.EnemyFactory;
import com.group17.towerdefense.Config;
import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.mesurement.Point;

public class SampleSpawner extends AbstractSpawner{

    private Point position;
    private int frameCount = 0;
    private EnemyFactory enemyFactory;
    private int[] listEnemy;
    private int cnt = 0;
    private GameField recentGameField;

    public SampleSpawner(Point position, AbstractEntityFactory abstractEntityFactory, int[] listEnemy, GameField recentGameField) {
        this.position = new Point(position);
        this.enemyFactory= abstractEntityFactory.createEnemyFactory();
        this.listEnemy = listEnemy;
        this.recentGameField = recentGameField;
    }

    @Override
    public int getFrameGap() {
        return Config.SAMPLE_SPAWNER_FRAME_GAP;
    }

    @Override
    public int getFrameCount() {
        return this.frameCount;
    }

    @Override
    public void resetFrameCount() {
        this.frameCount = 0;
    }

    @Override
    public void incFrameCount() {
        this.frameCount ++;
    }

    @Override
    public GameField getRecentGameField() {
        return null;
    }

    @Override
    public double getPosX() {
        return this.position.getX();
    }

    @Override
    public double getPosY() {
        return this.position.getY();
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public void doUpdate(long tick) {
        this.incFrameCount();
        if (this.getFrameCount() >= this.getFrameGap()) {
            this.resetFrameCount();
            if (cnt < listEnemy.length && listEnemy[cnt] == 0) {
                cnt++;
                this.recentGameField.addEntity(enemyFactory.createSampleEnemy(position));
            }
        }
    }

    @Override
    public boolean isExist() {
        return cnt < listEnemy.length;
    }
}
