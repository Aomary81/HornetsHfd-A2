package org.csc133.a2.commands;

import com.codename1.ui.Command;
import org.csc133.a2.GameWorld;

import com.codename1.ui.events.ActionEvent;

public class TurnLeft extends Command {
    private GameWorld gw;

    public TurnLeft(GameWorld gw) {
        super("TurnLeft");
        this.gw = gw;
    }
    @Override
    public void actionPerformed(ActionEvent event){
        gw.turnLeft();
    }

}
