package ua.game.factories;

import ua.game.entities.AbstractPlayer;
import ua.game.graphics.CollisionManager;
import ua.game.graphics.TileManager;
import ua.game.inputs.AbstractInput;

import java.io.IOException;

public abstract class AbstractFactory {

    public abstract AbstractInput createInput();
    public abstract TileManager createTileManager() throws IOException;
    public abstract CollisionManager createCollisionManager();

    public abstract AbstractPlayer createPlayer(int x, int y);

    public abstract void loadAssets();

    public abstract void render();
}
