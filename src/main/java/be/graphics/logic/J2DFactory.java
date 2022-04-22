package be.graphics.logic;

import be.engine.data.EnemyStats;
import be.engine.ecs.entities.AbstractEnemy;
import be.engine.ecs.entities.AbstractPlayer;
import be.engine.factory.AbstractFactory;
import be.engine.input.Input;
import be.util.Constants;
import be.graphics.entities.J2DEnemy;
import be.graphics.entities.J2DPlayer;

public class J2DFactory extends AbstractFactory {

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
        return new J2DPlayer(Constants.PLAYER_NAME, context);
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
