package org.csc133.a2.interfaces;

import org.csc133.a2.GameWorld;

public class Burning implements FireState{
    @Override
    public void nextFireState(FireContext fireContext) {
            fireContext.setFireState(new Extinguished());
    }
}
