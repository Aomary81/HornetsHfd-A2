package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;
import org.csc133.a2.commands.*;

public class ControlCluster extends Container {
    GameWorld gw;

    public ControlCluster(GameWorld gw) {
        this.gw =gw;
        this.setLayout(new GridLayout(1, 7));
        Button left = new Button("LEFT");
        left.setCommand(new TurnLeft(gw));
        this.add(left);
        Button right = new Button("RIGHT");
        right.setCommand(new TurnRight(gw));
        this.add(right);
        Button fight = new Button("FIGHT");
        fight.setCommand(new Fight(gw));
        this.add(fight);
        Button exit = new Button("EXIT");
        exit.setCommand(new Exit(gw));
        this.add(exit);
        Button drink = new Button("DRINK");
        drink.setCommand(new Drink(gw));
        this.add(drink);
        Button brake = new Button("BRAKE");
        brake.setCommand(new Brake(gw));
        this.add(brake);
        Button accel = new Button("ACCEL");
        accel.setCommand(new Accelerate(gw));
        this.add(accel);
    }
}
