package be.engine.entity;

import be.engine.graphics.J2DContext;

import java.awt.*;

public class J2DPlayer extends AbstractPlayer {

    /* FIELDS */

    private J2DContext context;

    /* CONSTRUCTOR */

    public J2DPlayer(String name, J2DContext context) {
        super(name);
        this.context = context;
    }

    /* METHODS */

    @Override
    public void draw() {
        Graphics2D g2 = context.getG2();
        // g2.drawImage();
    }

}
