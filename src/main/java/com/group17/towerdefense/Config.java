package com.group17.towerdefense;

public final class Config {
    public static final String GAME_NAME = "Tower Defense";

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH_RATIO = 40;
    public static final int SCREEN_HEIGHT_RATIO = 40;
    public static final int GAME_TPS = 20;
    public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);
    public static final int MAX_ENTITY = 300;

    public static final int SAMPLE_TOWER_DPS = 20;
    public static final int SAMPLE_TOWER_RANGE = 100;
    public static final int SAMPLE_TOWER_FRAME_GAP = 200;
    public static final int SAMPLE_TOWER_PRICE = 40;

    //Add configuration for single-barrel tower
    public static final double SINGLE_BARREL_TOWER_DPS = 20;
    public static final double SINGLE_BARREL_TOWER_RANGE = 100;
    public static final double SINGLE_BARREL_TOWER_FRAME_GAP = 150;
    public static final int SINGLE_BARREL_TOWER_PRICE = 25;

    //Add configuration for single-rocket tower
    public static final double SINGLE_ROCKET_TOWER_DPS = 20;
    public static final double SINGLE_ROCKET_TOWER_RANGE = 200;
    public static final double SINGLE_ROCKET_TOWER_FRAME_GAP = 200;
    public static final int SINGLE_ROCKET_TOWER_PRICE = 75;

    public static final double SAMPLE_ENEMY_ABS_VELOCITY = 0.5;
    public static final int SAMPLE_ENEMY_INIT_HEALTH = 20;
    public static final int SAMPLE_ENEMY_WIDTH = 40;
    public static final int SAMPLE_ENEMY_HEIGHT = 40;
    public static final int SAMPLE_ENEMY_AWARD = 20;

    public static final double SAMPLE_BULLET_ABS_VELOCITY = 1;
    public static final int SAMPLE_BULLET_DAMAGE = 10;
    public static final double SAMPLE_BULLET_WIDTH = 40;
    public static final double SAMPLE_BULLET_HEIGHT = 40;

    //Add configuration for the single-barrel tower's bullet
    public static final double SINGLE_BARREL_BULLET_ABS_VELOCITY = 1;
    public static final int SINGLE_BARREL_BULLET_DAMAGE = 5;
    public static final double SINGLE_BARREL_BULLET_WIDTH = 40;
    public static final double SINGLE_BARREL_BULLET_HEIGHT = 40;

    //Add configuration for the big rocket
    public static final double BIG_ROCKET_ABS_VELOCITY = 5;
    public static final int BIG_ROCKET_DAMAGE = 5;
    public static final double BIG_ROCKET_WIDTH = 40;
    public static final double BIG_ROCKET_HEIGHT = 40;

    public static final int SAMPLE_SPAWNER_FRAME_GAP = 100;

    public static final int ICON_WIDTH = 50;
    public static final int ICON_HEIGHT = 50;

    public static final int GAME_STAGE_GUI_WIDTH = 200;
    public static final int GAME_STAGE_GUI_HEIGHT = 50;
}
