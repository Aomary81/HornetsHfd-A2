package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import java.util.Random;

import static com.codename1.ui.CN.*;

public class Fire extends GameObject{
    private int fireSize;
    private Random r;

    public Fire(Dimension worldSize) {
        r = new Random();
        fireSize = r.nextInt(200) + 200;
        this.worldSize = worldSize;
        this.color = ColorUtil.MAGENTA;
        this.location = new Point2D(500,
                500);
        this.dimension = new Dimension(fireSize, fireSize);

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
        return (int)location.getX() - fireSize / 4;
    }

    int getFireY() {
        return (int)location.getY() - fireSize / 4;
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

/*    public void draw(Graphics g) {
        g.setColor(ColorUtil.MAGENTA);
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
*/
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.fillArc(containerOrigin.getX() + (int)location.getX() - fireSize/4,
                containerOrigin.getY() + (int)location.getY() - fireSize/4,
                fireSize, fireSize, 0, 360);
        //draw(g);
    }
}
