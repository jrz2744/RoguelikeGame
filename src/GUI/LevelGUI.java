package GUI;

import Levels.LevelSize;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LevelGUI {

    private Stage stage = new Stage();
    private LevelSize levelSize;

    private final Image START = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Grey.png")), 128, 128, false, false);
    private final Image PLAYER = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Player.png")), 128, 128, false, false);
    private final Image EXIT = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Red.png")), 128, 128, false, false);
    private final Image EMPTY = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Green.png")), 128, 128, false, false);

    public LevelGUI(int[][] args){
        this.levelSize = new LevelSize(args[0][0], args[0][1]);
        GridPane grid = new GridPane();
        for (int x = 0; x < levelSize.getXSize(); x++) {
            for (int y = 0; y < levelSize.getYSize(); y++) {
                grid.add(new ImageView(EMPTY), y, x);
            }
        }
        grid.add(new ImageView(START), args[1][1], args[1][0]);
        grid.add(new ImageView(PLAYER), args[1][1], args[1][0]);
        grid.add(new ImageView(EXIT), args[2][1], args[2][0]);
        ///
        grid.setGridLinesVisible(true);
        ///

        Scene scene = new Scene(grid);


        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W -> System.out.println("W key was pressed");
                case A -> System.out.println("A key was pressed");
                case S -> System.out.println("S key was pressed");
                case D -> System.out.println("D key was pressed");
            }
        });


        this.stage.setScene(scene);
    }

    public Stage getStage(){
        return this.stage;
    }
}
