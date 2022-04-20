package be.engine.graphics;

import be.engine.Scene;
import be.game.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class J2DContext {

    /* FIELDS */

    private final JFrame frame;
    private final JPanel panel;

    private BufferedImage image;
    private Graphics2D g2;

    /* CONSTRUCTOR */

    public J2DContext() {

        /* Window */
        frame = new JFrame();


        /* Graphics */
        panel = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D graph2d = (Graphics2D) g;

                graph2d.drawImage(image, 0, 0, null);

                graph2d.dispose();
            }
        };
        frame.add(panel);

        frame.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        frame.setTitle(Settings.SCREEN_TITLE);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    /* GETTERS & SETTERS */

    public JFrame getFrame() {
        return frame;
    }

    public Graphics2D getG2() {
        return g2;
    }

    /* METHODS */

    public void init() {
        image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2 = image.createGraphics();
    }

    public void render() {
        panel.repaint();
    }
}