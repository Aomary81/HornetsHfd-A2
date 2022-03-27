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
    private Helipad helipad;
    private River river;
    private Helicopter helicopter;
    private int water, fuel, ticks;
    private ArrayList<Fire> deadFires;
    private Random r;
    private ArrayList<GameObject> gameObjects;
    private Building building1, building2, building3;
    private Dimension worldSize;
    private Build classroom;
    private WildFire wildFire1, wildFire2, wildFire3;
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
        wildFire1 = new WildFire();
        wildFire2 = new WildFire();
        wildFire3 = new WildFire();
        classroom = new Build();
        fire = new Fire(worldSize);
        building1 = new Building(worldSize);
        building2 = new Building(worldSize);
        building2.setBuildingLocationX(worldSize.getWidth()/8);
        building2.setBuildingLocationY(worldSize.getHeight()/2);
        building2.setBuildingDimension(worldSize.getWidth()/10,
                worldSize.getHeight()/10 * 3);
        building3 = new Building(worldSize);
        building3.setBuildingLocationX(worldSize.getWidth()/8 * 6);
        building3.setBuildingLocationY(worldSize.getHeight()/2);
        building3.setBuildingDimension(worldSize.getWidth()/10,
                worldSize.getHeight()/10 * 3);
        classroom.add(building1);
        classroom.add(building2);
        classroom.add(building3);
        helicopter = new Helicopter(worldSize);
        wildFire1 = new WildFire();
        while(wildFire1.size() < 2){
            wildFire1.add(new Fire(worldSize));
        }
        wildFire2 = new WildFire();
        while(wildFire2.size() < 2){
            wildFire2.add(new Fire(worldSize));
        }
        wildFire3 = new WildFire();
        while(wildFire3.size() < 2){
            wildFire3.add(new Fire(worldSize));
        }
        deadFires = new ArrayList<>();
        gameObjects = new ArrayList<>();

        ticks = 0;
        gameObjects.add(river);
        gameObjects.add(helipad);
        gameObjects.add(classroom);
        gameObjects.add(wildFire1);
        gameObjects.add(wildFire2);
        gameObjects.add(wildFire3);
        gameObjects.add(helicopter);
    }
    void tick() {
        ticks++;
        for (Fire spot : wildFire1) {
                building1.setFireInBuilding(spot);
        }
        for (Fire spot : wildFire2) {
                building2.setFireInBuilding(spot);
        }
        for (Fire spot : wildFire3) {
                building3.setFireInBuilding(spot);
        }
        if (ticks % 10 == 0) {
            for(Fire spot: wildFire1){
                spot.grow();
            }
            for(Fire spot: wildFire2){
                spot.grow();
            }
            for(Fire spot: wildFire3){
                spot.grow();
            }
        }


        helicopter.move();
        fuel = helicopter.fuelConsumption();
        water = helicopter.getWaterLevel();
        if ((fuel <= 0) /*||
                (wildFire.size()==0 && helicopter.isOverHelipad(helipad))*/) {
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
        dlg.show(worldSize.getHeight() / 24 * 10, worldSize.getHeight() / 24 * 10,
                worldSize.getWidth() / 24 * 9,
                worldSize.getHeight() / 24 * 9);
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
        return String.valueOf(wildFire1.size() + wildFire2.size()
                + wildFire3.size());
    }
    public int getFireSize() {
        double flame = 0;
        for(Fire spot: wildFire1){
            flame = flame + spot.getFireSize();
        }
        for(Fire spot: wildFire2){
            flame = flame + spot.getFireSize();
        }
        for(Fire spot: wildFire3){
            flame = flame + spot.getFireSize();
        }
        return (int) flame;
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
