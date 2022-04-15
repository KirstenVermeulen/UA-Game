package game.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class TileManager {

    J2DContext j2dContext;

    BufferedImage background;

    ArrayList<Tile> tiles;
    int[][] mapTileNumbers;

    /* CONSTRUCTOR */

    public TileManager(J2DContext j2dContext) {
        this.j2dContext = j2dContext;
        tiles = new ArrayList<>();

        loadImages();
        loadMap("src/main/resources/levels/map_data/level1Map.txt");
    }

    /* METHODS */

    private void loadImages() {
        try {
            /* Read and scale background image (GREEN ZONE) */
            float scale = 1.334f;

            background = ImageIO.read(new File("src/main/resources/backgrounds/green_zone/Background.png"));
            background = j2dContext.resize(background, (int) (background.getWidth() * scale), (int) (background.getHeight() * scale));

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

            System.out.println(tiles.size());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String map) {
        try {
            FileReader fileReader = new FileReader(new File(map));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int column = 0;
            int row = 0;

            int maxColumns = j2dContext.getMaxScreenColumns();
            int maxRows = j2dContext.getMaxScreenRows();

            mapTileNumbers = new int[maxColumns][maxRows];

            while (column < maxColumns && row < maxRows) {
                String line = bufferedReader.readLine();
                String[] tileNumbers = line.split(" ");

                while (column < maxColumns) {
                    mapTileNumbers[column][row] = Integer.parseInt(tileNumbers[column]);
                    column++;
                }

                column = 0;
                row++;
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawMap() {
        Graphics2D graphics2D = j2dContext.getGraphics2D();

        int x = 0;
        int y = 0;

        int tileSize = j2dContext.getTileSize();
        int maxColumns = j2dContext.getMaxScreenColumns();
        int maxRows = j2dContext.getMaxScreenRows();

        /* Draw background */
        while (x < (tileSize * maxColumns)){
            graphics2D.drawImage(background, x, 0, null);
            x += background.getWidth();
        }

        /* Draw tiles */
        int column = 0;
        int row = 0;
        x = 0;
        y = 0;

        int tileNumber;

        while (column < maxColumns && row < maxRows) {
            tileNumber = mapTileNumbers[column][row];

            graphics2D.drawImage(tiles.get(tileNumber).getImage(), x, y, tileSize, tileSize, null);

            column++;
            x += tileSize;

            if (column == maxColumns) {
                column = 0;
                row++;

                x = 0;
                y += tileSize;
            }
        }
    }
}
