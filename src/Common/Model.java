package Common;

import AI.Enemy;
import GUI.LevelGUI;
import Levels.LevelConfig;
import Player.PlayerConfig;

import java.util.LinkedList;
import java.util.List;

public class Model {
    PlayerConfig currentPlayer;
    LevelConfig currentLevel;
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

    public void setCurrentLevel(LevelConfig currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void moveRight() {
        if (this.currentLevel.getSize().getXSize() - 1 != this.currentPlayer.getLocation().col()) {
            int moveResult = this.currentPlayer.getLocation().col() + 1;
            this.currentPlayer.setLocation(new Coordinates(this.currentPlayer.getLocation().row(), moveResult));
            notifyObservers("Right");
        }
    }

    public void moveLeft() {
        if (this.currentPlayer.getLocation().col() > 0) {
            int moveResult = this.currentPlayer.getLocation().col() - 1;
            this.currentPlayer.setLocation(new Coordinates(this.currentPlayer.getLocation().row(), moveResult));
            notifyObservers("Left");
        }
    }

    public void moveUp() {
        if (this.currentPlayer.getLocation().row() > 0) {
            int moveResult = this.currentPlayer.getLocation().row() - 1;
            this.currentPlayer.setLocation(new Coordinates(moveResult, this.currentPlayer.getLocation().col()));
            notifyObservers("Up");
        }
    }

    public void moveDown() {
        if (this.currentLevel.getSize().getYSize() - 1 != this.currentPlayer.getLocation().row()) {
            int moveResult = this.currentPlayer.getLocation().row() + 1;
            this.currentPlayer.setLocation(new Coordinates(moveResult, this.currentPlayer.getLocation().col()));
            notifyObservers("Down");
        }
    }
}
