package ua.game.components;

public class Movable {

    /* FIELDS */

    private float levelX;
    private float levelY;

    private final float gravity;

    private boolean isJumping;
    private final float jumpForce;
    private int jumpTimer;

    private float velocityX;
    private float velocityY;

    /* CONSTRUCTOR */

    public Movable() {
        levelX = 0.0f;
        levelY = 0.0f;

        gravity = 9.807f;

        isJumping = false;
        jumpForce = 5f;
        jumpTimer = 0;

        velocityX = 0.0f;
        velocityY = 0.0f;
    }

    /* GETTERS & SETTERS */

    public float[] getVelocity()
    {
        return new float[] {velocityX, velocityY};
    }

    public void setVelocity(float[] newVelocity)
    {
        assert 2 == newVelocity.length;

        velocityX = newVelocity[0];
        velocityY = newVelocity[1];
    }

    public float[] getLevelPosition()
    {
        return new float[] {levelX, levelY};
    }

    public float getLevelX() {
        return levelX;
    }

    public float getLevelY() {
        return levelY;
    }

    public void setPosition(float[] newPosition)
    {
        assert 2 == newPosition.length;

        levelX = newPosition[0];
        levelY = newPosition[1];
    }

    public float getGravity() {
        return gravity;
    }

    public boolean getIsJumping() {
        return isJumping;
    }

    public void setIsJumping(boolean jumping) {
        isJumping = jumping;
    }

    public float getJumpForce() {
        return jumpForce;
    }

    public int getJumpTimer() {
        return jumpTimer;
    }

    public void increaseJumpTimer() {
        jumpTimer++;
    }

    public void resetJumpTimer() {
        jumpTimer = 0;
    }
}
