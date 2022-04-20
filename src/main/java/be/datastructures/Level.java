package be.engine;

import be.engine.entity.AbstractEnemy;

public class Level {

    /* FIELDS */

    private int id;
    private String name;
    private Layout layout;
    private AbstractEnemy[] enemies;
    private int nextLevel;

    /* CONSTRUCTOR */

    public Level() {
    }

    public Level(int id, String name, Layout layout, AbstractEnemy[] enemies, int nextLevel) {
        this.id = id;
        this.name = name;
        this.layout = layout;
        this.enemies = enemies;
        this.nextLevel = nextLevel;
    }

    /* GETTERS & SETTERS */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public AbstractEnemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(AbstractEnemy[] enemies) {
        this.enemies = enemies;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }
}
