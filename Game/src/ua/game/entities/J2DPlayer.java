package ua.game.entities;

import ua.game.graphics.J2DContext;

public class J2DPlayer extends AbstractPlayer{

    /* FIELDS */

    private J2DContext j2dContext;

    /* CONSTRUCTOR */

    public J2DPlayer(int x, int y, String name, int speed, J2DContext j2dContext) {
        super(x, y, name, speed);
        this.j2dContext = j2dContext;
    }

    /* METHODS */

    @Override
    public void visualise() {
        
    }
}
