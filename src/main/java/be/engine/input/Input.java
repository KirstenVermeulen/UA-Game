package be.engine.input;

import java.util.Map;

public abstract class Input {

    /* FIELDS */

    /**
     * Contains all the actions a player can execute
     */
    public enum Action {UP, DOWN, LEFT, RIGHT, RUN, JUMP, ATTACK, PAUSE}

    /* METHODS */

    public abstract Map<Action, Boolean> getInput();


}
