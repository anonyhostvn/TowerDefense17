package com.group17.towerdefense.gameobject.bullet;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.repositories.entity.DestroyableEntity;
import com.group17.towerdefense.repositories.entity.FireableSingleEntity;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.utility.Utility;

public class BigRocket extends AbstractBullet implements FireableSingleEntity {
    private GameEntity target;

    public BigRocket(Point position, GameEntity target) {
        this.width = Config.BIG_ROCKET_WIDTH;
        this.height = Config.BIG_ROCKET_HEIGHT;
        this.absVelocity = Config.BIG_ROCKET_ABS_VELOCITY;

        this.position = new Point(position);
        this.target = target;
        isExist = true;
    }

    @Override
    public GameEntity getTarget() {
        return this.target;
    }

    @Override
    public int getDamage() {
        return Config.BIG_ROCKET_DAMAGE;
    }

    @Override
    public void setVectorVelocity(DescartesVector descartesVector) {
        this.vectorVelocity = new DescartesVector(descartesVector);
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
        if (Utility.calculateDistance(this, this.target) <= 10) {
            DestroyableEntity destroyableTarget = (DestroyableEntity) this.target;
            destroyableTarget.beAttacked(this.getDamage());
            this.isExist = false;
        }
    }

    @Override
    public boolean isExist() {
        return isExist;
    }
}
