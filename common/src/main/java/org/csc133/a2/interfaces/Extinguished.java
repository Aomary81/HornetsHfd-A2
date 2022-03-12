package org.csc133.a2.interfaces;

public class Extinguished implements FireState{
    @Override
    public void nextFireState(FireContext fireContext) {
        fireContext.setFireState(new UnStarted());
    }
}
