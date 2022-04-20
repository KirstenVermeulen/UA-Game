package be.datastructures;

public class Level {

    /* FIELDS */

    private int id;
    private String name;
    private Layout layout;
    private EnemyStats[] enemyStats;
    private int nextLevel;

    /* CONSTRUCTOR */

    public Level() {
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

    public EnemyStats[] getEnemyStats() {
        return enemyStats;
    }

    public void setEnemyStats(EnemyStats[] enemies) {
        this.enemyStats = enemies;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }
}
