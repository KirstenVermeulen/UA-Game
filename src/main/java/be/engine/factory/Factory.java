package be.engine.factory;

import be.datastructures.EnemyStats;
import be.engine.entity.AbstractEnemy;
import be.engine.entity.AbstractPlayer;
import be.engine.graphics.J2DTileManager;
import be.engine.input.Input;

public abstract class Factory {

    public abstract Input createInput();
    public abstract J2DTileManager createTileManager();

    public abstract AbstractPlayer createPlayer();
    public abstract AbstractEnemy createEnemy(EnemyStats enemyStats);

    public abstract void render();
}
