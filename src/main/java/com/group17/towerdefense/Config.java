package com.group17.towerdefense;

public final class Config {
    public static final String GAME_NAME = "Tower Defense";

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH_RATIO = 20;
    public static final int SCREEN_HEIGHT_RATIO = 20;
    public static final int GAME_TPS = 20;
    public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);
    public static final int MAX_ENTITY = 300;
    public static final int SAMPLE_TOWER_DPS = 20;

    public static final double SAMPLE_ENEMY_ABS_VELOCITY = 1;
    public static final int SAMPLE_ENEMY_INIT_HEALTH = 25;
}
