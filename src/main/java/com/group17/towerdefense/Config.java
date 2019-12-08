package com.group17.towerdefense;

import com.group17.towerdefense.gameobject.bullet.*;
import com.group17.towerdefense.gameobject.enemy.*;
import com.group17.towerdefense.gameobject.ground.*;
import com.group17.towerdefense.gameobject.spawner.SampleSpawner;
import com.group17.towerdefense.gameobject.tower.*;
import com.group17.towerdefense.repositories.entity.GameEntity;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public final class Config {
    public static final String GAME_NAME = "Tower Defense";

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH_RATIO = 40;
    public static final int SCREEN_HEIGHT_RATIO = 40;
    public static final int GAME_TPS = 20;
    public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);

    // SAMPLE TOWER
    public static final int SAMPLE_TOWER_DPS = 20;
    public static final int SAMPLE_TOWER_RANGE = 100;
    public static final int SAMPLE_TOWER_FRAME_GAP = 200;
    public static final int SAMPLE_TOWER_PRICE = 40;
    public static final int SAMPLE_TOWER_SELL_PRICE = 20;

    // SINGLE-BARREL TOWER
    public static final int SINGLE_BARREL_TOWER_DPS = 20;
    public static final int SINGLE_BARREL_TOWER_RANGE = 100;
    public static final int SINGLE_BARREL_TOWER_FRAME_GAP = 100;
    public static final int SINGLE_BARREL_TOWER_PRICE = 30;
    public static final int SINGLE_BARREL_TOWER_SELL_PRICE = 10;

    // DOUBLE-BARREL TOWER
    public static final int DOUBLE_BARREL_TOWER_DPS = 20;
    public static final int DOUBLE_BARREL_TOWER_RANGE = 150;
    public static final int DOUBLE_BARREL_TOWER_FRAME_GAP = 100;
    public static final int DOUBLE_BARREL_TOWER_PRICE = 50;
    public static final int DOUBLE_BARREL_TOWER_SELL_PRICE = 30;

    // SINGLE-ROCKET TOWER
    public static final int SINGLE_ROCKET_TOWER_DPS = 20;
    public static final int SINGLE_ROCKET_TOWER_RANGE = 250;
    public static final int SINGLE_ROCKET_TOWER_FRAME_GAP = 300;
    public static final int SINGLE_ROCKET_TOWER_PRICE = 120;
    public static final int SINGLE_ROCKET_TOWER_SELL_PRICE = 50;

    // DOUBLE-ROCKET TOWER
    public static final int DOUBLE_ROCKET_TOWER_DPS = 20;
    public static final int DOUBLE_ROCKET_TOWER_RANGE = 200;
    public static final int DOUBLE_ROCKET_TOWER_FRAME_GAP = 200;
    public static final int DOUBLE_ROCKET_TOWER_PRICE = 80;
    public static final int DOUBLE_ROCKET_TOWER_SELL_PRICE = 30;

    // SUPPLEMENT ENEMY
    public static final double SAMPLE_ENEMY_ABS_VELOCITY = 0.7;
    public static final int SAMPLE_ENEMY_INIT_HEALTH = 20;
    public static final int SAMPLE_ENEMY_WIDTH = 40;
    public static final int SAMPLE_ENEMY_HEIGHT = 40;
    public static final int SAMPLE_ENEMY_AWARD = 20;

    // TANKER ENEMY
    public static final double TANKER_ENEMY_ABS_VELOCITY = 0.5;
    public static final int TANKER_ENEMY_INIT_HEALTH = 60;
    public static final int TANKER_ENEMY_WIDTH = 45;
    public static final int TANKER_ENEMY_HEIGHT = 45;
    public static final int TANKER_ENEMY_AWARD = 40;

    // BOSS ENEMY
    public static final double BOSS_ENEMY_ABS_VELOCITY = 0.4;
    public static final int BOSS_ENEMY_INIT_HEALTH = 150;
    public static final int BOSS_ENEMY_WIDTH = 40;
    public static final int BOSS_ENEMY_HEIGHT = 40;
    public static final int BOSS_ENEMY_AWARD = 150;

    // PLANE ENEMY
    public static final double PLANE_ENEMY_ABS_VELOCITY = 0.7;
    public static final int PLANE_ENEMY_INIT_HEALTH = 50;
    public static final int PLANE_ENEMY_WIDTH = 40;
    public static final int PLANE_ENEMY_HEIGHT = 40;
    public static final int PLANE_ENEMY_AWARD = 50;

    //JETPLANE ENEMY
    public static final double JET_PLANE_ENEMY_ABS_VELOCITY = 1;
    public static final int JET_PLANE_ENEMY_INIT_HEALTH = 20;
    public static final int JET_PLANE_ENEMY_WIDTH = 40;
    public static final int JET_PLANE_ENEMY_HEIGHT = 40;
    public static final int JET_PLANE_ENEMY_AWARD = 50;

    // SAMPLE BULLET
    public static final double SAMPLE_BULLET_ABS_VELOCITY = 1;
    public static final int SAMPLE_BULLET_DAMAGE = 10;
    public static final double SAMPLE_BULLET_WIDTH = 40;
    public static final double SAMPLE_BULLET_HEIGHT = 40;

    // BULLET_1
    public static final double BULLET_1_ABS_VELOCITY = 3;
    public static final int BULLET_1_DAMAGE = 5;
    public static final double BULLET_1_WIDTH = 40;
    public static final double BULLET_1_HEIGHT = 40;

    // BULLET_2
    public static final double BULLET_2_ABS_VELOCITY = 3;
    public static final int BULLET_2_DAMAGE = 10;
    public static final double BULLET_2_WIDTH = 40;
    public static final double BULLET_2_HEIGHT = 40;

    // ROCKET
    public static final double ROCKET_ABS_VELOCITY = 2;
    public static final int ROCKET_DAMAGE = 15;
    public static final double ROCKET_WIDTH = 40;
    public static final double ROCKET_HEIGHT = 40;

    // BIG_ROCKET
    public static final double BIG_ROCKET_ABS_VELOCITY = 2;
    public static final int BIG_ROCKET_DAMAGE = 20;
    public static final double BIG_ROCKET_WIDTH = 40;
    public static final double BIG_ROCKET_HEIGHT = 40;

    public static final int SAMPLE_SPAWNER_FRAME_GAP = 100;

    public static final int ICON_WIDTH = 50;
    public static final int ICON_HEIGHT = 50;

    public static final Map<Class<? extends GameEntity>, Integer> entityOrder = new HashMap<Class<? extends GameEntity>, Integer>(Map.ofEntries(
            Map.entry(Mountain.class, 1),
            Map.entry(Road.class, 2),
            Map.entry(RockOnes.class, 2),
            Map.entry(RockTwo.class, 2),
            Map.entry(BushOne.class, 2),

            Map.entry(SampleEnemy.class, 3),
            Map.entry(SampleTower.class, 4),
            Map.entry(SampleSpawner.class, 5),
            Map.entry(SampleBullet.class, 6),

            Map.entry(SBarrelTower.class, 7),
            Map.entry(DBarrelTower.class, 8),
            Map.entry(SRocketTower.class, 9),
            Map.entry(DRocketTower.class, 10),

            Map.entry(TankerEnemy.class, 11),
            Map.entry(BossEnemy.class, 12),
            Map.entry(PlaneEnemy.class, 13),
            Map.entry(JetPlaneEnemy.class, 14),

            Map.entry(Bullet_1.class, 15),
            Map.entry(Bullet_2.class, 16),
            Map.entry(Rocket.class, 17),
            Map.entry(BigRocket.class, 18)
    ));

    public static final Map<String, String> mapNameConst = new HashMap<String, String>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("HANOI", "Hà Nội"),
            new AbstractMap.SimpleEntry<String, String>("HCM", "TP.HCM"),
            new AbstractMap.SimpleEntry<String, String>("HP", "Hải Phòng")
    ));

    public static final int entityOrderComparator(GameEntity A , GameEntity B) {
        return Integer.compare(entityOrder.get(A.getClass()), entityOrder.get(B.getClass()));
    }
}
