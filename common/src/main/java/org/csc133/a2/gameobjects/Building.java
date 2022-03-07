package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import java.util.Random;

import static com.codename1.ui.CN.*;

public class Building extends Fixed{
    private int value;
    private double damage;
    private Random r;
    public Building(Dimension worldSize){
        r = new Random();
        value = 100 + r.nextInt(901);
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
    public void setBuildingDimension(int x, int y){
        dimension.setWidth(x);
        dimension.setHeight(y);
    }
    public int getBuildingLocationX(){
        return (int)location.getX();
    }
    public int getBuildingLocationY(){
        return (int)location.getY();
    }
    public double getAreaOfBuilding(){
        return (dimension.getWidth() * dimension.getHeight());
    }
    public void setFireInBuilding(Fire fire){
        fire.setLocationX((int)location.getX() + (dimension.getWidth()/2)
                + r.nextInt(dimension.getWidth()));
        fire.setLocationY((int)location.getY()
                - (worldSize.getHeight()/20 *19)
                +r.nextInt(dimension.getHeight()));
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.drawRect(containerOrigin.getX() + (int)location.getX()
                        + (dimension.getWidth()/2),
                containerOrigin.getY() + (int)location.getY()
                        - (worldSize.getHeight()/20 *19),
                dimension.getWidth(), dimension.getHeight());
        g.setFont(Font.createSystemFont(FACE_MONOSPACE, STYLE_BOLD,
                SIZE_MEDIUM));

        g.drawString("V: " + value,
                containerOrigin.getX() + (int)location.getX()
                        + (dimension.getWidth()/2 *3 +5),
                containerOrigin.getY() + (int)location.getY()
                        - (worldSize.getHeight()/20 *18));
        g.drawString("D: " + damage,
                containerOrigin.getX() + (int)location.getX()
                        + (dimension.getWidth()/2 *3 + 5),
                containerOrigin.getY() + (int)location.getY()
                        - (worldSize.getHeight()/20 *18) + 25);
    }
}
