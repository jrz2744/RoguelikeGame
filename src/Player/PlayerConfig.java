package Player;

import Common.Actions;
import Common.Coordinates;

public class PlayerConfig implements Actions {

    private Inventory inventory;
    private int health = 100;
    private Coordinates location;

    public PlayerConfig() {

    }

    @Override
    public void takeDmg(int damage) {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }
}
