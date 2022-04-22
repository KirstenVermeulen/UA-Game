package be.engine.ecs.entities;

import be.engine.data.EnemyStats;
import be.engine.ecs.components.Movement;
import be.engine.ecs.components.Pathfinding;
import be.engine.ecs.components.Sound;
import be.engine.graphics.Drawable;

public abstract class AbstractEnemy extends AbstractEntity {

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

}
