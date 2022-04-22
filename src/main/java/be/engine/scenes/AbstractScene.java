package be.engine.scenes;

import be.engine.factory.AbstractFactory;
import be.engine.graphics.Camera;

public abstract class AbstractScene {

    /* FIELDS */

    private static AbstractFactory factory;
    public static Camera camera;

    /* CONSTRUCTOR */

    public AbstractScene(AbstractFactory factory) {
        this.factory = factory;
    }

    /* GETTER */

    public static AbstractFactory getFactory() {
        return factory;
    }

    /* METHODS */

    public abstract void init();
    public abstract void update();
    public abstract void draw();
}