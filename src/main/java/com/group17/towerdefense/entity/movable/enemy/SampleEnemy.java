package com.group17.towerdefense.entity.movable.enemy;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;

public class SampleEnemy extends AbstractEnemy {

    private SampleEnemy(){
        super(0,0,0,null, null, 0);
    };

    public SampleEnemy (double absVelocity, DescartesVector vectorVelocity, Point position, double width, double height) {
        super(absVelocity, width, height, position, vectorVelocity, Config.SAMPLE_ENEMY_INIT_HEALTH);
    }

    @Override
    public void doUpdate(long tick) {
        this.position = new Point(position.getX() + vectorVelocity.getX(), position.getY() + vectorVelocity.getY());
    }

    @Override
    public boolean isExist() {
        return health > 0;
    }

}
