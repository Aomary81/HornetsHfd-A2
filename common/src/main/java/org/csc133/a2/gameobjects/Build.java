package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Build extends GameObjectCollection<Building>{
    @Override
    public void draw(Graphics g, Point containerOrigin) {

        for(Building classroom: getGameObjects()){
            classroom.draw(g, containerOrigin);

        }
    }
}
