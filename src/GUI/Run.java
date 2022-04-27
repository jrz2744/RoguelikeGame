package GUI;

import Common.Model;
import Common.Observer;
import Levels.LevelConfig;
import Player.Inventory;
import Player.PlayerConfig;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Run extends Application implements Observer<Model, String > {

    /** The Stage for the javafx GUI*/
    private Stage stage;

    /** The one model one run of the game*/
    private Model model;

    /** has the game started? */
    private Boolean initialized = false;

    /** move */
    private Move action;

    /** */
    private LevelGUI currentLevelGUI;

    private LevelConfig currentLevel;

    private Scene scene;

    public enum Move { UP, DOWN, LEFT, RIGHT }

    @Override
    public void init() {
        this.model = new Model();
        this.model.addObserver(this);
        this.initialized = true;
    }

    @Override
    public void update(Model model, String s) {
        if (!this.initialized) return;

        if (model.getGameState() == Model.GameState.FIGHTING) {
            updateFight();
        } else {
            updateLevel();
        }

    }

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();

        // set weapon properties
        p.setProperty("1", "0-50");
        p.store(new FileWriter("weapons.properties"), "Weapon Properties");


        // set effect properties
        p.setProperty("1", "defenseBuff");
        p.store(new FileWriter("effects.properties"), "Effect Properties");

        Application.launch(args);
    }

    public void createFirstLevel (String filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            String tempLine;
            String[] line;
            int[][] args = new int[(int) Files.lines(Paths.get(filename)).count()][2];

            int lineCount = 0;
            while ((tempLine = in.readLine()) != null){
                line = tempLine.split(" ");
                int posCount = 0;
                for (String value : line) {
                    args[lineCount][posCount] = Integer.parseInt(value);
                    posCount++;
                }
                lineCount++;
            }


            this.currentLevelGUI = new LevelGUI(args);
            this.currentLevel = this.currentLevelGUI.getLevel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void updateLevel() {
        this.currentLevelGUI.updateLevelGUI(this.model);
        System.out.println("updated");
    }

    public void updateFight() {

    }

    public void readKeys() {

        this.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W -> this.model.moveUp();
                case A -> this.model.moveLeft();
                case S -> this.model.moveDown();
                case D -> this.model.moveRight();
            }
        });

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.model.newCurrentPlayer();
        createFirstLevel(getParameters().getRaw().get(0));
        this.scene = this.currentLevelGUI.getScene();
        readKeys();
        this.model.setCurrentLevel(this.currentLevel);
        this.stage.setScene(this.scene);
        this.stage.sizeToScene();
        this.stage.setTitle("RogueLike game");
        this.stage.show();
    }


}
