package org.csc133.a2.gameobjects;

public abstract class Fixed extends GameObject{
    private static int fixedObjId; //id of fixed obj
    //cannot be changed once it has been created

    public int getFixedObjId()
    {
        fixedObjId++;
        return fixedObjId;
    }
}
