package Player;

import Common.Effect;
import Common.Item;

public class Weapon implements Item {

    private int id;
    private String name;
    private int[] dmgRange;

    public Weapon(int id){
        this.id = id;
    }

    public void createMap(){

    }

    public int[] getDmgRange() {
        return this.dmgRange;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int[] getCoordinate() {
        return new int[0];
    }

    @Override
    public Effect getEffect() {
        return null;
    }
}
