package be.graphics.logic;

import be.engine.data.Tile;
import be.engine.data.Layout;
import be.engine.graphics.AbstractTileManager;
import be.util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

public class J2DTileManager extends AbstractTileManager {

    /* FIELDS */

    private final J2DContext context;
    private BufferedImage background;

    /* CONSTRUCTOR */

    public J2DTileManager(J2DContext context) {
        super(new HashMap<>());
        this.context = context;
    }

    /* METHODS */


    @Override
    public int[][] loadMap(Layout layout) {
        try {

            Set<String> uniqueTiles = new HashSet<>();

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

                uniqueTiles.addAll(List.of(tileNumbers));

                while (column < layout.getWidth()) {
                    mapTileNumbers[column][row] = Integer.parseInt(tileNumbers[column]);
                    column++;
                }

                column = 0;
                row++;
            }

            bufferedReader.close();

            /* Load unique tiles */
            loadTiles(uniqueTiles);

            return mapTileNumbers;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void loadTiles(Set<String> tileNumbers) {
        try {
            clearTiles();

            /* Read and scale background image (GREEN ZONE) */
            //float scale = 1.334f;

            //background = ImageIO.read(new File("src/main/resources/backgrounds/green_zone/Background.png"));
           //background = context.resize(background, (int) (background.getWidth() * scale), (int) (background.getHeight() * scale));

            /* Read tile images (GREEN ZONE) */
            int tempTileNumber;

            for (String tileNumber : tileNumbers) {

                String path = String.format("%stile_%s.png", Constants.GREENZONE_TILES, tileNumber);

                tempTileNumber = Integer.parseInt(tileNumber);

                if (tempTileNumber <= 72 && tempTileNumber > 0) {
                    addTile(tempTileNumber, new Tile(ImageIO.read(new File(path)), true));
                } else {
                    addTile(tempTileNumber, new Tile(ImageIO.read(new File(path)), false));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBackground() {

    }

    @Override
    public void draw(Layout layout, int[][] mapLayout) {

        /* Background */


        /* Tiles */
        HashMap<Integer, Tile> tiles = getTiles();
        Graphics2D g2 = context.getG2();

        for (int column = 0; column < layout.getWidth(); column++) {
            for (int row = 0; row < layout.getHeight(); row++) {
                g2.drawImage(tiles.get(mapLayout[column][row]).getImage(), (column * Constants.TILESIZE), (row * Constants.TILESIZE), Constants.TILESIZE, Constants.TILESIZE, null);
            }
        }
    }


}
