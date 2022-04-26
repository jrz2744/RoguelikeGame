package GUI;

import java.io.*;
import java.util.Properties;

import static java.lang.System.out;

public class Run {

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        p.setProperty("1", "0-50");
        p.store(new FileWriter("myFile.properties"), "Weapon Properties");

    }
}
