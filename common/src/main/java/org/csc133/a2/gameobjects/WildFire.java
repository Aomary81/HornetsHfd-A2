package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;


public class WildFire extends GameObjectCollection<Fire>{

    public WildFire(){
        super();
        this.color = ColorUtil.rgb(255,0,0);
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        int flame = 0;
        for(Fire spot: getGameObjects()){
            if(flame < 1000){
                spot.draw(g, containerOrigin);
                flame = flame + spot.getFireSize();
            }
        }
    }
}
