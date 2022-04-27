package GUI;

import Common.Model;
import Common.Observer;
import Player.Inventory;
import Player.PlayerConfig;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Run extends Application implements Observer<Model, String > {

    private Stage stage;
    private Model model;

    @Override
    public void init() {
        this.model = new Model();

    }

    @Override
    public void update(Model model, String s) {

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


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.show();
        this.stage.sizeToScene();
    }
}
