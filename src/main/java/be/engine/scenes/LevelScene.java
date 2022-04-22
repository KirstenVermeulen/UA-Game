package be.engine.scenes;

import be.engine.data.LevelManager;
import be.engine.data.EnemyStats;
import be.engine.data.Level;
import be.engine.ecs.entities.AbstractEnemy;
import be.engine.ecs.entities.AbstractPlayer;
import be.engine.factory.AbstractFactory;
import be.engine.graphics.AbstractTileManager;
import be.engine.input.Input;
import be.util.Constants;

public class LevelScene extends AbstractScene {

    /* FIELDS */

    /* Managers */
    private LevelManager levelManager;
    private AbstractTileManager tileManager;

    private AbstractPlayer player;
    private AbstractEnemy[] enemies;
    private int[][] mapLayout;

    /* Input */
    private Input input;

    /* Properties */
    private Level currentLevel;
    private boolean paused = false;

    /* CONSTRUCTOR */

    public LevelScene(AbstractFactory factory) {
        super(factory);

        /* Managers */
        levelManager = new LevelManager();
        levelManager.init(Constants.LEVEL_CONFIG);

        tileManager = factory.createTileManager();

        /* Input */
        input = factory.createInput();


    }

    /* METHODS */

    @Override
    public void init() {
        /* Load the first level */
        loadLevel(levelManager.getLevel(1));
    }

    @Override
    public void update() {
        if (paused) {
            if (input.getInput().get(Input.Action.PAUSE)) {
                paused = false;
            }
        } else {

            /**
             * UPDATE HERE
             */

            if (input.getInput().get(Input.Action.PAUSE)) {
                paused = true;
            }
        }
    }

    @Override
    public void draw() {
        /* Layout */

        /**
         * Still need to resize the tile sprites
         */

        tileManager.draw(currentLevel.getLayout(), mapLayout);

        /* Enemies */
        for (AbstractEnemy enemy : enemies) {
            enemy.draw();
        }

        /* Player */
        player.draw();

        getFactory().render();
    }

    public void loadLevel(Level level) {
        System.out.println("Loading level...");

        currentLevel = level;

        /* Create all the necessary objects */
        player = getFactory().createPlayer();

        EnemyStats[] enemyStats = level.getEnemyStats();
        enemies = new AbstractEnemy[enemyStats.length];

        for (int i = 0; i < enemyStats.length; i++) {
            enemies[i] = getFactory().createEnemy(enemyStats[i]);
        }

        mapLayout = tileManager.loadMap(level.getLayout());
    }
}
