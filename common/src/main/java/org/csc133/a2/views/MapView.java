package org.csc133.a2.views;


import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;

public class MapView extends Container {
    GameWorld gw;

    public MapView(GameWorld gw) {
        this.gw = gw;
    }
    public void paint(Graphics g){
        super.paint(g);

        for(GameObject go: gw.getGameObjectCollection()){
            go.draw(g, new Point(this.getX(), this.getY()));
        }
    }
}
