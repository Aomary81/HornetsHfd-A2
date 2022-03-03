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
/*        location = new Point(DISP_W / 2,
                DISP_H * 5 / 12);
        start = location.getX() - location.getX();
        end = location.getX() + location.getX();
        top = location.getY() * 4 / 5;
        bottom = location.getY() * 2 / 5;
*/    }

    // Returns the Top and Bottom shoreline of River
    int getRiverNorth() {
        return top;
    }

    int getRiverSouth() {
        return top + bottom;
    }
/*
    public void draw(Graphics g) {
        g.setColor(ColorUtil.BLUE);
        g.drawRect(start, top, end, bottom);
    }
*/
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.fillRect(containerOrigin.getX(),// + (int)location.getX(),
                containerOrigin.getY(),
                //+ (int)location.getY() - worldSize.getHeight(),
                dimension.getWidth(), dimension.getHeight());

    }
}
