package org.csc133.a2.interfaces;

public class FireContext {
    FireState fireState;

    public FireContext(){
        this.fireState = new UnStarted();
    }

    public void setFireState(FireState fireState){
        this.fireState = fireState;
    }
    public void nextFireState(){
        this.fireState.nextFireState(this);
    }
}
