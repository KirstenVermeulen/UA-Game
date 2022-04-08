package ua.game;

import ua.game.factories.AbstractFactory;
import ua.game.inputs.AbstractInput;

public class Game{

    /* FIELDS */

    private boolean isRunning;
    private boolean isPaused;

    private AbstractFactory factory;
    private AbstractInput input;

    private int fps;
    private Timer timer;


    /* CONSTRUCTORS */

    public Game(AbstractFactory factory, AbstractInput input, int fps) {
        isRunning = true;
        isPaused = false;

        this.factory = factory;
        this.input = input;
        this.fps = fps;
    }

    /* METHODS */

    public void initGame() {
        this.timer = new Timer(this.fps);
        timer.start();
    }

    public void run() {
        System.out.println("Launching game...");

        initGame();

        /* Game loop */
        while (isRunning) {

            /* Game logic */

            if (input.inputAvailable()) {
                if (!isPaused) {

                    /* 1. Update */
                    update();
                }
            }

            /* 2. Draw */


            /* 3. Render */
            factory.render();


            /* 4. FPS */
            timer.sleep();
        }
    }

    private void update() {

    }

    private void draw() {

    }

}
