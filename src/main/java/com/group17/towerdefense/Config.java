package com.group17.towerdefense;

public final class Config {
    public static final String GAME_NAME = "Tower Defense";

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH_RATIO = 40;
    public static final int SCREEN_HEIGHT_RATIO = 40;
    public static final int GAME_TPS = 20;
    public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);

    public static final int SAMPLE_TOWER_DPS = 20;
    public static final int SAMPLE_TOWER_RANGE = 100;
    public static final int SAMPLE_TOWER_FRAME_GAP = 200;
    public static final int SAMPLE_TOWER_PRICE = 40;

    // SUPPLEMENT ENEMY
    public static final double SAMPLE_ENEMY_ABS_VELOCITY = 0.7;
    public static final int SAMPLE_ENEMY_INIT_HEALTH = 20;
    public static final int SAMPLE_ENEMY_WIDTH = 40;
    public static final int SAMPLE_ENEMY_HEIGHT = 40;
    public static final int SAMPLE_ENEMY_AWARD = 20;

    public static final double TANKER_ENEMY_ABS_VELOCITY = 0.5;
    public static final int TANKER_ENEMY_INIT_HEALTH = 60;
    public static final int TANKER_ENEMY_WIDTH = 45;
    public static final int TANKER_ENEMY_HEIGHT = 45;
    public static final int TANKER_ENEMY_AWARD = 40;

    public static final double BOSS_ENEMY_ABS_VELOCITY = 0.4;
    public static final int BOSS_ENEMY_INIT_HEALTH = 150;
    public static final int BOSS_ENEMY_WIDTH = 40;
    public static final int BOSS_ENEMY_HEIGHT = 40;
    public static final int BOSS_ENEMY_AWARD = 150;

    public static final double PLANE_ENEMY_ABS_VELOCITY = 0.7;
    public static final int PLANE_ENEMY_INIT_HEALTH = 50;
    public static final int PLANE_ENEMY_WIDTH = 40;
    public static final int PLANE_ENEMY_HEIGHT = 40;
    public static final int PLANE_ENEMY_AWARD = 50;

    // BULLET
    public static final double SAMPLE_BULLET_ABS_VELOCITY = 1;
    public static final int SAMPLE_BULLET_DAMAGE = 10;
    public static final double SAMPLE_BULLET_WIDTH = 40;
    public static final double SAMPLE_BULLET_HEIGHT = 40;

    public static final int SAMPLE_SPAWNER_FRAME_GAP = 100;

    public static final int ICON_WIDTH = 50;
    public static final int ICON_HEIGHT = 50;
}
