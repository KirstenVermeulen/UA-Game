package game.factories;

import game.entities.AbstractPlayer;
import game.entities.J2DPlayer;
import game.graphics.CollisionManager;
import game.graphics.J2DContext;
import game.graphics.TileManager;
import game.inputs.AbstractInput;
import game.inputs.J2DInput;

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
