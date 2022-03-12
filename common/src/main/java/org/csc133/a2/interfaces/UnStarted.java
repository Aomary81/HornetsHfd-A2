package org.csc133.a2.interfaces;

import org.csc133.a2.GameWorld;

public class UnStarted implements FireState {
    @Override
    public void nextFireState(FireContext fireContext) {
        if (GameWorld.getFireSize() < 1000) {
            fireContext.setFireState(new Burning());
        }
    }
}
