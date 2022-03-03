package org.csc133.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
    private final Button RESTART = new Button("Restart");
    private final Button EXIT = new Button("Exit");
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();
    private Helipad helipad;
    private River river;
    private Helicopter helicopter;
    private int water, fuel, ticks;
    private ArrayList<Fire> fires;
    private ArrayList<Fire> deadFires;
    private Random r;
    private ArrayList<GameObject> gameObjects;
    private Building building;

    public GameWorld() {
        init();
    }

    void init() {
        helipad = new Helipad();
        river = new River();
        building = new Building();
        helicopter = new Helicopter();
        fires = new ArrayList<>();
        deadFires = new ArrayList<>();
        gameObjects = new ArrayList<>();
        r = new Random();
        fuel = 25000;
        water = 0;
        for (int i = 0; i < 3; i++) {
            fires.add(new Fire());
        }
        fires.get(1).setLocationX(DISP_W / 2 + r.nextInt(DISP_W / 4));
        fires.get(1).setLocationY(r.nextInt(DISP_H / 4));
        fires.get(2).setLocationX(DISP_W / 4 + r.nextInt(DISP_W / 4));
        fires.get(2).setLocationY(DISP_H / 2 + r.nextInt(DISP_H / 4));
        ticks = 0;
        gameObjects.add(helipad);
        gameObjects.add(river);
        gameObjects.add(building);
/*        for(int i = 0; i < 3; i++) {
            gameObjects.add(fires.get(i));
        }
*/        gameObjects.add(helicopter);
    }

    void draw(Graphics g) {
        g.clearRect(0, 0, DISP_W, DISP_H);
        helipad.draw(g);
        river.draw(g);
        for (Fire spot : fires) {
            spot.draw(g);
        }
        helicopter.draw(g);
    }

    void tick() {
        ticks++;

        if (ticks % 3 == 0) {
            if (!fires.isEmpty()) {
                for (Fire spot : fires) {
                    spot.grow();
                }
            }
        }
        helicopter.move();
        fuel = helicopter.fuelConsumption();
        water = helicopter.getWaterLevel();
        if ((fuel <= 0) ||
                (fires.isEmpty() && helicopter.isOverHelipad(helipad))) {
            gameOver();
        }
    }

    // method to call helicopter command turn left
    void turnLeft() {
        helicopter.turningL();
    }

    // method to call helicopter command turn right
    void turnRight() {
        helicopter.turningR();
    }

    // method to call helicopter command to go forward and increase speed
    void speedUp() {
        helicopter.accelerate();
    }

    // method to call helicopter command to slow down and stop
    void slowDown() {
        helicopter.decelerate();
    }

    // Method for filling the water tank on helicopter
    void drink() {
        if (helicopter.overRiver(river)) {
            helicopter.drinkWater();
        }
    }

    // Method for dropping water on fire
    void fight() {
        for (Fire spot : fires) {
            if (helicopter.overFire(spot)) {
                if ((water / 2) > spot.getFireSize()) {
                    deadFires.add(spot);
                } else {
                    spot.shrink(water);
                }
            }
        }
        fires.removeAll(deadFires);
        helicopter.fightFire();
    }

    // Losing condition Dialog Window
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

    // Method for exiting the game
    void quit() {
        Display.getInstance().exitApplication();
    }

    public ArrayList<GameObject> getGameObjectCollection() {
        return gameObjects;
    }

    public String getHeading() {
        return null;
    }

    public String getSpeed() {
        return null;
    }
    public String getFuel(){
        return String.valueOf(fuel);
    }
    public String getFires(){
        return String.valueOf(fires.size());
    }
    public String getFireSize(){
        return null;
    }
    public String getDamage(){
        return null;
    }
    public String getLoss(){
        return null;
    }
}
