package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Building extends GameObject{
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private int width1, height1, width2, height2, width3, height3;
    private Point build1, build2, build3;

    public Building(){
        build1 = new Point(DISP_W/2, DISP_H /10 *2);
        build2 = new Point(DISP_W/8, DISP_H/10 * 7);
        build3 = new Point(DISP_W/8 * 6, DISP_H/10 * 7);
        width1 = DISP_W/2;
        height1 = DISP_H/10;
        width2 = DISP_W/8;
        height2 = DISP_H/10 *2;
        width3 = DISP_W/10;
        height3 = DISP_H/10 * 3;
    }

    public void draw(Graphics g){
        g.setColor(ColorUtil.rgb(255, 0,0));
        g.drawRect(build1.getX() - width1/2, build1.getY() - height1/2,
                width1, height1);
        g.drawRect(build2.getX() - width2/2, build2.getY() - height2/2,
                width2, height2);
        g.drawRect(build3.getX() - width3/2, build3.getY() - height3/2,
                width3, height3);
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        draw(g);
    }
}
