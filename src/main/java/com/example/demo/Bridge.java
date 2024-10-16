package com.example.demo;

// the Bridge to rule them all

import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
//factory and bridge
class Bridge extends Shape implements Colour {
    private Color colour;

    public Bridge(Color colour, String type, String name, double width) {
        super(width, name, type);
        this.colour = colour;
    }

    @Override
    public void applyColour() {
        this.colour = Color.RED;
    }

    @Override
    public void draw(TilePane pane) {

        Label label = new Label(name);
        pane.getChildren().add(label);

        switch (type.toLowerCase()) {
            case "circle":
                Circle circle = new Circle(width / 2);
                circle.setFill(colour);
                circle.layoutXProperty().bind(pane.widthProperty().divide(2));
                circle.layoutYProperty().bind(pane.heightProperty().divide(2));
                pane.getChildren().add(circle);
                break;

            case "rectangle":
                Rectangle rectangle = new Rectangle(width, width / 2);
                rectangle.setFill(colour);
                rectangle.layoutXProperty().bind(pane.widthProperty().subtract(rectangle.getWidth()).divide(2));
                rectangle.layoutYProperty().bind(pane.heightProperty().subtract(rectangle.getHeight()).divide(2));
                pane.getChildren().add(rectangle);
                break;

            default:
                Polygon polygon = new Polygon(0, 0, width, 0, width / 2, width);
                polygon.setFill(colour);
                polygon.layoutXProperty().bind(pane.widthProperty().subtract(width).divide(2));
                polygon.layoutYProperty().bind(pane.heightProperty().divide(2));
                pane.getChildren().add(polygon);
                break;
        }
    }
}