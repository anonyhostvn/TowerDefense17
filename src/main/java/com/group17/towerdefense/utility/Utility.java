package com.group17.towerdefense.utility;

import com.group17.towerdefense.Config;
import com.group17.towerdefense.mesurement.DescartesVector;
import com.group17.towerdefense.mesurement.Point;
import com.group17.towerdefense.mesurement.PolarVector;
import com.group17.towerdefense.mesurement.TurningPoint;
import com.group17.towerdefense.repositories.entity.GameEntity;
import com.group17.towerdefense.repositories.entity.MovableEntity;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Utility {
    public static Point fromScreenPointToFieldPoint(Point screenPoint) {
        return new Point((int) screenPoint.getX() / Config.SCREEN_WIDTH_RATIO, (int) screenPoint.getY() / Config.SCREEN_HEIGHT_RATIO);
    }

    public static Point fromFieldPointToScreenPoint(Point fieldPoint) {
        return new Point(fieldPoint.getX() * Config.SCREEN_WIDTH_RATIO , fieldPoint.getY() * Config.SCREEN_HEIGHT_RATIO);
    }

    public static double calculateDistance(GameEntity o1, GameEntity o2) {
        double disX = o1.getPosX() - o2.getPosX(), disY = o1.getPosY() - o2.getPosY();
        return Math.sqrt(disX * disX + disY * disY);
    }

    public static Point getTopLeftPositionOfBlock(Point position) {
        return fromFieldPointToScreenPoint(fromScreenPointToFieldPoint(position));
    }

    public static Image rotateImage(Image img, double angle) {
        ImageView imgView = new ImageView(img);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        params.setTransform(new Rotate(angle, img.getHeight() / 2, img.getWidth() / 2));
        params.setViewport(new Rectangle2D(0, 0, img.getHeight(), img.getWidth()));
        return imgView.snapshot(params, null);
    }

    public static void modifyVectorVelocity(TurningPoint[] listCheckPoint, Point recentPoint, MovableEntity target) {
        Point fieldPoint = fromScreenPointToFieldPoint(new Point(target.getPosX(), target.getPosY()));
        Point centerPoint = new Point (
                fieldPoint.getX() * Config.SCREEN_WIDTH_RATIO + Config.SCREEN_WIDTH_RATIO / 2,
                fieldPoint.getY() * Config.SCREEN_HEIGHT_RATIO + Config.SCREEN_HEIGHT_RATIO / 2
        );


        for (TurningPoint turningPoint: listCheckPoint) {
            if (fieldPoint.lengthTo(turningPoint.getPoint()) <= 1){
                PolarVector temp = new PolarVector(target.getAbsVelocity(),Math.toRadians(turningPoint.getAngle()));
                target.setVectorVelocity(new DescartesVector(temp));
            }
        }
    }
}
