package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class River extends GameObject{
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private int top, bottom, start, end;

    public River(Dimension worldSize) {
        this.worldSize = worldSize;
        this.color = ColorUtil.BLUE;
        this.location = new Point2D(0, worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight());
    }


    int getRiverNorth() {
        return top;
    }

    int getRiverSouth() {
        return top + bottom;
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