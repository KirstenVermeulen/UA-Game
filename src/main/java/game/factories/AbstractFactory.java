package game.factories;

import game.entities.AbstractPlayer;
import game.graphics.CollisionManager;
import game.graphics.TileManager;
import game.inputs.AbstractInput;

import java.io.IOException;

public abstract class AbstractFactory {

    public abstract AbstractInput createInput();
    public abstract TileManager createTileManager() throws IOException;
    public abstract CollisionManager createCollisionManager();

    public abstract AbstractPlayer createPlayer(int x, int y);

    public abstract void loadAssets();

    public abstract void render();
}
