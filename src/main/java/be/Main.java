package be;

import be.game.Game;

public class Main {

    public static void main(String[] args) {

        /**
         * The game runs in a Thread
         */
        Game game = Game.getInstance();

        Thread t1 = new Thread(game);
        t1.start();

    }
}
