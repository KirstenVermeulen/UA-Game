package be.engine.input;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyboardMouseInput extends Input {

    /* FIELDS */

    /* Singleton */
    private static KeyboardMouseInput instance = null;

    private Keyboard keyboard;
    private Mouse mouse;

    /* CONSTRUCTOR (SINGLETON) */

    private KeyboardMouseInput() {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
    }

    public static KeyboardMouseInput getInstance() {
        if (KeyboardMouseInput.instance == null) {
            KeyboardMouseInput.instance = new KeyboardMouseInput();
        }

        return KeyboardMouseInput.instance;
    }

    /* GETTERS */

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    /* METHODS */

    @Override
    public Map<Action, Boolean> getInput() {
        HashMap<Action, Boolean> input = new HashMap<>();

        for (Action a : Action.values()) {
            switch (a) {
                case UP -> input.put(Action.UP, keyboard.isKeyPressed(KeyEvent.VK_W));
                case DOWN -> input.put(Action.DOWN, keyboard.isKeyPressed(KeyEvent.VK_S));
                case LEFT -> input.put(Action.LEFT, keyboard.isKeyPressed(KeyEvent.VK_A));
                case RIGHT -> input.put(Action.RIGHT, keyboard.isKeyPressed(KeyEvent.VK_D));
                case RUN -> input.put(Action.RUN, keyboard.isKeyPressed(KeyEvent.VK_SHIFT));
                case JUMP -> input.put(Action.JUMP, keyboard.isKeyPressed(KeyEvent.VK_SPACE));
                case ATTACK -> input.put(Action.ATTACK, mouse.isMousePressed());
                case PAUSE -> input.put(Action.PAUSE, keyboard.isKeyPressed(KeyEvent.VK_ESCAPE));
            }
        }

        return input;
    }
}
