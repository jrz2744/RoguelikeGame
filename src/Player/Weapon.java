package Player;

import Common.Coordinates;
import Common.Effect;
import Common.Item;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import static java.lang.System.getenv;
import static java.lang.System.out;

public class Weapon extends Effect implements Item {

    private int id;
    private String name;
    private int[] dmgRange;
    private Coordinates position;
    private Effect effect;


    /**
     * Constructor for the Weapon given id
     * @param id id for weapon in properties file
     */
    public Weapon(int id){
        // the id of the desired weapon
        this.id = id;

        // attempt to read the weapon properties file
        Properties p = new Properties();
        try {
            p.load(new FileReader("myFile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Debug line to see what the properties file is holding
        //p.list(new PrintStream(out, true));

        // read properties file and set damage range depending on the id of the weapon
        String[] tempRange = p.getProperty(String.valueOf(id)).split("-");
        this.dmgRange = new int[tempRange.length];
        for (int i = 0; i < tempRange.length; i++) {
            this.dmgRange[i] = Integer.parseInt(tempRange[i]);
        }
    }

    /**
     *
     */
    public void createMap(){
        // TODO
    }

    /**
     * getter for damage range
     * @return int array of 2 values, lower damage value and upper damage value
     */
    public int[] getDmgRange() {
        return this.dmgRange;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public Coordinates getCoordinate() {
        return this.position;
    }

    @Override
    public Effect getEffect() {
        return this.effect;
    }
}
