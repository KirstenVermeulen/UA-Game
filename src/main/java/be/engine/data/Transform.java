package be.engine.data;

public class Transform {

    /* FIELDS */

    private Vector2 position;
    private Vector2 scale;
    private Vector2 rotation;

    /* CONSTRUCTOR */

    public Transform(Vector2 position){
        this.position = position;
    }

    /* GETTERS & SETTERS */

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getScale() {
        return scale;
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public Vector2 getRotation() {
        return rotation;
    }

    public void setRotation(Vector2 rotation) {
        this.rotation = rotation;
    }

    /* METHODS */

    @Override
    public String toString() {
        return "Position (" + position.getX() + ", " + position.getY() + ")";
    }
}
