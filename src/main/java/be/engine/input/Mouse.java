package be.engine.inputs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    /* FIELDS */

    private boolean mousePressed = false;
    private int mouseButton = 0;

    private float x = 0f, y = 0f;

    /* CONSTRUCTOR */

    public Mouse() {
    }

    /* GETTERS & SETTERS */

    public boolean isMousePressed() {
        return mousePressed;
    }

    /* METHODS */

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.mousePressed = true;
        this.mouseButton = mouseEvent.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.mousePressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }
}
