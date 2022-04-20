package be.game;

import be.engine.LevelScene;
import be.engine.Scene;
import be.engine.factory.Factory;
import be.engine.factory.J2DFactory;
import be.engine.input.Input;
import be.util.Time;

public class Game implements Runnable {

    /* FIELDS */

    /* Singleton */
    private static Game instance = null;

    /* Properties */
    private boolean running = true;

    /* Graphics */
    private final Scene scene;

    /* CONSTRUCTOR (SINGLETON) */

    private Game() {
        scene = new LevelScene();
        scene.init();
    }

    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }

        return Game.instance;
    }

    /* METHODS */

    public void run() {
        double lastFrameTime = 0.0;

        try {
            while(running) {

                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                scene.update(deltaTime);
                scene.draw();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
