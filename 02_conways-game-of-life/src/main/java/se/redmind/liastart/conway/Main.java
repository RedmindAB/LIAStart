package se.redmind.liastart.conway;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    /*
    Any live cell with fewer than two live neighbours dies
    Any live cell with two or three live neighbours lives on
    Any live cell with more than three live neighbours die
    Any deal cell with exactly three live neighbours becomes alive
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 450);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        Board board = new Board();
        CellDAO cellDAO = new CellDAO(board);

        GameController game = new GameController(board, cellDAO);
        game.paintBoard(gridPane);

        Scene scene = new Scene(gridPane);
        stage.setTitle("Conway's Game of Life");
        stage.setScene(scene);
        stage.show();
    }
}
