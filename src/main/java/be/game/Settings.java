package be.game;

public class Settings {

    /* WINDOW */
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final String SCREEN_TITLE = "Geometry Dash";

    /* LEVELS */
    public static final String LEVEL_CONFIG = "src/main/resources/levels/levelsConfig.json";

    /* PLAYER */
    public static final String PLAYER_NAME = "Ewan";

    /* SPRITES */
    public static final int ORIGINAL_TILESIZE = 32;
    public static final float SCALE = 1.5f;
    public static final int TILESIZE = (int) (ORIGINAL_TILESIZE * SCALE);


    /* FILES */
    public static final String GREENZONE_TILES = "src/main/resources/tiles/green_zone/";

}
