package Conways;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CustomBoard {
    Model model;
    boolean[][] gameBoard;
    GraphicsContext gc;
    Button button;

    public CustomBoard(Model model, Stage stage) {
        this.model = model;
        gameBoard = new boolean[model.getBoardWidth()][model.getBoardHeight()];
        button = new Button();
        button.setText("play");
        button.setAlignment(Pos.BOTTOM_CENTER);
        Canvas canvas = new Canvas(model.getScreenWidth(), model.getScreenHeight());
        gc = canvas.getGraphicsContext2D();
        paintBoardEvents(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        Simulator sim = new Simulator(model, gc);
        BorderPane bp = new BorderPane();
        bp.setCenter(canvas);
        bp.setBottom(button);
        Scene scene = new Scene(bp, model.getScreenWidth(), model.getScreenHeight() + 30);
        scene.setRoot(bp);
        stage.setScene(scene);
        stage.centerOnScreen();
        button.setOnAction(event -> {
            stage.setHeight(model.getScreenHeight() + 38);
            removePaintBoardEvents(canvas);
            bp.getChildren().remove(button);
            sim.setGameBoard(gameBoard);
            sim.play();
        });


    }

    public void paintBoardEvents(Canvas canvas) {
        canvas.setOnMouseClicked(this::fillRectAtMouse);
        canvas.setOnMouseDragged(this::fillRectAtMouse);
    }

    public void removePaintBoardEvents(Canvas canvas) {
        canvas.setOnMouseClicked(null);
        canvas.setOnMouseDragged(null);
    }

    public void fillRectAtMouse(MouseEvent event) {

        int x = (int) Math.round(event.getX()) / model.getCellSize();
        int y = (int) Math.round(event.getY()) / model.getCellSize();
        if (x >= 0 && y >= 0 && x < model.getBoardWidth() && y < model.getBoardHeight()) {

            gameBoard[x][y] = true;
        }
        gc.fillRect(x * model.getCellSize(), y * model.getCellSize(), model.getCellSize(), model.getCellSize());
    }
}
