package GUI;

import Common.Model;
import Common.Observer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Run extends Application implements Observer<Model, String > {

    private Stage stage;

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

    public void createLevel(String filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename))){
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null){
                sb.append(line).append(".");
            }
            String[] args = sb.toString().split("\\.");
            this.stage = new LevelGUI(args).getStage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        createLevel(getParameters().getRaw().get(0));
        this.stage = stage;
        this.stage.show();
        this.stage.sizeToScene();
    }
}
