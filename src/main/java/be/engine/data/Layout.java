package be.engine.data;

public class Layout {

    // FIELDS //

    private String file;
    private String background;
    private String tileset;
    private int width;
    private int height;
    private StartingPosition startingPosition;

    // CONSTRUCTOR //

    public Layout() {
    }

    // GETTERS & SETTERS //

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getTileset() {
        return tileset;
    }

    public void setTileset(String tileset) {
        this.tileset = tileset;
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

    // CLASS //

    public static class StartingPosition {

        // FIELDS //

        public int x;
        public int y;

        // CONSTRUCTOR //

        public StartingPosition() {
        }
    }

}
