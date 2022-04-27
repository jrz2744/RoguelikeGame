package Player;

import Common.Actions;

public class PlayerConfig implements Actions {

    private Inventory inventory;
    private int health = 100;

    public PlayerConfig() {

    }

    @Override
    public void takeDmg(int damage) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
