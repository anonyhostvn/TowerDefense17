package com.group17.towerdefense.abstractfactory;

import com.group17.towerdefense.gamemanager.GameField;
import com.group17.towerdefense.gameobject.bullet.*;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.repositories.entity.GameEntity;
import javafx.scene.media.AudioClip;

public class BulletFactory extends AbstractEntityFactory {
    public BulletFactory(GameField gameField) {
        super(gameField);
    }
    final static AudioClip soundFireBulletOne = new AudioClip(BulletOne.class.getResource("/sound/gun.mp3").toString());
    final static AudioClip soundFireBulletTwo = new AudioClip(BulletOne.class.getResource("/sound/gunD.mp3").toString());
    final static AudioClip soundFireRocket = new AudioClip(BulletOne.class.getResource("/sound/rocket.mp3").toString());

    public BulletOne createBulletOneFactory(Point position, GameEntity target) {
        if (!this.recentGameField.getIsMuteSoundEffect()) soundFireBulletOne.play();

        return new BulletOne(position, target);
    }

    public BulletTwo createBulletTwoFactory(Point position, GameEntity target) {
        if (!this.recentGameField.getIsMuteSoundEffect()) soundFireBulletTwo.play();

        return new BulletTwo(position, target);
    }

    public Rocket createRocketFactory(Point position, GameEntity target) {
        if (!this.recentGameField.getIsMuteSoundEffect()) soundFireRocket.play();

        return new Rocket(position, target);
    }

    public BigRocket createBigRocketFactory(Point position, GameEntity target) {
        if (!this.recentGameField.getIsMuteSoundEffect()) soundFireRocket.play();

        return new BigRocket(position, target);
    }

    public SampleBullet createSampleBulletFactory(Point position, GameEntity target) {
        return new SampleBullet(position, target);
    }
}
