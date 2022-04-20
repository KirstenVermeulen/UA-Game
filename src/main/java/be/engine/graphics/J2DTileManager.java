package be.engine.graphics;

import be.engine.Layout;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class TileManager {

    /* FIELDS */

    BufferedImage background;

    ArrayList<Tile> tiles;

    /* CONSTRUCTOR */

    public TileManager() {
        tiles = new ArrayList<>();
    }

    /* METHODS */

    public void init() {
        try {
            /* Read and scale background image (GREEN ZONE) */
            float scale = 1.334f;

            background = ImageIO.read(new File("src/main/resources/backgrounds/green_zone/Background.png"));
           //background = context.resize(background, (int) (background.getWidth() * scale), (int) (background.getHeight() * scale));

            /* Read tile images (GREEN ZONE) */
            String path;
            for (int i = 0; i <= 96; i++) {

                if (i < 10) {
                    path = String.format("src/main/resources/tiles/green_zone/Tile_0%d.png", i);
                } else {
                    path = String.format("src/main/resources/tiles/green_zone/Tile_%d.png", i);
                }

                if (i <= 72 && i > 0) {
                    tiles.add(new Tile(ImageIO.read(new File(path)), true));
                } else {
                    tiles.add(new Tile(ImageIO.read(new File(path)), false));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[][] loadMap(Layout layout) {
        try {

            /* File IO */
            FileReader fileReader = new FileReader(new File(layout.getFile()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            /* Construct layout */
            int column = 0;
            int row = 0;

            int[][] mapTileNumbers = new int[layout.getWidth()][layout.getHeight()];

            while (column < layout.getWidth() && row < layout.getHeight()) {
                String line = bufferedReader.readLine();
                String[] tileNumbers = line.split(" ");

                while (column < layout.getWidth()) {
                    mapTileNumbers[column][row] = Integer.parseInt(tileNumbers[column]);
                    column++;
                }

                column = 0;
                row++;
            }

            bufferedReader.close();

            return mapTileNumbers;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
