package be.engine.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    /* FIELDS */

    private BufferedImage image;
    private boolean collision;

    /* CONSTRUCTOR */

    public Tile(BufferedImage image, boolean collision) {
        this.image = image;
        this.collision = collision;
    }

    /* GETTERS */

    public BufferedImage getImage() {
        return image;
    }

    public boolean isCollision() {
        return collision;
    }
}
