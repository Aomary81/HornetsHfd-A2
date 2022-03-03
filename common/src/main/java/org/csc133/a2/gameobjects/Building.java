package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Building extends GameObject{
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private int width, height;
    private Point build1, build2, build3;

    public Building(){
        build1 = new Point(DISP_W/2, DISP_H /10 *2);
        build2 = new Point(DISP_W/8, DISP_H/10 * 6);
        build3 = new Point(DISP_W/8 * 7, DISP_H/10 * 6);
        width = DISP_W/2;
        height = DISP_H/10;


    }

    public void draw(Graphics g){
        g.setColor(ColorUtil.rgb(255, 0,0));
        g.drawRect(build1.getX() - width/2, build1.getY() - height/2,
                width, height);
        g.drawRect(build2.getX() - width/2, build2.getY() - height/2,
                height, width);
        g.drawRect(build3.getX() - width/2, build3.getY() - height/2,
                height, width);
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        draw(g);
    }
}
