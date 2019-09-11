/*
 * Javautveckling 2018
 */
package se.redmind.liastart.gameoflife;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marcus D Jensen
 */
public class GameOfLife extends Application {

    private BorderPane bp;
    private GridPane grid;

    private Board board;
    private ArrayList<Cell> cells;
    private boolean first = true;
    private boolean randomStartingBoard;

    private HBox buttons;
    private Button btnNext, btnReset, btnPlay;

    private int nrOfRows, nrOfColumns, cellSize;

    @Override
    public void start(Stage primaryStage) {
        
        //  Game settings
        nrOfRows = 100;
        nrOfColumns = 200;
        cellSize = 10;
        randomStartingBoard = false;
        
        board = new Board(nrOfColumns, nrOfRows, cells, cellSize, randomStartingBoard);
        grid = board.resetBoard();
        bp = new BorderPane();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), (ActionEvent event) -> {
            board.next(grid);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        btnNext = new Button("Next");
        btnReset = new Button("Reset");
        btnPlay = new Button("Hold to Play!");

        btnNext.setOnMouseClicked((event) -> {
            board.next(grid);
        });

        btnReset.setOnMouseClicked((event) -> {
            grid = board.resetBoard();
            bp.setCenter(grid);
        });

        btnPlay.setOnMousePressed((event) -> {
            if (first) {
                timeline.play();
                first = false;
            }
        });

        btnPlay.setOnMouseReleased((event) -> {
            first = true;
            timeline.stop();
        });

        buttons = new HBox();
        buttons.getChildren().add(btnNext);
        buttons.getChildren().add(btnReset);
        buttons.getChildren().add(btnPlay);

        bp.setCenter(grid);
        bp.setBottom(buttons);

        Scene scene = new Scene(bp);
        primaryStage.setTitle("Conway's Game of Life!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
