package ua.game.graphics;

import javax.swing.*;
import java.awt.*;

public class J2DPanel extends JPanel {

    /* SCREEN SETTINGS */

    private final int originalTileSize; // Default size of an asset
    private final int scale; // The factor to which the original assets will be scaled

    private final int maxScreenColumns;
    private final int maxScreenRows;

    private final int screenWidth;
    private final int screenHeight;

    public J2DPanel(int originalTileSize, int scale, int maxScreenColumns, int maxScreenRows) {
        this.originalTileSize = originalTileSize;
        this.scale = scale;
        int tileSize = originalTileSize * scale;

        this.maxScreenColumns = maxScreenColumns;
        this.maxScreenRows = maxScreenRows;

        this.screenWidth = maxScreenColumns * tileSize;
        this.screenHeight = maxScreenRows * tileSize;

        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    /* GETTERS & SETTERS */

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    /* METHODS */

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
    }

}
