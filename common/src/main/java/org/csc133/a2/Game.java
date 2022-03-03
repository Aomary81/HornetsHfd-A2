package org.csc133.a2;

import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.views.ControlCluster;
import org.csc133.a2.views.GlassCockpit;
import org.csc133.a2.views.MapView;

public class Game extends Form implements Runnable {
    private GameWorld gw;
    private MapView mv;
    private ControlCluster cc;
    private GlassCockpit gc;
    public Game() {
        gw = new GameWorld();
        mv = new MapView(gw);
        cc = new ControlCluster(gw);
        gc = new GlassCockpit(gw);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, gc);
        this.add(BorderLayout.CENTER, mv);
        this.add(BorderLayout.SOUTH, cc);

        UITimer timer = new UITimer(this);
        timer.schedule(100, true, this);
        // Exit Key
        addKeyListener('Q', evt -> gw.quit());
        //Left Arrow used to turn the helicopter left
        addKeyListener(-93, evt -> gw.turnLeft());
        // Right Arrow used to turn the helicopter right
        addKeyListener(-94, evt -> gw.turnRight());
        // Up Arrow to speed up the helicopter
        addKeyListener(-91, evt -> gw.speedUp());
        // Down Arrow to slow down and stop the helicopter
        addKeyListener(-92, evt -> gw.slowDown());
        // dump water
        addKeyListener('f', evt -> gw.fight());
        // drink water
        addKeyListener('d', evt -> gw.drink());
    }

    @Override
    public void run() {
        gw.tick();
        gc.update();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        //gw.draw(g);
    }
}
