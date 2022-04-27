package Common;

import AI.Enemy;
import Player.PlayerConfig;

import java.util.LinkedList;
import java.util.List;

public class Model {
    PlayerConfig currentPlayer;
    private final List< Observer< Model, String > > observers =
            new LinkedList<>();
    private GameState gameState;

    public enum GameState { ONGOING, FIGHTING }
    //Enemy[] enemies;


    /* Observer Section */
    public void addObserver( Observer< Model, String > obs ) {
        this.observers.add( obs );
    }

    public void notifyObservers( String message ) {
        for ( Observer< Model, String > obs : this.observers ) {
            obs.update( this, message );
        }
    }

    /* Model Section*/

    public Model(/*, Enemy... enemies*/) {
        //this.enemies = enemies;
    }

    public void newCurrentPlayer() {
        this.currentPlayer = new PlayerConfig();
    }

    public GameState getGameState() {
        return gameState;
    }

    public PlayerConfig getCurrentPlayer() {
        return currentPlayer;
    }


    public void moveRight() {
        int moveResult = this.currentPlayer.getLocation().row() + 1;
        this.currentPlayer.setLocation(new Coordinates(moveResult, this.currentPlayer.getLocation().col()));
    }

    public void moveLeft() {
        int moveResult = this.currentPlayer.getLocation().row() - 1;
        this.currentPlayer.setLocation(new Coordinates(moveResult, this.currentPlayer.getLocation().col()));
    }

    public void moveUp() {
        int moveResult = this.currentPlayer.getLocation().col() + 1;
        this.currentPlayer.setLocation(new Coordinates(this.currentPlayer.getLocation().row(), moveResult));
    }

    public void moveDown() {
        int moveResult = this.currentPlayer.getLocation().col() - 1;
        this.currentPlayer.setLocation(new Coordinates(this.currentPlayer.getLocation().row(), moveResult));
    }
}
