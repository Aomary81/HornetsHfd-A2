package org.csc133.a2.interfaces;

import org.csc133.a2.gameobjects.Fire;

public class UnStarted implements FireState{

    @Override
    public void nextState(Fire fire) {
        fire.setState(new Burning());
    }
}
