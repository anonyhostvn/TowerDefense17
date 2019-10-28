package com.group17.towerdefense.entity.movable.enemy;

import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public class SampleEnemy extends AbstractEnemy {

    private SampleEnemy(){};

    public SampleEnemy (double absVelocity, DescartesVector vectorVelocity, Point position, double width, double height) {
        System.out.println(position.getX() + " " + position.getY());
        this.absVelocity = absVelocity;
        this.vectorVelocity = new DescartesVector(vectorVelocity);
        this.position = new Point(position);
        this.width = width;
        this.height = height;
    }

    @Override
    public void doUpdate() {
        this.position = new Point(position.getX() + vectorVelocity.getX(), position.getY() + vectorVelocity.getY());
    }

}
