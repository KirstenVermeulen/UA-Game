package game.inputs;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class J2DInput extends AbstractInput {

    /* CONSTRUCTOR */

    public J2DInput(JFrame frame) {
        pressed = new boolean[6];
        frame.addKeyListener(new KeyInputAdapter());
    }

    /* METHODS */

    @Override
    public boolean[] getPressed() {
        return pressed;
    }

    /* CLASS */

    class KeyInputAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> pressed[0] = true;
                case KeyEvent.VK_S -> pressed[1] = true;
                case KeyEvent.VK_A -> pressed[2] = true;
                case KeyEvent.VK_D -> pressed[3] = true;
                case KeyEvent.VK_SHIFT -> pressed[4] = true;
                case KeyEvent.VK_SPACE -> pressed[5] = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> pressed[0] = false;
                case KeyEvent.VK_S -> pressed[1] = false;
                case KeyEvent.VK_A -> pressed[2] = false;
                case KeyEvent.VK_D -> pressed[3] = false;
                case KeyEvent.VK_SHIFT -> pressed[4] = false;
                case KeyEvent.VK_SPACE -> pressed[5] = false;
            }
        }
    }
}
