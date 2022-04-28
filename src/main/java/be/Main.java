package be;

import be.graphics.logic.J2DFactory;
import be.game.Game;

public class Main {

    public static void main(String[] args) {

        Game game = Game.getInstance();
        game.setGraphicsPackage(new J2DFactory());
        game.run();

    }
}
