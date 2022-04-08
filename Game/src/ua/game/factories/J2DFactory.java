package ua.game.factories;

import ua.game.entities.AbstractPlayer;
import ua.game.entities.J2DPlayer;
import ua.game.graphics.J2DContext;

public class J2DFactory extends AbstractFactory {

    /* FIELDS */

    private J2DContext j2dContext;

    /* CONSTRUCTOR */

    public J2DFactory() {
        this.j2dContext = new J2DContext();
    }

    /* METHODS */

    @Override
    public AbstractPlayer createPlayer() {
        return new J2DPlayer(0,0,"Kirsten", 5, this.j2dContext);
    }

    @Override
    public void render() {
        j2dContext.render();
    }

}
