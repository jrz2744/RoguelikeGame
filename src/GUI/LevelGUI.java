package GUI;

import Common.Model;
import Levels.LevelConfig;
import Levels.LevelSize;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LevelGUI {

    private Scene scene;
    private LevelSize levelSize;
    private GridPane grid;
    private LevelConfig level;

    private final Image START = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Grey.png")), 128, 128, false, false);
    private final Image PLAYER = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/32BIT/Swim.png")), 128, 128, false, false);
    private final Image EXIT = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Red.png")), 128, 128, false, false);
    private final Image EMPTY = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Images/Green.png")), 128, 128, false, false);

    public LevelGUI(int[][] args){
        this.levelSize = new LevelSize(args[0][0], args[0][1]);
        this.grid = new GridPane();
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

        this.level = new LevelConfig(this.levelSize.getXSize(), this.levelSize.getYSize(), 2);

        this.scene = new Scene(grid);
    }

    public void updateLevelGUI(Model model) {
        grid.add(new ImageView(EMPTY), model.getCurrentPlayer().getPrevLocation().col(),
                model.getCurrentPlayer().getPrevLocation().row());
        grid.add(new ImageView(PLAYER), model.getCurrentPlayer().getLocation().col(),
                model.getCurrentPlayer().getLocation().row());
    }

    public Scene getScene(){
        return this.scene;
    }

    public LevelConfig getLevel() {
        return level;
    }
}

