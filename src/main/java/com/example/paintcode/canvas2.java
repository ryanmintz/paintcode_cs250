package com.example.paintcode;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;

import java.awt.*;

/**
 * This class extends the drawCanvas and is used for drawing
 * and the mouse commands
 */
public class canvas2 extends drawCanvas{

    public static PixelReader r;
    public static Image image;


    private static double x1,y1,x2,y2;
    private static int x12,y12;
    private static Scale canvasscale;

    /**
     * canvas2() is the default constructor for the canvas, that sets height and width of canvas
     * as well as sets the canvas scale to scale of canvas
     */
    public canvas2(){
        super();
        this.setHeight(600);
        this.setWidth(700);
        canvasscale = new Scale(this.getWidth(),this.getHeight());

        /**
         * Handles all the controls of what happens when the mouse is pressed, with drawing,
         * erasing and using the eyedrop tool
         */
        this.setOnMousePressed( cmd -> {
            //adding to undo stack
            initdraw(this.getgc(),toolbars.colorPicker,toolbars.brushsize);
            x1 = cmd.getX();
            y1 = cmd.getY();
            x12 = (int) cmd.getX();
            y12 = (int) cmd.getX();
            tabclass.pushundo();


            if(toolbars.drawbutton.isSelected()){
                drawCanvas.getgc().beginPath();
                drawCanvas.getgc().moveTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().stroke();
            } else if (toolbars.erasebutton.isSelected()) {
                drawCanvas.getgc().beginPath();
                drawCanvas.getgc().moveTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().stroke();
            }else if (toolbars.dashedlinebutton.isSelected()) {
                drawCanvas.getgc().beginPath();
                drawCanvas.getgc().moveTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().stroke();
            } else if (toolbars.eyedropbutton.isSelected()) {
                WritableImage snap = tabclass.aquireselectedcanvas().snapshot(null, null);
                r = snap.getPixelReader();
                Color argb = r.getColor(x12,y12);
                System.out.println(argb);
                toolbars.colorPicker.setValue(argb);
            }


        });

        /**
         * Handles all the controls when the mouse is dragged after initially pressed and dragged.
         * This helps with the drawing
         */
        this.setOnMouseDragged( cmd -> {
            x2 = cmd.getX();
            y2 = cmd.getY();

            if(toolbars.drawbutton.isSelected()){            //draw if draw button is hit
                drawCanvas.getgc().lineTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().setLineDashes();
                drawCanvas.getgc().stroke();
            } else if (toolbars.dashedlinebutton.isSelected()) {
                drawCanvas.getgc().lineTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().setLineDashes(5,15);
                drawCanvas.getgc().stroke();
            } else if(toolbars.erasebutton.isSelected()) {
                this.getgc().setStroke(Color.LIGHTGRAY);
                drawCanvas.getgc().lineTo(cmd.getX(),cmd.getY());
                drawCanvas.getgc().setLineDashes();
                drawCanvas.getgc().stroke();
            } else if (toolbars.selectbutton.isSelected()) {
                drawCanvas.getgc().setLineDashes(5,15);
            }
            else{
                drawCanvas.getgc().setLineDashes();
            }

        });

        /**
         * This handles all the controls of what happens after the mouse is released.
         * This mostly has to do with the drawing of shapes
         */
        this.setOnMouseReleased( cmd -> {
            x2 = cmd.getX();
            y2 = cmd.getY();
            if (toolbars.squarebutton.isSelected()) {
                drawCanvas.drawSquare(x1,y1,x2,y2);
            }
            if(toolbars.circlebutton.isSelected()){
                drawCanvas.drawCircle(x1,y1,x2,y2);
            }
            if(toolbars.rectanglebutton.isSelected()){
                drawCanvas.drawRectangle(x1,y1,x2,y2);
            }
            if(toolbars.elipsebutton.isSelected()){
                drawCanvas.drawElipse(x1,y1,x2,y2);
            }
            if(toolbars.arcbutton.isSelected()){
                drawCanvas.drawArc(x1,y1,x2,y2);
            }
            if (toolbars.selectbutton.isSelected()) {
                drawCanvas.select(x1,y1,x2,y2);
            }
        });

    }

    /**
     * This initdraw is the method that is used to set the color of the stroke, and the size of the stroke. it is also
     * used to get the graphics context of the current selected tab
     *
     * @param gc
     * @param colorPicker
     * @param sizeBox
     */
    public static void initdraw(GraphicsContext gc, ColorPicker colorPicker, ComboBox sizeBox){
        gc.setFill(colorPicker.getValue());
        gc.setStroke(colorPicker.getValue());
        gc.setLineWidth(Double.parseDouble((String) toolbars.brushsize.getValue()));
    }

    /**
     *
     * @return x1
     */
    public static double getx1(){return x1;}

    /**
     *
     * @return x2
     */
    public static double getx2(){return x2;}

    /**
     *
     * @return y1
     */
    public static double gety1(){return y1;}

    /**
     *
     * @return y2
     */
    public static double gety2(){return y2;}




}
