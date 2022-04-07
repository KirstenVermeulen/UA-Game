package ua.game.entities;

public abstract class AbstractPlayer extends AbstractEntity {

    /* FIELDS */

    private String name;

    /* CONSTRUCTOR */

    public AbstractPlayer(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    /* GETTERS & SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* METHODS */

    abstract void visualise();
}
