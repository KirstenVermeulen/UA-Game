package ua.game;

import ua.game.factories.*;
import ua.game.inputs.AbstractInput;
import ua.game.inputs.KeyboardInput;

public class Main {

    public static void main(String[] args) {

        AbstractFactory factory = new J2DFactory();
        AbstractInput input = new KeyboardInput();

        /* RUN THE GAME */
        Game game = new Game(factory, input, 60);
        game.run();

    }
}
