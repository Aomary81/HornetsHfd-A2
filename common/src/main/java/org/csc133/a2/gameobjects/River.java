package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class River extends Fixed{

    private final int riverId;

    public River(Dimension worldSize) {
        riverId = getFixedObjId();
        this.worldSize = worldSize;
        this.color = ColorUtil.BLUE;
        this.location = new Point2D(0, worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight());
        System.err.println("NR: " + getRiverNorth() + " RS: " +getRiverSouth());

    }


    int getRiverNorth() {
        return (int)location.getY() - (worldSize.getHeight()/9 * 7);
    }

    int getRiverSouth() {
        return ((int)location.getY() - (worldSize.getHeight()/9 * 7)) +
                dimension.getHeight()/9 * 2;
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.clearRect(containerOrigin.getX(), containerOrigin.getY(),
                worldSize.getWidth(), worldSize.getHeight());
        g.setColor(color);
        g.drawRect(containerOrigin.getX() + (int)location.getX(),
                (containerOrigin.getY() + (int)location.getY() -
                        (worldSize.getHeight())/9 * 7),
                 dimension.getWidth(),
                      dimension.getHeight()/9 * 2);
    }
}