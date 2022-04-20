package be.engine.system;

import be.engine.component.Movable;
import be.engine.graphics.Tile;

import java.util.LinkedList;
import java.util.List;

public class Move {

    public List<Movable> update(List<Movable> components, LinkedList<Tile> tiles) {

        for (Movable movable : components)
        {
            /* Get the current position */
            float[] newPosition = movable.getLevelPosition();

            /* Add velocity */
            newPosition[0] += movable.getVelocity()[0];
            newPosition[1] += movable.getVelocity()[1];

            /* Add gravity or jump force */
            if (movable.getIsJumping()) {
                if (movable.getJumpTimer() <= 10) {
                    newPosition[1] -= movable.getJumpForce();
                    movable.increaseJumpTimer();
                } else {
                    newPosition[1] += movable.getGravity();
                    movable.setIsJumping(false);
                    movable.resetJumpTimer();
                }

            } else {
                newPosition[1] += movable.getGravity();
            }

            /* Collision */
            for (int i = 0; i < tiles.size(); i++){
                // Check for each 'visible tile if the player collides with it (player collision area)
                // if so, set the velocity to 0

                // rectangle.intersects(object.rectangle)
            }


            // Store the new position in the component
            movable.setPosition(newPosition);
        }

        return components;
    }
}
