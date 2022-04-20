package game;

import game.components.Movable;
import game.entities.AbstractEntity.State;
import game.entities.AbstractPlayer;
import game.factories.Factory;
import game.factories.J2DFactory;
import game.graphics.TileManager;
import game.inputs.Input;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements Runnable {

    /* FIELDS */

    /* Singleton */
    private static Game game = null;

    /* Graphics properties */

    /* Game properties */
    private boolean running = true;
    private boolean paused = false;





    /* Managers */
    private final Factory factory = new J2DFactory();;
    private Input input;
    private TileManager tileManager;
    private LevelManager levelManager;


    /* Game Objects */
    private AbstractPlayer player;

    /* Systems */


    /* CONSTRUCTOR (SINGLETON) */

    private Game() {



    }

    public static Game getGame() {
        if (Game.game == null) {
            Game.game = new Game();
        }

        return Game.game;
    }

    /* METHODS */

    public void init() {
        factory.loadAssets();

        input = factory.createInput();
        levelManager = factory.createLevelManager();
        tileManager = factory.createTileManager();

        /* Create entities */
        player = factory.createPlayer(10, 10);

        /* List all drawable entities */

        /* Load level 1 */
        levelManager.startLevel(tileManager,"src/main/resources/levels/levelsConfig.json");

    }

    private void togglePause() {
        paused = !paused;
    }

    private void update() {

        /* Input */

        float[] velocity = {0, 0};
        boolean[] currentInput = input.getPressed();

        player.currentState = State.IDLE;

        if (currentInput[0]) {
            /* Up */
            player.currentState = State.CLIMB;
            velocity[1] = velocity[1] - 2;
        }
        if (currentInput[1]) {
            /* Down */
            player.currentState = State.CLIMB;
            velocity[1] = velocity[1] + 2;
        }
        if (currentInput[2]) {
            /* Left */
            player.currentState = State.WALK;
            velocity[0] = velocity[0] - 2;
        }
        if (currentInput[3]) {
            /* Right */
            player.currentState = State.WALK;
            velocity[0] = velocity[0] + 2;
        }
        if (currentInput[4] && (currentInput[2] || currentInput[3])) {
            /* Run */
            player.currentState = State.RUN;
            velocity[0] = velocity[0] * 1.8f;

        }
        if (currentInput[5]) {
            /* Jump */
            player.currentState = State.JUMP;
            player.movable.setIsJumping(true);
        }

        /* Movement */
        player.movable.setVelocity(velocity);
        List<Movable> componentList = new ArrayList<>();
        componentList.add(player.getMovable());
        movementUpdater.update(componentList);
    }

    private void draw() {
        /* Draw the map */
        tileManager.drawMap();

        /* Draw the entities */
        player.visualise();
    }

    public void run() {

        while (running) {
            if (!paused) {
                update();
            }
            draw();
            factory.render();
        }
    }

}
