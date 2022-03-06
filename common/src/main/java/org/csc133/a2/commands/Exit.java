package org.csc133.a2.commands;

import com.codename1.ui.Command;
import org.csc133.a2.GameWorld;

import com.codename1.ui.events.ActionEvent;


public class Exit extends Command {
    private GameWorld gw;

    public Exit(GameWorld gw) {
        super("Exit");
        this.gw = gw;
    }
    @Override
    public void actionPerformed(ActionEvent event){
        gw.quit();
    }
}
