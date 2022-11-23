package com.example.paintcode;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.awt.image.BufferedImage;

/**
 * This class is used to extend canvas and draw images on the canvas
 * @author Ryan Mintz
 */
public class drawCanvas extends Canvas {
    private static GraphicsContext gc;
    /**
     * This method returns the graphics context of the tab that is selected
     * @return returns the currently selected tabs graphics context
     */
    public static GraphicsContext getgc() {
        return tabclass.aquireselectedcanvas().getGraphicsContext2D();
    }

    double width, height;

    /**
     * Default constructor for drawCanvas class
     * Calls super() to go up hierarchy for canvas
     */
    public drawCanvas() {
        super();
        this.gc = this.getGraphicsContext2D();
    }

    /**
     * This method draws a square on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void drawSquare(double x1, double y1, double x2, double y2) {
        if (x2 >= x1 && y2 >= y1) {                        //down right
            gc.strokeRect(x1, y1, x2 - x1, x2 - x1);
            //gcgo.strokeRect(x1, y1, x2 - x1, x2 - x1);
        } else if (x2 >= x1 && y1 >= y2) {                  //up right
            gc.strokeRect(x1, y2, x2 - x1, x2 - x1);
            //gcgo.strokeRect(x1, y2, x2 - x1, x2 - x1);
        } else if (x1 >= x2 && y1 >= y2) {                    //up left
            gc.strokeRect(x2, y2, x1 - x2, x1 - x2);
            //gcgo.strokeRect(x2, y2, x1 - x2, x1 - x2);
        } else if (x1 >= x2 && y2 >= y1) {                    //down left
            gc.strokeRect(x2, y1, x1 - x2, x1 - x2);
            //gcgo.strokeRect(x2, y1, x1 - x2, x1 - x2);
        }

    }

    /**
     * This method draws a circle on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void drawCircle(double x1, double y1, double x2, double y2) {
        if (x2 >= x1 && y2 >= y1) {                        //down right
            gc.strokeOval(x1, y1, x2 - x1, x2 - x1);
        } else if (x2 >= x1 && y1 >= y2) {                  //up right
            gc.strokeOval(x1, y2, x2 - x1, x2 - x1);
        } else if (x1 >= x2 && y1 >= y2) {                    //up left
            gc.strokeOval(x2, y2, x1 - x2, x1 - x2);
        } else if (x1 >= x2 && y2 >= y1) {                    //down left
            gc.strokeOval(x2, y1, x1 - x2, x1 - x2);
        }
    }

    /**
     * This method draws a rectangle on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void drawRectangle(double x1, double y1, double x2, double y2) {
        if(x2>=x1 && y2>=y1){                        //down right
            gc.strokeRect(x1,y1,x2-x1,y2-y1);
        } else if (x2>=x1 && y1>=y2) {                  //up right
            gc.strokeRect(x1,y2,x2-x1,y1-y2);
        } else if (x1>=x2 && y1>=y2) {                    //up left
            gc.strokeRect(x2,y2, x1-x2,y1-y2);
        } else if (x1>=x2 && y2>=y1) {                    //down left
            gc.strokeRect(x2,y1, x1-x2,y2-y1);
        }
    }

    /**
     * This method draws an ellipse on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void drawElipse(double x1, double y1, double x2, double y2) {
        if(x2>=x1 && y2>=y1){                        //down right
            gc.strokeOval(x1,y1,x2-x1,y2-y1);
        } else if (x2>=x1 && y1>=y2) {                  //up right
            gc.strokeOval(x1,y2,x2-x1,y1-y2);
        } else if (x1>=x2 && y1>=y2) {                    //up left
            gc.strokeOval(x2,y2, x1-x2,y1-y2);
        } else if (x1>=x2 && y2>=y1) {                    //down left
            gc.strokeOval(x2,y1, x1-x2,y2-y1);
        }
    }

    /**
     *
     * This method draws an arc on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void drawArc(double x1, double y1, double x2, double y2){
        if (x2 >= x1 && y2 >= y1) {                        //down right
            gc.strokeArc(x1, y1, x2-x1,y2-y1,-90,-90, ArcType.OPEN);
        } else if (x2 >= x1 && y1 >= y2) {                  //up right
            gc.strokeArc(x1, y2, x2-x1,y1-y2,90,90, ArcType.OPEN);
        } else if (x1 >= x2 && y1 >= y2) {                    //up left
            gc.strokeArc(x2, y2, x1-x2,y1-y2,90,-90, ArcType.OPEN);
        } else if (x1 >= x2 && y2 >= y1) {                    //down left
            gc.strokeArc(x2, y1, x1-x2,y2-y1,-90,90, ArcType.OPEN);
        }
    }

    /**
     * This method draws a dotted rectangle on a canvas based on the coordinates
     * of original mouse click and where the mouse is released
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public static void select(double x1, double y1, double x2, double y2) {
        if(x2>=x1 && y2>=y1){  //down right
            gc.strokeRect(x1,y1,x2-x1,y2-y1);
        } else if (x2>=x1 && y1>=y2) {                  //up right
            gc.strokeRect(x1,y2,x2-x1,y1-y2);
        } else if (x1>=x2 && y1>=y2) {                    //up left
            gc.strokeRect(x2,y2, x1-x2,y1-y2);
        } else if (x1>=x2 && y2>=y1) {                    //down left
            gc.strokeRect(x2,y1, x1-x2,y2-y1);
        }
    }

    /**
     * This method gets the width and the height of a rectangle that is drawn,
     * and gets the image that is in that rectangle and cuts it from the image
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void cut(double x1, double y1, double x2, double y2) {
        double w = Math.abs(x2 - x1);
        double h = Math.abs(y2-y1);
        gc.setFill(Color.LIGHTGRAY);
        Image snapshot = this.snapshot(null, null);
        BufferedImage cutimage = SwingFXUtils.fromFXImage(snapshot,null);
        BufferedImage cutimage2 = new BufferedImage((int) w,(int) h,BufferedImage.OPAQUE);
        if(x2>=x1 && y2>=y1 && toolbars.selectbutton.isSelected()){  //down right
            cutimage2.createGraphics().drawImage(cutimage.getSubimage((int)x1,(int)y1,(int)w,(int)h),0,0,null);
            Image image = SwingFXUtils.toFXImage(cutimage2,null);
            //gc.strokeRect(x1,y1,x2-x1,y2-y1);
            gc.fillRect(x1,y1,x2-x1,y2-y1);
        } else if (x2>=x1 && y1>=y2) {                  //up right
            cutimage2.createGraphics().drawImage(cutimage.getSubimage((int)x1,(int)y1,(int)w,(int)h),0,0,null);
            Image image = SwingFXUtils.toFXImage(cutimage2,null);
            //gc.strokeRect(x1,y2,x2-x1,y1-y2);
            gc.fillRect(x1,y2,x2-x1,y1-y2);
        } else if (x1>=x2 && y1>=y2) {                    //up left
            cutimage2.createGraphics().drawImage(cutimage.getSubimage((int)x1,(int)y1,(int)w,(int)h),0,0,null);
            Image image = SwingFXUtils.toFXImage(cutimage2,null);
            //gc.strokeRect(x2,y2,x1-x2,y1-y2);
            gc.fillRect(x2,y2, x1-x2,y1-y2);
        } else if (x1>=x2 && y2>=y1) {                    //down left
            cutimage2.createGraphics().drawImage(cutimage.getSubimage((int)x1,(int)y1,(int)w,(int)h),0,0,null);
            Image image = SwingFXUtils.toFXImage(cutimage2,null);
           // gc.strokeRect(x2,y1,x1-x2,y2-y1);
            gc.fillRect(x2,y1,x1-x2,y2-y1);
        }

    }

}
