package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.Properties;

public class Run extends Application {

    private Stage stage;

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        p.setProperty("1", "0-50");
        p.store(new FileWriter("myFile.properties"), "Weapon Properties");

        Application.launch(args[0]);
    }

    public void createLevel(){

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        createLevel();
w        this.stage.show();
        this.stage.sizeToScene();
    }
}
