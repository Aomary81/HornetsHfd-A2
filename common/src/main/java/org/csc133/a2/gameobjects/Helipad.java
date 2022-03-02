package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Helipad {
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private Point locationCenter;
    private int squareSize, circleSize;

    public Helipad() {
        squareSize = 200;
        circleSize = 150;
        locationCenter = new Point(DISP_W / 2, DISP_H - squareSize -
                squareSize / 2);
    }

    // Get Helipads X and Y coordinates
    public int getHelipadX() {
        return locationCenter.getX() - squareSize / 2;
    }

    public int getHelipadY() {
        return locationCenter.getY() - squareSize / 2;
    }

    public int getHelipadSize() {
        return squareSize;
    }

    public void draw(Graphics g) {
        g.setColor(ColorUtil.GRAY);
        g.drawArc(locationCenter.getX() - circleSize / 2,
                locationCenter.getY() - circleSize / 2,
                circleSize, circleSize, 0, 360);
        g.drawRect(locationCenter.getX() - squareSize / 2,
                locationCenter.getY() - squareSize / 2,
                squareSize, squareSize, 5);
    }
}
