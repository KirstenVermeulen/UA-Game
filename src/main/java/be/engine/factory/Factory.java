package game.factories;

import game.LevelManager;
import game.entities.AbstractPlayer;
import game.graphics.TileManager;
import game.inputs.Input;

public abstract class Factory {

    public abstract Input createInput();
    public abstract LevelManager createLevelManager();
    public abstract TileManager createTileManager();

    public abstract AbstractPlayer createPlayer(int x, int y);

    public abstract void loadAssets();

    public abstract void render();
}
