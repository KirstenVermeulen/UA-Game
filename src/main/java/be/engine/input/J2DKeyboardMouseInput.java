package be.engine.input;

import be.engine.graphics.J2DContext;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class J2DKeyboardMouseInput extends Input {

    /* FIELDS */

    private Keyboard keyboard;
    private Mouse mouse;

    /* CONSTRUCTOR */

    public J2DKeyboardMouseInput(J2DContext context) {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();

        context.getFrame().addKeyListener(keyboard);
        context.getFrame().addMouseListener(mouse);
        context.getFrame().addMouseMotionListener(mouse);
    }

    /* GETTERS */

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    /* METHODS */

    public void init(J2DContext context) {
        context.getFrame().addKeyListener(keyboard);
        context.getFrame().addMouseListener(mouse);
        context.getFrame().addMouseMotionListener(mouse);
    }

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
