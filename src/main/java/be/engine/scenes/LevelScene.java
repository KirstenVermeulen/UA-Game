package be.engine.scenes;

import be.engine.data.LevelManager;
import be.engine.data.EnemyStats;
import be.engine.data.Level;
import be.engine.ecs.entities.AbstractEnemy;
import be.engine.ecs.entities.AbstractEntity.State;
import be.engine.ecs.entities.AbstractPlayer;
import be.engine.factory.AbstractFactory;
import be.engine.graphics.AbstractLayoutManager;
import be.engine.input.Input;
import be.util.Constants;

import java.util.Map;

public class LevelScene extends AbstractScene {

    // FIELDS //

    // Managers //
    private LevelManager levelManager;
    private AbstractLayoutManager layoutManager;

    private AbstractPlayer player;
    private AbstractEnemy[] enemies;
    private int[][] mapLayout;

    // Input //
    private Input input;
    private Map<Input.Action, Boolean> currentInput;

    // Properties //
    private Level currentLevel;
    private boolean paused = false;

    // CONSTRUCTOR //

    public LevelScene(AbstractFactory factory) {
        super(factory);

        // Managers //
        levelManager = new LevelManager();
        levelManager.init(Constants.LEVEL_CONFIG);

        layoutManager = factory.createTileManager();

        // Input //
        input = factory.createInput();
    }

    // METHODS //

    @Override
    public void init() {
        // Load the first level //
        loadLevel(levelManager.getLevel(1));
    }

    @Override
    public void update() {
        if (paused) {
            if (input.getInput().get(Input.Action.PAUSE)) {
                paused = false;
            }
        } else {

            // TODO: update the game here
            currentInput = input.getInput();

            for (Input.Action action : currentInput.keySet()) {
                if (currentInput.get(action)) {
                    switch (action) {
                        case UP -> {
                            // TODO: Check if the player is near a ladder
                            player.setCurrentState(State.CLIMB);
                        }
                        case DOWN -> {
                            player.setCurrentState(State.CLIMB);
                        }
                        case LEFT -> {
                            player.setCurrentState(State.WALK);
                        }
                        case RIGHT -> {
                            player.setCurrentState(State.WALK);
                        }
                        case RUN -> {
                            player.setCurrentState(State.RUN);
                        }
                        case JUMP -> {
                            player.setCurrentState(State.JUMP);
                        }
                        case ATTACK -> {
                            player.setCurrentState(State.ATTACK1);
                        }
                        case PAUSE -> {
                            // TODO: Pause the game
                        }
                        default -> {
                            player.setCurrentState(State.IDLE);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void draw() {
        // Layout //
        layoutManager.draw(currentLevel.getLayout(), mapLayout);

        // Enemies //
        for (AbstractEnemy enemy : enemies) {
            enemy.draw();
        }

        // Player //
        player.draw();

        // Render //
        getFactory().render();
    }

    public void loadLevel(Level level) {
        System.out.println("Loading level...");

        currentLevel = level;

        // Create all the necessary objects //
        player = getFactory().createPlayer();

        EnemyStats[] enemyStats = level.getEnemyStats();
        enemies = new AbstractEnemy[enemyStats.length];

        for (int i = 0; i < enemyStats.length; i++) {
            enemies[i] = getFactory().createEnemy(enemyStats[i]);
        }

        mapLayout = layoutManager.loadMap(level.getLayout());
    }
}
