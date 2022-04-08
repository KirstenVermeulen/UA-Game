package ua.game.graphics;

import javax.swing.*;

public class J2DContext {

    /* FIELDS */
    private JFrame window;
    private J2DPanel panel;

    /* GETTERS & SETTERS */

    public JFrame getWindow() {
        return window;
    }

    /* CONSTRUCTOR */

    public J2DContext() {
        window = new JFrame();
        panel = new J2DPanel(16, 3, 26, 15);

        window.setSize(panel.getScreenWidth(), panel.getScreenHeight());

        window.add(panel);
        window.setTitle("Advanced Programming");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setFocusable(true);
        window.setResizable(true);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    /* METHODS */

    public void render() {
        panel.repaint();
    }
}