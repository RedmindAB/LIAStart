/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conways.Controllers;

import Conways.CustomBoard;
import Conways.Model;
import Conways.Simulator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class OptionsScreenController implements Initializable {

    @FXML
    private Button randomButton;
    @FXML
    private Button paintButton;
    Model model;

    public OptionsScreenController(Model model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        randomButton.setOnAction(event -> {
            //this is a mess
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Canvas canvas = new Canvas(model.getScreenWidth(), model.getScreenHeight());
            GraphicsContext gc = canvas.getGraphicsContext2D();
            BorderPane bp = new BorderPane();
            bp.setCenter(canvas);
            Scene scene = new Scene(bp, model.getScreenWidth(), model.getScreenHeight());
            stage.setScene(scene);
            stage.centerOnScreen();
            scene.setRoot(bp);
            Simulator sim = new Simulator(model, gc);
            sim.randomPlay();
        });
        paintButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            CustomBoard cb = new CustomBoard(model, stage);
        });


    }


}
