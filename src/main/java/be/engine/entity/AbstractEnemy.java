package be.engine.entity;

import be.datastructures.EnemyStats;
import be.engine.component.Movement;
import be.engine.component.Pathfinding;
import be.engine.component.Sound;
import be.engine.graphics.Drawable;

public abstract class AbstractEnemy implements Drawable {

    /* FIELDS */

    private Movement movement;
    private Sound sound;
    private Pathfinding pathfinding;


    /* CONSTRUCTOR */

    public AbstractEnemy(EnemyStats enemyStats) {
        movement = new Movement();
        sound = new Sound();
        pathfinding = new Pathfinding();
    }


    /* METHODS */

    public abstract void draw();

}
