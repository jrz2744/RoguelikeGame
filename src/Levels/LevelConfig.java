package Levels;

import AI.Enemy;
import Common.Coordinates;

import java.util.ArrayList;

public class LevelConfig {

    private LevelSize size;
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public LevelConfig(int xSize, int ySize, int enemyCount){
        this.size = new LevelSize(xSize, ySize);
        for (int i=0; i<enemyCount; i++){
            this.enemies.add(new Enemy("NewEnemy", 100, new Coordinates(0, 0), null));
        }
    }
}
