package Player;

import Common.Actions;
import Common.Coordinates;

public class PlayerConfig implements Actions {

    private Inventory inventory;
    private int health = 100;
    private Coordinates prevLocation;
    private Coordinates location = new Coordinates(3,0);

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
        this.prevLocation = this.location;
        this.location = location;
    }

    public Coordinates getPrevLocation() {
        return prevLocation;
    }
}
