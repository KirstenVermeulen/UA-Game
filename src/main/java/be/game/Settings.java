package be.util;

import be.engine.input.Input;
import be.engine.input.KeyboardMouseInput;

public class Settings {

    /* WINDOW */
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final String SCREEN_TITLE = "Geometry Dash";

    /* INPUT */
    public static final Input input = KeyboardMouseInput.getInstance();

    /* LEVELS */
    public static final String LEVEL_CONFIG = "src/main/resources/levels/levelsConfig.json";

    /* PLAYER */
    public static final String PLAYER_NAME = "Ewan";

}
