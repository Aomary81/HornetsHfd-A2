package org.csc133.a2;

import com.codename1.system.Lifecycle;

/**
 * This file was generated by <a href="https://www.codenameone.com/"
 * >Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */
public class AppMain extends Lifecycle {

    @Override
    public void runApp() {
        Game game = new Game();
        game.show();
    }
}

