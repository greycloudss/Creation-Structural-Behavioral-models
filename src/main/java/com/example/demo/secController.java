package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class secController {
    Stage stage;

    @FXML
    private Button exitButton;

    @FXML
    private TilePane pane;

    private Bridge bridge;


    @FXML
    public void initialize() {
        exitButton.setOnAction(_ -> closeWindow());

        if (pane != null) {
            if (bridge != null) {
                bridge.draw(pane);
            }
        }
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;

       //try {
       //    lab = new Label(bridge.name);
       //} catch (Exception _) {}

        if (pane != null) {
            bridge.draw(pane);
        }
    }

    private void closeWindow() {
        stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}