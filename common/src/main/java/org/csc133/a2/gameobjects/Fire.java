package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import org.csc133.a2.interfaces.FireState;
import org.csc133.a2.interfaces.UnStarted;

import java.util.Random;

import static com.codename1.ui.CN.*;

public class Fire extends Fixed {
    private int fireSize, fireId;
    private Random r;
    private FireState state;

    public Fire(Dimension worldSize) {
        this.state = new UnStarted();
        r = new Random();
        fireSize = 3 + r.nextInt(4);
        this.worldSize = worldSize;
        this.color = ColorUtil.MAGENTA;
        this.location = new Point2D(0,0);
        this.dimension = new Dimension(fireSize, fireSize);

    }

    public void grow() {
        fireSize = fireSize + 1;
    }

    public int shrink(int water) {
        fireSize = fireSize - (water / 2);
        return fireSize;
    }

    public double areaOfFire() {
        return Math.PI * fireSize / 2 * fireSize / 2;
    }

    int getFireX() {
        return (int) location.getX();
    }

    int getFireY() {
        return (int) location.getY();
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

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.fillArc(containerOrigin.getX() + (int) location.getX(),
                containerOrigin.getY() + (int) location.getY(),
                fireSize, fireSize, 0, 360);
        g.setFont(Font.createSystemFont(FACE_MONOSPACE, STYLE_BOLD,
                SIZE_MEDIUM));
        g.drawString("" + fireSize,
                containerOrigin.getX() + (int) location.getX()
                        + (fireSize/4 * 3),
                containerOrigin.getY() + (int) location.getY()
                        + (fireSize/4 * 3));
    }
    public void setState(FireState state){
        this.state = state;
    }

    public void getState(){
        this.state.nextState(this);
    }
}