package be.engine.ecs.entities;

import be.engine.graphics.Drawable;

public abstract class AbstractEntity implements Drawable {

    public enum State {IDLE, WALK, RUN, JUMP, CLIMB, ATTACK1, ATTACK2, ATTACK3, HURT, DEATH}

}
