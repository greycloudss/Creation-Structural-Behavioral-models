package com.example.demo;


import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

abstract class Shape {
    protected double width;
    protected String name;
    protected String type;

    public Shape(double width, String name, String type) {
        this.width = width;
        this.name = name;
        this.type = type;
    }

    public abstract void draw(TilePane pane);
}

