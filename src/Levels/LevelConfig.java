package Levels;

import AI.Enemy;

import java.util.ArrayList;

public class LevelConfig {

    private LevelSize size;
    private ArrayList<Enemy> enemies;

    public LevelConfig(int xSize, int ySize, int enemyCount){
        this.size = new LevelSize(xSize, ySize);

    }
}
