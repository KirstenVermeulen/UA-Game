package ua.game.entities;

public abstract class AbstractPlayer extends AbstractEntity {

    /* FIELDS */

    private String name;
    private int speed;

    /* CONSTRUCTOR */

    public AbstractPlayer(int x, int y, String name, int speed) {
        super(x, y);
        this.name = name;
        this.speed = speed;
    }

    /* GETTERS & SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* METHODS */
}
