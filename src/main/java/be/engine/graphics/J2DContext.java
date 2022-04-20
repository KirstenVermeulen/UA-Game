package game.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class J2DContext {

    /* FIELDS */
    private final JFrame frame;
    private final JPanel panel;

    private final float scale = 1.5f;
    private final int tileSize;

    private final int maxScreenColumns = 27;
    private final int maxScreenRows = 15;

    /* Rendering */
    private BufferedImage graphics2DImage;
    private Graphics2D graphics2D;

    /* CONSTRUCTOR */

    public J2DContext() {

        frame = new JFrame();
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Graphics2D graph2D = (Graphics2D) graphics;
                graph2D.drawImage(graphics2DImage, 0, 0, null);
                graph2D.dispose();
            }
        };

        /* Window & panel settings */
        int originalTileSize = 32;
        tileSize = (int) (originalTileSize * scale);

        frame.setSize(maxScreenColumns * tileSize, maxScreenRows * tileSize);

        frame.add(panel);
        frame.setTitle("Advanced Programming");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setFocusable(true);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        panel.setBackground(Color.black);
        panel.setDoubleBuffered(true);
    }

    /* GETTERS */

    public JFrame getFrame() {
        return frame;
    }

    public int getTileSize() {
        return tileSize;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public float getScale() {
        return scale;
    }

    public int getMaxScreenColumns() {
        return maxScreenColumns;
    }

    public int getMaxScreenRows() {
        return maxScreenRows;
    }

    /* METHODS */

    public void loadAssets() {
        /* Creating an image to draw in */
        graphics2DImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        graphics2D = graphics2DImage.createGraphics();
    }

    public void render() {
        panel.repaint();
    }

    public BufferedImage resize(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }
}