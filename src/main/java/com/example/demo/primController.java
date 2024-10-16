package com.example.demo;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class primController {

    @FXML
    private TextField textField;

    @FXML
    private ColorPicker colourPicker;

    @FXML
    private ComboBox<String> comboBox;



    @FXML
    private void initialize() {
        comboBox.getItems().addAll("Triangle", "Rectangle", "Circle");
        comboBox.getItems().set(0, "Triangle");
        colourPicker.setValue(Color.BLACK);
        comboBox.getSelectionModel().select(0);
    }

    @FXML
    void handleDisplay() throws IOException {
        String shapeType = comboBox.getValue();
        String shapeName = textField.getText().toLowerCase();
        Color colorValue = colourPicker.getValue();
        //int counter = 0;

        //commander!

        if (shapeType == null || shapeName.isEmpty() || colorValue == null) {
            return;
        }

        try {
            //counter++;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
            Stage secondStage = new Stage();
            secondStage.initStyle(StageStyle.UNDECORATED);
            secondStage.setScene(new Scene(fxmlLoader.load()));
            secondStage.show();


            secController controller = fxmlLoader.getController();
            controller.setBridge(new Bridge(colorValue, shapeType.toLowerCase(), shapeName, 140));


        } catch (IOException e) {
            final String errorFileName = "recent_crash_report.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorFileName))) {
                bw.write("Crashed due to: " + e.getMessage() + " " + e.getCause());
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
            }
        }

    }
}