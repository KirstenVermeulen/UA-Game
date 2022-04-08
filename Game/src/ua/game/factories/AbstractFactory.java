package ua.game.factories;

import ua.game.entities.AbstractPlayer;

public abstract class AbstractFactory {
    public abstract AbstractPlayer createPlayer();

    public abstract void render();
}
