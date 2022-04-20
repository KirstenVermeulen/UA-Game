package be.engine;

public class Layout {

    /* FIELDS */

    private String file;
    private int width;
    private int height;
    private StartingPosition startingPosition;

    /* CONSTRUCTOR */

    public Layout() {
    }

    public Layout(String file, int width, int height, StartingPosition startingPosition) {
        this.file = file;
        this.width = width;
        this.height = height;
        this.startingPosition = startingPosition;
    }

    /* GETTERS & SETTERS */

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public StartingPosition getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(StartingPosition startingPosition) {
        this.startingPosition = startingPosition;
    }

    /* CLASS */

    public static class StartingPosition {

        /* FIELDS */

        public int x;
        public int y;

        /* CONSTRUCTOR */

        public StartingPosition() {
        }
    }

}
