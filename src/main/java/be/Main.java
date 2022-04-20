package game;

import game.factories.*;

public class Main {

    public static void main(String[] args) {

        /**
         * The game runs in a Thread
         */
        Game game = Game.getGame();
        game.init();

        Thread t1 = new Thread(game);
        t1.start();

    }
}
