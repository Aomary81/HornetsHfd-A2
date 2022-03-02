package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.ArrayList;

import static com.codename1.ui.CN.*;

public class Helicopter {
    private final static int DISP_W = Display.getInstance().getDisplayWidth();
    private final static int DISP_H = Display.getInstance().getDisplayHeight();
    private Point locationHeli, locationTail, center, turning, forwardPoints;
    private int heliSize, tailSize, currentIndex, rXs, rYs;
    private int fuel, rX, rY, speed, x2, y2, water;
    private ArrayList<Point> turn, forward;

    public Helicopter() {
        heliSize = 50;
        tailSize = 100;
        locationHeli = new Point(DISP_W / 2,
                DISP_H - 300);
        locationTail = new Point(locationHeli.getX(), locationHeli.getY());
        center = new Point(DISP_W / 2, DISP_H - 300);
        turn = new ArrayList<>();
        currentIndex = 0;
        fuel = 25000;
        for (int i = 1; i < 25; i++) {
            double angle = Math.toRadians(360 / 24 * i - 105);
            rX = (int) ((tailSize * Math.cos(angle)));
            rY = (int) ((tailSize * Math.sin(angle)));
            turning = new Point(rX, rY);
            turn.add(turning);
        }
    }

    // Changes the direction the helicopter is pointing
    public void move() {
        forward = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            double angle = Math.toRadians(360 / 24 * i - 105);
            rXs = (int) (Math.cos(angle) * speed);
            rYs = (int) (Math.sin(angle) * speed);
            forwardPoints = new Point(rXs, rYs);
            forward.add(forwardPoints);
        }
        center.setX(center.getX() + (forward.get(currentIndex).getX()));
        center.setY(center.getY() + (forward.get(currentIndex).getY()));

    }

    // Uses the turn ArrayList to change direction
    public void turningR() {
        currentIndex++;
        if (currentIndex > turn.size() - 1) {
            currentIndex = 0;
        }
    }

    // Uses the turn ArrayList to change direction
    public void turningL() {
        if (currentIndex == 0) {
            currentIndex = turn.size() - 1;
        }
        currentIndex--;
    }

    // changes the speed of the helicopter
    public void accelerate() {
        if (speed >= 0 && speed < 10) {
            speed++;
        } else {
            speed = 10;
        }
    }

    // changes the speed of the helicopter
    public void decelerate() {
        if (speed > 0) {
            speed--;
        } else {
            speed = 0;
        }
    }

    // Changes the fuel level
    public int fuelConsumption() {
        fuel = fuel - ((speed * speed) + 5);

        if (fuel <= 0) {
            fuel = 0;
        }
        return fuel;
    }

    // Command method to pick up Water
    public void drinkWater() {
        if (speed < 3) {
            water = water + 100;
        }
        if (water >= 1000) {
            water = 1000;
        }
    }

    // Checks to see if center of helicopter is over the river
    public boolean overRiver(River r) {
        if ((r.getRiverNorth() + heliSize / 2 < center.getY()) &&
                (r.getRiverSouth() - heliSize / 2 > center.getY())) {
            return true;
        } else {
            return false;
        }
    }

    // Check is helicopter is over the fire
    public boolean overFire(Fire f) {
        if ((f.getFireX() < center.getX()) &&
                ((f.getFireX() + f.getFireSize()) > center.getX()) &&
                (f.getFireY() < center.getY()) &&
                (((f.getFireY() + f.getFireSize()) > center.getY()))) {
            return true;
        } else {
            return false;
        }
    }

    // Check to see if Helicopter is over the Helipad
    public boolean isOverHelipad(Helipad pad) {
        return (pad.getHelipadX() < center.getX()) &&
                ((pad.getHelipadX() + pad.getHelipadSize()) > center.getX()) &&
                (pad.getHelipadY() < center.getY()) &&
                ((pad.getHelipadY() + pad.getHelipadSize()) > center.getY()) &&
                (speed == 0);
    }

    // Current Water Level
    public int getWaterLevel() {
        return water;
    }

    // Drops all water of fire
    public void fightFire() {
        water = 0;
    }

    public void draw(Graphics g) {
        g.setColor(ColorUtil.rgb(255, 255, 0));
        g.fillArc(center.getX() - heliSize / 2,
                center.getY() - heliSize / 2,
                heliSize, heliSize, 0, 360);
        x2 = turn.get(currentIndex).getX() + center.getX();
        y2 = turn.get(currentIndex).getY() + center.getY();
        g.drawLine(center.getX(), center.getY(), x2, y2);
        g.setColor(ColorUtil.WHITE);
        g.setFont(Font.createSystemFont(FACE_MONOSPACE, STYLE_BOLD,
                SIZE_MEDIUM));
        g.drawString("f: " + fuel, center.getX() + heliSize,
                center.getY() + heliSize);
        g.drawString("w: " + water, center.getX() + heliSize,
                center.getY() + 20 + heliSize);
    }
}
