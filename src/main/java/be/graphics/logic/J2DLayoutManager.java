package be.graphics.logic;

import be.engine.data.Tile;
import be.engine.data.Layout;
import be.engine.graphics.AbstractLayoutManager;
import be.util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

public class J2DLayoutManager extends AbstractLayoutManager {

    // FIELDS //

    private final J2DContext context;
    private BufferedImage background;

    // CONSTRUCTOR //

    public J2DLayoutManager(J2DContext context) {
        super(new HashMap<>());
        this.context = context;
    }

    // METHODS //

    @Override
    public int[][] loadMap(Layout layout) {
        try {

            Set<String> uniqueTiles = new HashSet<>();

            // File IO //
            FileReader fileReader = new FileReader(new File(layout.getFile()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Construct layout //
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

            // Load background and tiles //
            loadBackground(layout.getBackground());
            loadTiles(uniqueTiles, layout.getTileset());

            return mapTileNumbers;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void loadBackground(String backgroundPath) {
        try {
            background = ImageIO.read(new File(backgroundPath));

            int backgroundRows = 9;
            float scale = (float) (Constants.TILESIZE * backgroundRows) / background.getHeight();

            background = context.resize(background, (int) (background.getWidth() * scale), (int) (background.getHeight() * scale));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTiles(Set<String> tileNumbers, String tilesetPath) {
        BufferedImage image;

        try {
            clearTiles();

            // Read tile images (GREEN ZONE) //
            int tempTileNumber;

            for (String tileNumber : tileNumbers) {

                String path = String.format("%stile_%s.png", tilesetPath, tileNumber);
                tempTileNumber = Integer.parseInt(tileNumber);

                image = context.resize(ImageIO.read(new File(path)), Constants.TILESIZE, Constants.TILESIZE);

                if (tempTileNumber <= 72 && tempTileNumber > 0) {
                    addTile(tempTileNumber, new Tile(image, true));
                } else {
                    addTile(tempTileNumber, new Tile(image, false));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void draw(Layout layout, int[][] mapLayout) {

        Graphics2D g2 = context.getG2();

        // Background //
        int x = 0;
        int width = background.getWidth();
        int height = background.getHeight();

        for (int i = 0; i < 2; i++) {
            // TODO: Shift background when camera moves
            g2.drawImage(background, x, 0, width, height, null);
            x += width;
        }

        // Tiles //
        HashMap<Integer, Tile> tiles = getTiles();

        for (int column = 0; column < layout.getWidth(); column++) {
            for (int row = 0; row < layout.getHeight(); row++) {
                g2.drawImage(tiles.get(mapLayout[column][row]).getImage(), (column * Constants.TILESIZE), (row * Constants.TILESIZE), Constants.TILESIZE, Constants.TILESIZE, null);
            }
        }
    }


}
