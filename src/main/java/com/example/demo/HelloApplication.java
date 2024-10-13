package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloApplication extends Application {
    public Stage secStage;
    public Stage mainStage;

    @Override
    public void start(Stage secStage) throws IOException {
        this.secStage = secStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SecondWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        secStage.initStyle(StageStyle.UNDECORATED);
        secStage.setScene(scene);
        secStage.show();
        openNewWin();
    }

    public void openNewWin() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrimaryWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            this.mainStage = new Stage(StageStyle.DECORATED);
            this.mainStage.setScene(scene);
            this.mainStage.show();
            this.mainStage.setAlwaysOnTop(true);
            this.secStage.setAlwaysOnTop(true);
            mainStage.setResizable(false);
            updatePosition();

            mainStage.xProperty().addListener((_, _, _) -> updatePosition());
            mainStage.yProperty().addListener((_, _, _) -> updatePosition());

            this.mainStage.setOnCloseRequest((WindowEvent _) -> {
                if (secStage.isShowing())
                    secStage.close();
            });


        } catch (Exception e) {
            final String errorFileName = "recent_crash_report.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorFileName))) {
                bw.write("Crashed due to: " + e.getMessage());
            }
        }
    }

    private void updatePosition() {
        if (this.secStage != null && this.mainStage != null) {
            double secondWindowX = this.mainStage.getX();
            double secondWindowY = this.mainStage.getY();

            this.secStage.setX(secondWindowX - secStage.getWidth());
            this.secStage.setY(secondWindowY);
        }
    }

    public static void main() {
        launch();
    }
}