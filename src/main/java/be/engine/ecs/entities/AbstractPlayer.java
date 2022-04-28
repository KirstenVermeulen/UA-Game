package be.engine.ecs.entities;

import be.engine.ecs.components.Movement;
import be.engine.ecs.components.Sound;
import be.engine.graphics.Animation;

import java.util.HashMap;

public abstract class AbstractPlayer extends AbstractEntity {

    /* FIELDS */

    private String name;

    private State currentState;
    private State previousState;

    private Movement movement;
    private Sound sound;

    private HashMap<State, Animation> sprites;

    /* CONSTRUCTOR */

    public AbstractPlayer(String name) {
        this.name = name;

        currentState = State.IDLE;
        previousState = State.IDLE;

        movement = new Movement();
        sound = new Sound();

        sprites = new HashMap<>();
    }

    /* GETTERS & SETTERS */

    public Animation getSprites(State state) {
        return sprites.get(state);
    }

    public void addSprite(State state, Animation animation) {
        sprites.put(state, animation);
    }

    public void clearSprites() {
        sprites.clear();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    /* METHODS */

    public abstract void loadSprites(String[] skin, int[] animationDuration);
}
