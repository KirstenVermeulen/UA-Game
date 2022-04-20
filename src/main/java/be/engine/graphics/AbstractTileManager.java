package be.engine.graphics;

import be.datastructures.Layout;
import be.datastructures.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
