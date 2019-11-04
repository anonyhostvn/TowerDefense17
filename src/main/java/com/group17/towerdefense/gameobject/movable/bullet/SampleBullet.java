package com.group17.towerdefense.gameobject.movable.bullet;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.DestroyableEntity;
import com.group17.towerdefense.repositories.entity.FireableSingleEntity;
import com.group17.towerdefense.repositories.entity.GameEntity;

public class SampleBullet extends AbstractBullet implements FireableSingleEntity {
    private GameEntity target;

    public SampleBullet(Point position, GameEntity target) {
        this.width = Config.SAMPLE_BULLET_WIDTH;
        this.height = Config.SAMPLE_BULLET_HEIGHT;
        this.absVelocity = Config.SAMPLE_BULLET_ABS_VELOCITY;

        this.position = new Point(position);
        this.target = target;
        isExist = true;
    }

    @Override
    public GameEntity getTarget() {
        return this.target;
    }

    @Override
    public double getDamage() {
        return Config.SAMPLE_BULLET_DAMAGE;
    }

    @Override
    public void doMove() {
        PolarVector directionVector = new PolarVector(this.position , new Point(target.getPosX(), target.getPosY()));
        this.directionVector = directionVector;
        PolarVector polarVelocityVector = new PolarVector(this.getAbsVelocity(), directionVector.getFi());
        DescartesVector descartesVector = new DescartesVector(polarVelocityVector);
        this.vectorVelocity = descartesVector;
        this.position = new Point(this.getPosX() + descartesVector.getX() , this.getPosY() + descartesVector.getY());
    }

    @Override
    public double getAngle() {
        if (getDirectionVector() == null) return 0;
        return Math.toDegrees(getDirectionVector().getFi()) + 90;
    }

    @Override
    public void doUpdate(long tick) {
        doMove();
    }

    @Override
    public boolean isExist() {
        return isExist;
    }

    @Override
    public int getHealth() {
        return 1;
    }
}
