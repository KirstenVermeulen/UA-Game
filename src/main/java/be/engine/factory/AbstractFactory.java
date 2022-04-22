package be.engine.factory;

import be.engine.data.EnemyStats;
import be.engine.ecs.entities.AbstractEnemy;
import be.engine.ecs.entities.AbstractPlayer;
import be.graphics.logic.J2DTileManager;
import be.engine.input.Input;

public abstract class AbstractFactory {

    public abstract Input createInput();
    public abstract J2DTileManager createTileManager();

    public abstract AbstractPlayer createPlayer();
    public abstract AbstractEnemy createEnemy(EnemyStats enemyStats);

    public abstract void render();
}
