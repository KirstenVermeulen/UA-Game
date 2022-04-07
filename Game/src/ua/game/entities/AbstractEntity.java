package ua.game.entities;

public abstract class AbstractEntity {

    /* FIELDS */

    private int x;
    private int y;

    /* CONSTRUCTORS */

    public AbstractEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* GETTERS & SETTERS */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
