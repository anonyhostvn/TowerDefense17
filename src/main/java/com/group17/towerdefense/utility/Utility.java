package com.group17.towerdefense.utility;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.Point;

public class Utility {
    public static Point fromScreenPointToFieldPoint(Point screenPoint) {
        return new Point(screenPoint.getX() / Config.SCREEN_WIDTH_RATIO, screenPoint.getY() / Config.SCREEN_HEIGHT_RATIO);
    }

    public static Point fromFieldPointToScreenPoint(Point fieldPoint) {
        System.out.println(fieldPoint.getX() + " " + fieldPoint.getY());
        return new Point(fieldPoint.getX() * Config.SCREEN_WIDTH_RATIO , fieldPoint.getY() * Config.SCREEN_HEIGHT_RATIO);
    }
}
