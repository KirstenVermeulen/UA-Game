package ua.game;

import ua.game.factories.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AbstractFactory factory = new J2DFactory();

        /* RUN THE GAME */
        Game game = new Game(factory,60);
        game.run();

    }
}
