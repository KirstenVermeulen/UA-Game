package ua.game.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    /* FIELDS */

    private int duration;
    private BufferedImage[] sprites;

    /* CONSTRUCTOR */

    public Animation(int duration, BufferedImage[] sprites) {
        this.duration = duration;
        this.sprites = sprites;
    }

    /* GETTERS */

    public int getDuration() {
        return duration;
    }

    public BufferedImage[] getSprites() {
        return sprites;
    }
}
