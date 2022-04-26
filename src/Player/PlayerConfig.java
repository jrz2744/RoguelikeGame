package Player;

import Common.Actions;

public class PlayerConfig implements Actions {

    private Inventory inventory;
    private int health;

    public PlayerConfig(Inventory inv, int initHealth) {
        this.health = initHealth;
        this.inventory = inv;
    }

    @Override
    public void takeDmg(int damage) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
