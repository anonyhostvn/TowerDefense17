package com.group17.towerdefense.gameobject.movable.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public class SampleEnemy extends AbstractGroundEnemy {

    public SampleEnemy (double absVelocity, DescartesVector vectorVelocity, Point position, double width, double height) {
        this.absVelocity = absVelocity;
        this.width = width;
        this.height = height;
        this.position = new Point(position);
        this.vectorVelocity = vectorVelocity;
        this.health = Config.SAMPLE_ENEMY_INIT_HEALTH;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void doUpdate(long tick) {
        this.doMove();
    }

    @Override
    public boolean isExist() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void beAttacked(int damage) {
        this.health -= damage;
    }

    @Override
    public DescartesVector getVectorVelocity() {
        return this.vectorVelocity;
    }

    @Override
    public void doMove() {
        
        this.position = new Point(getPosX() + getVectorVelocity().getX(), getPosY() + getVectorVelocity().getY());
    }
}
