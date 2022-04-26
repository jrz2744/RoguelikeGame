package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class Run extends Application {

    private Stage stage;

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();

        // set weapon properties
        p.setProperty("1", "0-50");
        p.store(new FileWriter("weapons.properties"), "Weapon Properties");


        // set effect properties
        p.setProperty("1", "defenseBuff");
        p.store(new FileWriter("effects.properties"), "Effect Properties");

        Application.launch(args[0]);
    }

    public void createLevel(List<String> filename){
        try (BufferedReader in = new BufferedReader(new FileReader(filename.get(0)))){
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null){
                sb.append(line).append(".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        createLevel(getParameters().getRaw());
        this.stage.show();
        this.stage.sizeToScene();
    }
}
