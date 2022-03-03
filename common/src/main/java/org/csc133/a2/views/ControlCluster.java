package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class ControlCluster extends Container {
    GameWorld gw;
    Button left, right, fight, exit, drink, brake, accel;
    public ControlCluster(GameWorld gw) {
        this.gw =gw;
        this.setLayout(new GridLayout(1, 7));
        this.add("LEFT");
        this.add("RIGHT");
        this.add("FIGHT");
        this.add("EXIT");
        this.add("DRINK");
        this.add("BRAKE");
        this.add("ACCEL");

        left = new Button();
        right = new Button();
        fight = new Button();
        exit = new Button();
        drink = new Button();
        brake = new Button();
        accel = new Button();
    }
}
