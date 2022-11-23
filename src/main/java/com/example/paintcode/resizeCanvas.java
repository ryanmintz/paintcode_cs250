package com.example.paintcode;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class resizeCanvas extends Canvas {

    private static GraphicsContext gc;

    public static GraphicsContext getgc() {
        return gc;
    }

    public resizeCanvas() {
        super();
        this.gc = this.getGraphicsContext2D();

        // Redraw canvas when size changes.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();
        gc.clearRect(0, 0, width, height);

    }

    @Override
    public boolean isResizable() {
        return true;
    }

}
