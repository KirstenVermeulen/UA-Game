package ua.game;

public class Game {

    /* FIELDS */

    private boolean isRunning;
    private boolean isPaused;

    /* CONSTRUCTORS */

    public Game() {
    }

    /* METHODS */

    public void run() {
        System.out.println("Launching game...");

        isRunning = true;
        isPaused = false;


        /* Game loop */
        while (isRunning) {
            if (!isPaused) {

                /* Game logic */
                System.out.println("The game is running");

            }
        }
    }
}
