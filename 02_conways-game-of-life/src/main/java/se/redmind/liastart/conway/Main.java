package se.redmind.liastart.conway;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws InterruptedException {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 450);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Board board = new Board();
        CellDAO cellDAO = new CellDAO(board);
        Cell[] allCells = cellDAO.getAllCells();

        GameController game = new GameController(board, allCells, gridPane);

        // Loop this in some way.
        while (true) {
            gridPane = game.paintBoard();

            Scene scene = new Scene(gridPane);
            stage.setTitle("Conway's Game of Life");
            stage.setScene(scene);
            stage.show();
        }
    }
}
