package game;

import game.components.Movable;
import game.entities.AbstractEntity.State;
import game.entities.AbstractPlayer;
import game.factories.AbstractFactory;
import game.graphics.CollisionManager;
import game.graphics.TileManager;
import game.inputs.AbstractInput;
import game.systems.Move;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game{

    /* FIELDS */

    /* Game properties */
    private boolean isRunning;
    private boolean isPaused;

    private final AbstractFactory factory;
    private AbstractInput input;
    private TileManager tileManager;
    private CollisionManager collisionManager;

    /* Graphics properties */

    private int fps;
    private GameClock gameClock;

    /* Entities */

    private AbstractPlayer player;

    /* Systems */

    private final Move movementUpdater;


    /* CONSTRUCTORS */

    public Game(AbstractFactory factory, int fps) {
        isRunning = true;
        isPaused = false;

        this.factory = factory;
        this.fps = fps;

        /* Create update systems */

        movementUpdater = new Move();
    }

    /* METHODS */

    public void initGame() throws IOException {
        this.gameClock = new GameClock(this.fps);
        factory.loadAssets();

        input = factory.createInput();
        tileManager = factory.createTileManager();
        collisionManager = factory.createCollisionManager();

        /* Create entities */
        player = factory.createPlayer(10, 10);

        /* List all drawable entities */

    }

    public void loadLevel(String level) {



    }

    public void run() throws IOException {

        System.out.println("Launching game...");

        initGame();

        this.gameClock.start();

        /* Game loop */
        while (isRunning) {

            /* Game logic */

            if (!isPaused) {

                /* 1. Update */
                update();
            }

            /* 2. Draw */
            draw();

            /* 3. Render */
            factory.render();


            /* 4. FPS */
            gameClock.sleep();
        }
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

        /* Collision */
        player.isColliding = false;
        collisionManager.checkTile(player);


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

}
