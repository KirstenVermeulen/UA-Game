package be;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import be.engine.graphics.TileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelManager {

    Level currentLevel;

    /* CONSTRUCTOR */

    public LevelManager() {
    }

    /* METHODS */

    public void startLevel(TileManager tileManager, String config) {
        currentLevel = loadLevel(config);

        if (currentLevel != null){
            tileManager.loadMap(currentLevel.map.file, new int[] {currentLevel.map.width, currentLevel.map.height});
        }

    }

    private Level loadLevel(String config) {

        try {
            String json = null;
            Scanner scanner = new Scanner(new File(config));

            while (scanner.hasNextLine()) {
                json = scanner.nextLine();
            }

            if (json != null) {
                return new ObjectMapper().readValue(json, Level.class);
            } else {
                System.out.println("Failed to load the level");
                return null;
            }


        } catch (FileNotFoundException | JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
