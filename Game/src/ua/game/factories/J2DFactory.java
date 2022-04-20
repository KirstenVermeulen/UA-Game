package ua.game.factories;

import ua.game.entities.AbstractPlayer;
import ua.game.entities.J2DPlayer;
import ua.game.graphics.CollisionManager;
import ua.game.graphics.J2DContext;
import ua.game.graphics.TileManager;
import ua.game.inputs.AbstractInput;
import ua.game.inputs.J2DInput;

public class J2DFactory extends AbstractFactory {

    /* FIELDS */

    private final J2DContext j2dContext;

    /* CONSTRUCTOR */

    public J2DFactory() {
        this.j2dContext = new J2DContext();
    }

    /* METHODS */

    @Override
    public AbstractInput createInput() {
        return new J2DInput(j2dContext.getFrame());
    }

    @Override
    public TileManager createTileManager() {
        return new TileManager(j2dContext);
    }

    @Override
    public CollisionManager createCollisionManager() {
        return new CollisionManager(j2dContext);
    }

    @Override
    public AbstractPlayer createPlayer(int x, int y) {
        AbstractPlayer player = new J2DPlayer(this.j2dContext);
        player.getMovable().setPosition(new float[] {x, y});
        return player;
    }

    @Override
    public void loadAssets() {
        j2dContext.loadAssets();
    }

    @Override
    public void render() {
        j2dContext.render();
    }

}
