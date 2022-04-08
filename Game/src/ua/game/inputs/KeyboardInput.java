package ua.game.inputs;

import ua.game.graphics.J2DContext;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class KeyboardInput extends AbstractInput implements KeyListener {

    /* FIELDS */

    private LinkedList<Inputs> keyInputs;

    /* CONSTRUCTOR */

    public KeyboardInput() {
        keyInputs = new LinkedList<Inputs>();
    }

    /* METHODS */

    @Override
    public boolean inputAvailable() {
        return keyInputs.size() > 0;
    }

    @Override
    public Inputs getInput() {
        return keyInputs.poll();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /* Not used */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_W : keyInputs.add(Inputs.UP);  break;
            case KeyEvent.VK_S : keyInputs.add(Inputs.DOWN); break;
            case KeyEvent.VK_A : keyInputs.add(Inputs.LEFT);  break;
            case KeyEvent.VK_D : keyInputs.add(Inputs.RIGHT);    break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        /* Not used */
    }
}
