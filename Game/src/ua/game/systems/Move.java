package ua.game.systems;

import ua.game.components.Movable;

import java.util.List;

public class Move {

    public List<Movable> update(List<Movable> components) {

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

            // Store the new position in the component
            movable.setPosition(newPosition);
        }

        return components;
    }
}
