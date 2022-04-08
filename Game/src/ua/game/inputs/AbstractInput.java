package ua.game.inputs;

public abstract class AbstractInput {
    public enum Inputs {LEFT, RIGHT, UP, DOWN}

    public abstract boolean inputAvailable();
    public abstract Inputs getInput();
}
