package be.util;

public class Constants {

    // --- WINDOW --- //
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;
    public static final String SCREEN_TITLE = "Woodlands";

    // --- PLAYER --- //
    public static final String PLAYER_NAME = "Ewan";
    public static final int WALKING_SPEED = 5;
    public static final int RUNNING_SPEED = 8;

    // --- SPRITES --- //
    public static final int ORIGINAL_TILESIZE = 32;
    public static final float SCALE = 1.5f;
    public static final int TILESIZE = (int) (ORIGINAL_TILESIZE * SCALE);


    // --- FILES --- //
    private static final String BASE_PATH = "src/main/resources/";

    // Levels //
    public static final String LEVEL_CONFIG = BASE_PATH + "levels/levelsConfig.json";

    // Player - Woodcutter //
    private static final String WOODCUTTER_IDLE = BASE_PATH + "characters/players/woodcutter/idle.png";
    private static final String WOODCUTTER_WALK = BASE_PATH + "characters/players/woodcutter/walk.png";
    private static final String WOODCUTTER_RUN = BASE_PATH + "characters/players/woodcutter/run.png";
    private static final String WOODCUTTER_JUMP = BASE_PATH + "characters/players/woodcutter/jump.png";
    private static final String WOODCUTTER_CLIMB = BASE_PATH + "characters/players/woodcutter/climb.png";
    private static final String WOODCUTTER_ATTACK1 = BASE_PATH + "characters/players/woodcutter/attack1.png";
    private static final String WOODCUTTER_ATTACK2 = BASE_PATH + "characters/players/woodcutter/attack2.png";
    private static final String WOODCUTTER_ATTACK3 = BASE_PATH + "characters/players/woodcutter/attack3.png";
    private static final String WOODCUTTER_HURT = BASE_PATH + "characters/players/woodcutter/hurt.png";
    private static final String WOODCUTTER_DEATH = BASE_PATH + "characters/players/woodcutter/death.png";

    public static final String[] WOODCUTTER = new String[] {WOODCUTTER_IDLE, WOODCUTTER_WALK, WOODCUTTER_RUN,
            WOODCUTTER_JUMP, WOODCUTTER_CLIMB, WOODCUTTER_ATTACK1, WOODCUTTER_ATTACK2, WOODCUTTER_ATTACK3,
            WOODCUTTER_HURT, WOODCUTTER_DEATH};
    public static final int[] WOODCUTTER_ANIMATION_DURATION = new int[] {12,10,10,10,10,10,10,10,10,10};

}
