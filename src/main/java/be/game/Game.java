package be.game;

import be.engine.scenes.LevelScene;
import be.engine.scenes.AbstractScene;
import be.engine.factory.AbstractFactory;
import be.util.Time;

public class Game implements Runnable {

    /* FIELDS */

    /* Singleton */
    private static Game instance = null;

    /* Properties */
    private boolean running = true;

    /* Graphics */
    private AbstractScene scene;

    /* CONSTRUCTOR (SINGLETON) */

    private Game() {
    }

    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }

        return Game.instance;
    }

    /* METHODS */

    public void setGraphicsLibrary(AbstractFactory factory) {
        scene = new LevelScene(factory);
        scene.init();
    }

    public void run() {
        Time.start();

        try {
            while(running) {

                scene.update();
                scene.draw();

                Time.sleep();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
