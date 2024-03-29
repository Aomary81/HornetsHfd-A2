package org.csc133.a2.views;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class GlassCockpit extends Container {
    GameWorld gw;
    Label heading, speed, fuel, fires, fireSize, damage, loss;

    public GlassCockpit(GameWorld gw) {
        this.gw =gw;
        this.setLayout(new GridLayout(2, 7));
        this.add("HEADING");
        this.add("SPEED");
        this.add("FUEL");
        this.add("FIRES");
        this.add("FIRE SIZE");
        this.add("DAMAGE");
        this.add("LOSS");

        heading = new Label("0");
        speed = new Label("0");
        fuel = new Label("0");
        fires = new Label("0");
        fireSize = new Label("0");
        damage = new Label("0");
        loss = new Label("0");

        this.add(heading);
        this.add(speed);
        this.add(fuel);
        this.add(fires);
        this.add(fireSize);
        this.add(damage);
        this.add(loss);
    }

    public void update(){
        heading.setText(gw.getHeading());
        speed.setText(gw.getSpeed());
        fuel.setText(gw.getFuel());
        fires.setText(gw.getFires());
        fireSize.setText(gw.getFireSize());
        damage.setText(gw.getDamage());
        loss.setText(gw.getLoss());
    }
}
