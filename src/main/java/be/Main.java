package be;

import be.graphics.logic.J2DFactory;
import be.game.Game;

public class Main {

    public static void main(String[] args) {

        /**
         * The game runs in a Thread
         */
        Game game = Game.getInstance();
        game.setGraphicsLibrary(new J2DFactory());

        Thread t1 = new Thread(game);
        t1.start();

    }
}
