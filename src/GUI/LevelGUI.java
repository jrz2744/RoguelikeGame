package GUI;

import Levels.LevelSize;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LevelGUI {

    private Stage stage = new Stage();
    private LevelSize levelSize;

    private final Image EMPTY = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Green.png")), 128, 128, false, false);

    public LevelGUI(int[][] args){
        this.levelSize = new LevelSize(args[0][0], args[0][1]);
        GridPane grid = new GridPane();
        for (int x = 0; x < levelSize.getXSize(); x++){
            for (int y = 0; y < levelSize.getYSize(); y++){
                grid.add(new ImageView(EMPTY), x, y);
            }
        }
        this.stage.setScene(new Scene(grid));
    }

    public Stage getStage(){
        return this.stage;
    }
}
