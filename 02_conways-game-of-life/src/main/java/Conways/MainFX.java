package Conways;

import Conways.Controllers.StartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class MainFX extends Application {

    GraphicsContext gc;
    Stage stage;
    Scene scene;
    Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void start(Stage stage) throws Exception {
        this.model = new Model();
        this.stage = stage;

        scene = new Scene(startScreenLoader().load());

        stage.setScene(scene);
        stage.show();
    }

    public FXMLLoader startScreenLoader() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen.fxml"));
        StartScreenController ssc = new StartScreenController(model);
        loader.setController(ssc);
        return loader;
    }


//    public void paintBoard(Canvas canvas, GraphicsContext gc) {
//        canvas.setOnMouseClicked(this::fillRectAtMouse);
//        canvas.setOnMouseDragged(this::fillRectAtMouse);
//    }

//    public void fillRectAtMouse(MouseEvent event) {
//        int x = (int) Math.round(event.getX()) / cellSize * cellSize;
//        int y = (int) Math.round(event.getY()) / cellSize * cellSize;
//        gc.fillRect(x, y, cellSize, cellSize);
//    }


    public static void main(String[] args) {
        launch(args);
    }


}