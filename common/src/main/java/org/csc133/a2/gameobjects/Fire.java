package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.Random;

import static com.codename1.ui.CN.*;

public class Fire {
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private Point location;
    private int fireSize;
    private Random r;

    public Fire() {
        r = new Random();
        fireSize = r.nextInt(200);
        location = new Point(DISP_W / 4 + r.nextInt(DISP_W / 4),
                r.nextInt(DISP_H) / 4);
    }

    // Increase and decrease fire's size
    public void grow() {
        fireSize = fireSize + r.nextInt(5);
    }

    public int shrink(int water) {
        fireSize = fireSize - (water / 2);
        return fireSize;
    }

    // Gets the Point coordinate for Fires X and Y and the fire's size
    int getFireX() {
        return location.getX() - fireSize / 4;
    }

    int getFireY() {
        return location.getY() - fireSize / 4;
    }

    public int getFireSize() {
        return fireSize;
    }

    public void setLocationX(int locX) {
        location.setX(locX);
    }

    public void setLocationY(int locY) {
        location.setY(locY);
    }

    public void draw(Graphics g) {
        g.setColor(ColorUtil.rgb(255, 0, 0));
        g.fillArc(location.getX() - fireSize / 4,
                location.getY() - fireSize / 4,
                fireSize / 2, fireSize / 2,
                0, 360);
        g.setColor(ColorUtil.WHITE);
        g.setFont(Font.createSystemFont(FACE_MONOSPACE, STYLE_BOLD,
                SIZE_MEDIUM));
        g.drawString("" + fireSize, location.getX() + (fireSize / 4),
                location.getY() + (fireSize / 4));
    }
}
