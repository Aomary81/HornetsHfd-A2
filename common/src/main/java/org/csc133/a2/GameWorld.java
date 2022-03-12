package org.csc133.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;

import static org.csc133.a2.gameobjects.Helicopter.decelerate;

public class GameWorld {
    private final Button RESTART = new Button("Restart");
    private final Button EXIT = new Button("Exit");
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();
    private Helipad helipad;
    private River river;
    private Helicopter helicopter;
    private int water, fuel, ticks;
    private ArrayList<Fire> deadFires;
    private Random r;
    private ArrayList<GameObject> gameObjects;
    private Building building1, building2, building3;
    private Dimension worldSize;
    private WildFire wildFire;
    private Fire fire;
    private double damage, value;

    public GameWorld() {
        worldSize = new Dimension();
        r = new Random();
        fuel = 25000;
        water = 0;
        damage = 0;
        init();
    }

    public void init() {
        helipad = new Helipad(worldSize);
        river = new River(worldSize);
        building1 = new Building(worldSize);
        building2 = new Building(worldSize);
        building2.setBuildingLocationX(worldSize.getWidth()/16);
        building2.setBuildingLocationY(worldSize.getHeight()/2*3);
        building2.setBuildingDimension(worldSize.getWidth()/10,
                worldSize.getHeight()/10 * 3);
        building3 = new Building(worldSize);
        building3.setBuildingLocationX(worldSize.getWidth()/16 * 11);
        building3.setBuildingLocationY(worldSize.getHeight()/2*3);
        building3.setBuildingDimension(worldSize.getWidth()/10,
                worldSize.getHeight()/10 * 3);
        fire = new Fire(worldSize);
        helicopter = new Helicopter(worldSize);
        wildFire = new WildFire();
        deadFires = new ArrayList<>();
        gameObjects = new ArrayList<>();
        ticks = 0;
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(building1);
        gameObjects.add(building2);
        gameObjects.add(building3);
        gameObjects.add(wildFire);
        gameObjects.add(helicopter);
    }
    void tick() {
        ticks++;


        if (ticks % 3 == 0) {
            for(Fire spot: wildFire)
            fire.grow();
        }
        if(getFireSize() < 1000) {
            wildFire.add(new Fire(worldSize));
        }
        helicopter.move();
        fuel = helicopter.fuelConsumption();
        water = helicopter.getWaterLevel();
        if ((fuel <= 0) ||
                (wildFire.size()==0 && helicopter.isOverHelipad(helipad))) {
            gameOver();
        }
    }
    public void turnLeft() {
        helicopter.turningL();
    }

    // method to call helicopter command turn right
    public void turnRight() {
        helicopter.turningR();
    }

    // Method for filling the water tank on helicopter
    public void drink() {
        if (helicopter.overRiver(river)) {
            helicopter.drinkWater();
        }
    }
    public void fight() {
        if (water > fire.getFireSize()) {
                    fire.shrink(water);
                }
        helicopter.fightFire();

    }
    void gameOver() {
        RESTART.addActionListener(actionEvent -> {
            Game game = new Game();
            game.show();
        });
        EXIT.addActionListener(actionEvent -> quit());
        Dialog dlg = new Dialog("GAME OVER!");
        dlg.setLayout(new BorderLayout());
        if (fuel <= 0) {
            dlg.add(BorderLayout.CENTER, "YOU LOSE!!! TRY AGAIN!!!");
        } else {
            dlg.add(BorderLayout.CENTER, "Your High Score is: " + fuel);
        }
        dlg.add(BorderLayout.EAST, RESTART);
        dlg.add(BorderLayout.WEST, EXIT);
        dlg.show(DISP_H / 24 * 10, DISP_H / 24 * 10, DISP_W / 24 * 9,
                DISP_H / 24 * 9);
    }
    public void quit() {
        Display.getInstance().exitApplication();
    }

    public ArrayList<GameObject> getGameObjectCollection() {
        return gameObjects;
    }

    public String getHeading() {
        return String.valueOf(helicopter.heading());
    }

    public String getSpeed() {
        return String.valueOf(Helicopter.getSpeed());
    }
    public String getFuel(){
        return String.valueOf(fuel);
    }
    public String getFires(){
        return String.valueOf(wildFire.size());
    }
    public static int getFireSize(){
        int flame = 0;
        for(Fire spot: wildFire){
            flame = flame + spot.getFireSize();
        }
        return flame;
    }
    public String getDamage(){
        return String.valueOf(0);
    }
    public String getLoss(){
        return String.valueOf(0);
    }

    public void setDimension(Dimension worldSize) {
        this.worldSize = worldSize;
    }

    public void accelerate() {
        helicopter.accelerate();
    }

    public void brake() {
        helicopter.decelerate();
    }
}
