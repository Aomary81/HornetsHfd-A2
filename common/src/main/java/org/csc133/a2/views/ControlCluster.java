package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;
import org.csc133.a2.GameWorld;
import org.csc133.a2.commands.*;

public class ControlCluster extends Container {
    GameWorld gw;

    public ControlCluster(GameWorld gw) {
        this.gw =gw;
        TableLayout layout = new TableLayout(1,7);
        this.setLayout(layout);
        Button left = new Button("LEFT");
        left.setCommand(new TurnLeft(gw));
        Button right = new Button("RIGHT");
        right.setCommand(new TurnRight(gw));
        Button fight = new Button("FIGHT");
        fight.setCommand(new Fight(gw));
        Button exit = new Button("EXIT");
        exit.setCommand(new Exit(gw));
        Button drink = new Button("DRINK");
        drink.setCommand(new Drink(gw));
        Button brake = new Button("BRAKE");
        brake.setCommand(new Brake(gw));
        Button accel = new Button("ACCEL");
        accel.setCommand(new Accelerate(gw));
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.LEFT), left);
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.LEFT), right);
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.LEFT), fight);
        this.add(layout.createConstraint().widthPercentage(40).horizontalAlign(Component.CENTER), exit);
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.RIGHT), drink);
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.RIGHT), brake);
        this.add(layout.createConstraint().widthPercentage(10).horizontalAlign(Component.RIGHT), accel);
    }
}
