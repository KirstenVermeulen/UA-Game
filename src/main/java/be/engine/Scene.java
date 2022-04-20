package be.engine;

import java.awt.Graphics2D;

public abstract class Scene {

    /* FIELDS */

    public static Camera camera;

    /* METHODS */

    public abstract void init();
    public abstract void update(double dt);
    public abstract void draw();
}