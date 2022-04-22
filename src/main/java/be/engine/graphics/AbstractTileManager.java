package be.engine.graphics;

import be.engine.data.Layout;
import be.engine.data.Tile;

import java.util.HashMap;

public abstract class AbstractTileManager {

    /* FIELDS */

    private HashMap<Integer, Tile> tiles;

    /* CONSTRUCTOR */

    public AbstractTileManager(HashMap<Integer, Tile> tiles) {
        this.tiles = tiles;
    }

    /* GETTER & SETTER */

    public HashMap<Integer, Tile> getTiles() {
        return tiles;
    }

    public void addTile(int id, Tile tile) {
        this.tiles.put(id, tile);
    }

    public void clearTiles() {
        this.tiles.clear();
    }

    /* METHODS */

    public abstract int[][] loadMap(Layout layout);

    public abstract void draw(Layout layout, int[][] mapLayout);

}
