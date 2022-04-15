package game.entities;

import game.components.Movable;

import java.awt.*;

public abstract class AbstractEntity implements Drawable {
    public enum State {IDLE, WALK, RUN, JUMP, CLIMB, ATTACK, HURT, DEATH}

    public Movable movable;

    public State currentState;
    public State previousState;

    public Rectangle collisionArea;
    public boolean isColliding;

    /* CONSTRUCTOR */

    public AbstractEntity(Movable movable) {
        this.movable = movable;
    }

    /* GETTER */

    public Movable getMovable() {
        return movable;
    }

}
