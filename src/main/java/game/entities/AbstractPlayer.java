package game.entities;

import game.components.Movable;

public abstract class AbstractPlayer extends AbstractEntity{

    /* FIELDS */

    private int screenX;

    /* CONSTRUCTOR */

    public AbstractPlayer(Movable movable) {
        super(movable);
    }

    /* GETTERS & SETTERS */

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }
}
