package be.engine;

import be.datastructures.EnemyStats;
import be.datastructures.Level;
import be.engine.entity.AbstractEnemy;
import be.engine.entity.AbstractPlayer;
import be.engine.factory.Factory;
import be.engine.factory.J2DFactory;
import be.engine.graphics.AbstractTileManager;
import be.engine.input.Input;
import be.game.Settings;

public class LevelScene extends Scene {

    /* FIELDS */

    /* Managers */
    private LevelManager levelManager;
    private AbstractTileManager tileManager;

    /* Objects */
    private Factory factory;

    private AbstractPlayer player;
    private AbstractEnemy[] enemies;
    private int[][] mapLayout;

    /* Input */
    private Input input;

    /* Properties */
    private Level currentLevel;
    private boolean paused = false;

    /* CONSTRUCTOR */

    public LevelScene() {

        /* Objects */
        factory = new J2DFactory();

        /* Managers */
        levelManager = new LevelManager();
        levelManager.init(Settings.LEVEL_CONFIG);

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
    public void update(double dt) {
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

        factory.render();
    }

    public void loadLevel(Level level) {
        System.out.println("Loading level...");

        currentLevel = level;

        /* Create all the necessary objects */
        player = factory.createPlayer();

        EnemyStats[] enemyStats = level.getEnemyStats();
        enemies = new AbstractEnemy[enemyStats.length];

        for (int i = 0; i < enemyStats.length; i++) {
            enemies[i] = factory.createEnemy(enemyStats[i]);
        }

        mapLayout = tileManager.loadMap(level.getLayout());
    }
}
