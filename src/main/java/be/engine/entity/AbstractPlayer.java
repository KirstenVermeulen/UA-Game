package be.engine.entity;

import be.engine.component.Movement;
import be.engine.component.Sound;
import be.engine.component.Sprite;
import be.engine.graphics.Drawable;

public abstract class AbstractPlayer implements Drawable {

    /* FIELDS */

    private String name;

    private Movement movement;
    private Sound sound;
    private Sprite sprite;

    /* CONSTRUCTOR */

    public AbstractPlayer(String name) {
        this.name = name;

        movement = new Movement();
        sound = new Sound();
        sprite = new Sprite();
    }

    /* GETTERS & SETTERS */

    public Sprite getSprite() {
        return sprite;
    }

    /* METHODS */

    public abstract void draw();
}
