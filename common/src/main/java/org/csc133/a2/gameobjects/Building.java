package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class Building extends Fixed{
    private int buildingId;
    public Building(Dimension worldSize){
        buildingId = getFixedObjId();
        this.worldSize = worldSize;
        this.color = ColorUtil.rgb(255,0,0);
        this.location = new Point2D(0, worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth()/2,
                worldSize.getHeight()/10);
    }

    public void setBuildingLocationX(double x){
        location.setX(x);
    }
    public void setBuildingLocationY(double y){
        location.setY(y);
    }
    public int getBuildingLocationX(){
        return (int)location.getX();
    }
    public int getBuildingLocationY(){
        return (int)location.getY();
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.drawRect(containerOrigin.getX() + (int)location.getX() + (dimension.getWidth()/2),
                containerOrigin.getY() + (int)location.getY() - (worldSize.getHeight()/20 *19),
                dimension.getWidth(), dimension.getHeight());
    }
}
