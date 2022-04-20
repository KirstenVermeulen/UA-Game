package game.factories;

import game.LevelManager;
import game.entities.AbstractPlayer;
import game.entities.J2DPlayer;
import game.graphics.J2DContext;
import game.graphics.TileManager;
import game.inputs.Input;
import game.inputs.KeyboardMouseInput;

public class J2DFactory extends Factory {

    /* FIELDS */

    private final J2DContext j2dContext;

    /* CONSTRUCTOR */

    public J2DFactory() {
        this.j2dContext = new J2DContext();
    }

    /* METHODS */

    @Override
    public Input createInput() {
        return new KeyboardMouseInput(j2dContext.getFrame());
    }

    @Override
    public LevelManager createLevelManager() {
        return new LevelManager();
    }

    @Override
    public TileManager createTileManager() {
        return new TileManager(j2dContext);
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
