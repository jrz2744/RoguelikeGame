package AI;

import Common.Actions;
import Common.Coordinates;
import Common.Item;
import Player.Inventory;

public class Enemy implements Actions {

    private Inventory inventory;
    private String name;
    private int health;
    private Coordinates location;

    public Enemy(String name, int health, Coordinates location, Item[] items){
        this.name = name;
        this.health = health;
        this.location = location;
        if (items != null){
            for (Item i : items){
                /** Do Something with inventory **/
            }
        }
    }

    @Override
    public void takeDmg(int damage) {
        this.health -= damage;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
