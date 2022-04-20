package be.engine.factory;

import be.datastructures.EnemyStats;
import be.engine.entity.AbstractEnemy;
import be.engine.entity.AbstractPlayer;
import be.engine.entity.J2DEnemy;
import be.engine.entity.J2DPlayer;
import be.engine.graphics.J2DContext;
import be.engine.graphics.J2DTileManager;
import be.engine.input.Input;
import be.engine.input.J2DKeyboardMouseInput;
import be.game.Settings;

public class J2DFactory extends Factory {

    /* FIELDS */

    /* Context */
    private final J2DContext context;

    /* CONSTRUCTOR */

    public J2DFactory() {
        context = new J2DContext();
        context.init();
    }

    /* METHODS */

    @Override
    public Input createInput() {
        return new J2DKeyboardMouseInput(context);
    }

    @Override
    public J2DTileManager createTileManager() {
        return new J2DTileManager(context);
    }

    @Override
    public AbstractPlayer createPlayer() {
        return new J2DPlayer(Settings.PLAYER_NAME, context);
    }

    @Override
    public AbstractEnemy createEnemy(EnemyStats enemyStats) {
        return new J2DEnemy(enemyStats);
    }

    @Override
    public void render() {
        context.render();
    }
}
