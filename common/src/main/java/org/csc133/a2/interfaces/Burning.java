package org.csc133.a2.interfaces;

import org.csc133.a2.gameobjects.Fire;

public class Burning implements FireState{
    @Override
    public void nextFireState(Fire fireContext) {
        fireContext.setFireState(new Extinguished());
    }
}
