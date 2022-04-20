package be.engine;

import be.datastructures.Level;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LevelManager {

    /* FIELDS */

    private final HashMap<Integer, Level> levels;

    /* CONSTRUCTOR */

    public LevelManager() {
        levels = new HashMap<>();
    }

    /* METHODS */

    public void init(String config) {

        try {
            String json = null;
            Scanner scanner = new Scanner(new File(config));

            while (scanner.hasNextLine()) {
                json = scanner.nextLine();
            }

            if (json != null) {
                ObjectMapper mapper = new ObjectMapper();

                for (Level l : mapper.readValue(json, Level[].class)) {
                    levels.put(l.getId(), l);
                }
            } else {
                System.out.println("JSON file is empty!");
            }

        } catch (FileNotFoundException | JsonProcessingException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Level getLevel(int id) {
        return levels.get(id);
    }
}
