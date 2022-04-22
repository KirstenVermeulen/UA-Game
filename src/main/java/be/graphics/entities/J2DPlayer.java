package be.graphics.entities;

import be.engine.ecs.entities.AbstractPlayer;
import be.engine.graphics.Animation;
import be.util.Constants;
import be.graphics.logic.J2DContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class J2DPlayer extends AbstractPlayer {

    /* FIELDS */

    private final J2DContext context;

    private int animationSpriteNumber;
    private int animationTime;

    /* CONSTRUCTOR */

    public J2DPlayer(String name, J2DContext context) {
        super(name);
        this.context = context;

        loadSprites(Constants.WOODCUTTER, Constants.WOODCUTTER_ANIMATION_DURATION);
        animationSpriteNumber = 0;
        animationTime = 0;
    }

    /* METHODS */

    @Override
    public void loadSprites(String[] skin, int[] animationDuration) {

        clearSprites();

        try {

            if (skin.length == animationDuration.length) {

                int count = 0;

                File file;
                String filename;
                String state;

                BufferedImage image;
                int originalWidth;
                int originalHeight;
                int newWidth;
                int newHeight;

                int numberOfSubsprites;

                for (String path : skin) {

                    /* Read file */
                    file = new File(path);
                    filename = file.getName().toUpperCase();
                    state = filename.substring(0, filename.lastIndexOf("."));

                    /* Resize */
                    image = ImageIO.read(file);
                    originalWidth = image.getWidth();
                    originalHeight = image.getHeight();

                    newWidth = (int) (originalWidth * Constants.SCALE);
                    newHeight = (int) (originalHeight * Constants.SCALE);

                    image = context.resize(image, newWidth, newHeight);

                    /* Make subsprites */
                    int x = 0;
                    numberOfSubsprites = newWidth / newHeight;

                    BufferedImage[] subsprites = new BufferedImage[numberOfSubsprites];

                    for (int i = 0; i < numberOfSubsprites; i++){
                        subsprites[i] = image.getSubimage(x, 0, newHeight, newHeight);
                        x += newHeight;
                    }

                    /* Create animation */
                    switch (state) {
                        case "IDLE" -> addSprite(State.IDLE, new Animation(animationDuration[count], subsprites));
                        case "WALK" -> addSprite(State.WALK, new Animation(animationDuration[count], subsprites));
                        case "RUN" -> addSprite(State.RUN, new Animation(animationDuration[count], subsprites));
                        case "JUMP" -> addSprite(State.JUMP, new Animation(animationDuration[count], subsprites));
                        case "CLIMB" -> addSprite(State.CLIMB, new Animation(animationDuration[count], subsprites));
                        case "ATTACK1" -> addSprite(State.ATTACK1, new Animation(animationDuration[count], subsprites));
                        case "ATTACK2" -> addSprite(State.ATTACK2, new Animation(animationDuration[count], subsprites));
                        case "ATTACK3" -> addSprite(State.ATTACK3, new Animation(animationDuration[count], subsprites));
                        case "HURT" -> addSprite(State.HURT, new Animation(animationDuration[count], subsprites));
                        case "DEATH" -> addSprite(State.DEATH, new Animation(animationDuration[count], subsprites));
                        default -> {
                        }
                    }

                    count++;
                }
            } else {
                throw new Exception("Given skins and animations are not compatible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        Graphics2D g2 = context.getG2();

        Animation sprites;
        BufferedImage image;

        switch (getCurrentState()) {
            case WALK -> sprites = getSprites(State.WALK);
            case RUN -> sprites = getSprites(State.RUN);
            case JUMP -> sprites = getSprites(State.JUMP);
            case CLIMB -> sprites = getSprites(State.CLIMB);
            case ATTACK1 -> sprites = getSprites(State.ATTACK1);
            case ATTACK2 -> sprites = getSprites(State.ATTACK2);
            case ATTACK3 -> sprites = getSprites(State.ATTACK3);
            case HURT -> sprites = getSprites(State.HURT);
            case DEATH -> sprites = getSprites(State.DEATH);
            default -> sprites = getSprites(State.IDLE);
        }

        if (getCurrentState() == getPreviousState()) {
            if (animationTime > sprites.getDuration()) {
                animationSpriteNumber++;
                animationTime = 0;

                if (animationSpriteNumber >= sprites.getSprites().length) {
                    animationSpriteNumber = 0;
                }
            } else {
                animationTime++;
            }
        } else {
            animationSpriteNumber = 0;
            animationTime = 0;
            setPreviousState(getCurrentState());
        }

        image = sprites.getSprites()[animationSpriteNumber];
        g2.drawImage(image, 100,100, image.getWidth(), image.getHeight(), null);
    }

}
