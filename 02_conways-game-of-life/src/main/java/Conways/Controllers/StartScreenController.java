/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conways.Controllers;

import Conways.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {

    @FXML
    private TextField cellSizeTextField;
    @FXML
    private TextField boardSizeXTextField;
    @FXML
    private TextField boardSizeYTextField;
    @FXML
    private TextField frameRateTextField;
    @FXML
    private Label screenSizeLabel;
    @FXML
    private Button nextButton;

    private Model model;

    public StartScreenController(Model model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        addSizeListener(cellSizeTextField);
        addSizeListener(boardSizeXTextField);
        addSizeListener(boardSizeYTextField);
        nextButtonListener();

    }

    public void nextButtonListener() {
        nextButton.setOnAction(event -> {
            createModel();
            Scene scene = ((Node) event.getSource()).getScene();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OptionsScreen.fxml"));
            OptionsScreenController osc = new OptionsScreenController(model);
            loader.setController(osc);
            try {
                scene.setRoot(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void createModel() {
        model.setBoardHeight(Integer.parseInt(boardSizeYTextField.getText()));
        model.setBoardWidth(Integer.parseInt(boardSizeXTextField.getText()));
        model.setCellSize(Integer.parseInt(cellSizeTextField.getText()));
        model.setFrameDuration(Integer.parseInt(frameRateTextField.getText()));

    }

    private void addSizeListener(TextField tf) {
        tf.textProperty().addListener(e -> updateScreenLabels());
    }

    private void updateScreenLabels() {
        int sizeX = Integer.parseInt(cellSizeTextField.getText()) * Integer.parseInt(boardSizeXTextField.getText());
        int sizeY = Integer.parseInt(cellSizeTextField.getText()) * Integer.parseInt(boardSizeYTextField.getText());
        screenSizeLabel.setText(sizeX + " * " + sizeY);
    }

}
