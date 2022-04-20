package ua.game.entities;

import ua.game.components.Movable;
import ua.game.graphics.Animation;
import ua.game.graphics.J2DContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class J2DPlayer extends AbstractPlayer {

    /* FIELDS */

    private final J2DContext j2dContext;

    private int animationCounter;
    private int currentSprite;

    private HashMap<State, Animation> playerSprites;

    /* CONSTRUCTOR */

    public J2DPlayer(J2DContext j2dContext) {
        super(new Movable());
        this.j2dContext = j2dContext;

        /* Graphics */
        currentState = State.IDLE;
        previousState = State.IDLE;

        animationCounter = 0;
        currentSprite = 0;

        loadSprites();

        /* Properties */
        setScreenX(200);

        isColliding = false;
    }

    /* METHODS */

    private void loadSprites() {

        /* Read the images */
        try {

            BufferedImage[] sprites = new BufferedImage[] {
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_idle.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_walk.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_run.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_jump.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_climb.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_attack1.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_hurt.png")),
                    ImageIO.read(new File("src/resource/players/woodcutter/Woodcutter_death.png"))
            };

            /* Resize the images and cut them in subimages */
            ArrayList<BufferedImage[]> allSubSprites = new ArrayList<>();
            float scale = j2dContext.getScale();
            int spriteSize = (int) (48 * scale);

            int number_of_images;
            int x;

            for (int i = 0; i <= sprites.length - 1; i++) {
                sprites[i] = j2dContext.resize(sprites[i], (int) (sprites[i].getWidth() * scale), (int) (sprites[i].getHeight() * scale));

                number_of_images = sprites[i].getWidth() / spriteSize;
                BufferedImage[] subSprites = new BufferedImage[number_of_images];

                x = 0;

                for (int j = 0; j <= number_of_images - 1; j++){
                    subSprites[j] = sprites[i].getSubimage(x, 0, spriteSize, spriteSize);
                    x += spriteSize;
                }

                allSubSprites.add(subSprites);
            }

            /* Set the collision area for the sprites */
            collisionArea = new Rectangle(0,0, spriteSize, spriteSize);

            /* Store the sprites by state of the player */
            playerSprites = new HashMap<>();

            /* Save all the sprites with their respective state as key (+ its duration) */
            playerSprites.put(State.IDLE, new Animation(12, allSubSprites.get(0)));
            playerSprites.put(State.WALK, new Animation(7, allSubSprites.get(1)));
            playerSprites.put(State.RUN, new Animation(5, allSubSprites.get(2)));
            playerSprites.put(State.JUMP, new Animation(5, allSubSprites.get(3)));
            playerSprites.put(State.CLIMB, new Animation(5, allSubSprites.get(4)));
            playerSprites.put(State.ATTACK, new Animation(5, allSubSprites.get(5)));
            playerSprites.put(State.HURT, new Animation(5, allSubSprites.get(6)));
            playerSprites.put(State.DEATH, new Animation(5, allSubSprites.get(7)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visualise() {
        /* Get the image to draw on */
        Graphics2D graphics2D = j2dContext.getGraphics2D();

        /* Properties for where to draw the image */
        int positionY = (int) movable.getLevelY();

        /* Draw the image */
        BufferedImage[] sprites;
        int duration;

        switch (currentState) {
            case WALK -> {
                sprites = playerSprites.get(State.WALK).getSprites();
                duration = playerSprites.get(State.WALK).getDuration();
            }
            case RUN -> {
                sprites = playerSprites.get(State.RUN).getSprites();
                duration = playerSprites.get(State.RUN).getDuration();
            }
            case JUMP -> {
                sprites = playerSprites.get(State.JUMP).getSprites();
                duration = playerSprites.get(State.JUMP).getDuration();
            }
            case CLIMB -> {
                sprites = playerSprites.get(State.CLIMB).getSprites();
                duration = playerSprites.get(State.CLIMB).getDuration();
            }
            case ATTACK -> {
                sprites = playerSprites.get(State.ATTACK).getSprites();
                duration = playerSprites.get(State.ATTACK).getDuration();
            }
            case HURT -> {
                sprites = playerSprites.get(State.HURT).getSprites();
                duration = playerSprites.get(State.HURT).getDuration();
            }
            case DEATH -> {
                sprites = playerSprites.get(State.DEATH).getSprites();
                duration = playerSprites.get(State.DEATH).getDuration();
            }
            default -> {
                sprites = playerSprites.get(State.IDLE).getSprites();
                duration = playerSprites.get(State.IDLE).getDuration();
            }
        }

        if (currentState != previousState){
            currentSprite = 0;
            animationCounter = 0;
            previousState = currentState;
        }

        if (animationCounter == duration) {
            currentSprite++;
            animationCounter = 0;
        }

        if (currentSprite >= sprites.length) {
            currentSprite = 0;
        }

        graphics2D.drawImage(sprites[currentSprite], getScreenX(), positionY, null);

        animationCounter++;
    }
}
