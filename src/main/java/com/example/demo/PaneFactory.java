package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class PaneFactory {
    private final Pane pane;

    PaneFactory() {
        this.pane = createTilePane();
    }

    PaneFactory(Pane pane, Bridge bridgedShape) {
        this.pane = pane;
        drawShape(bridgedShape);
    }

    public static TilePane createTilePane() {
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(50);
        tilePane.setPrefRows(50);
        tilePane.setStyle("-fx-background-color: #ffffff;");
        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setHgap(50);
        tilePane.setVgap(100);

        return tilePane;
    }

    public void drawShape(Bridge bridgedShape) {
        if (pane instanceof TilePane) {
            bridgedShape.draw((TilePane) pane);
        }
    }

    public Pane getPane() {
        return pane;
    }
}