package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/demo/PrimaryWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("Primary Window");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
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
*/