package com.example.paintcode;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

/**
 * tabclass is going to be used for creating most of the functions that have
 * to do with getting information from the canvas,which is on tabs
 *
 * @author Ryan Mintz
 */
public class tabclass extends Tab{

    public static canvas2 tabcanvas;
    public static ScrollPane scroller;
    public static Pane rotatepane;
    private static double currentScale;
    public static File importfile;
    public static Image img;
    public static Stack<Image> undoStack;
    public static Stack<Image> redoStack;
    public static Image snapshot;
    public static File outfile;
    private static GraphicsContext gc;

    /**
     * default constructor for the tabclass. Sets text of new tab and other things such as timer for autosave
     * the new tab will have a new canvas as well as all the other features
     */
    public tabclass(){
        super();
        this.setText("New Tab");

        TimerTask timertask2 = new autosave();
        try{
            Timer autosavetimer = new Timer();
            autosavetimer.scheduleAtFixedRate(timertask2,0,1000);
        }catch(Exception e){
            System.out.println("Timer exception");
        }

        tabcanvas = new canvas2();
        this.scroller = new ScrollPane();
        this.setContent(scroller);
        rotatepane = new Pane(tabcanvas);
        scroller.setContent(rotatepane);
        scroller.setMaxHeight(tabcanvas.getHeight());          //setting up scroll pane
        scroller.setMaxWidth(tabcanvas.getWidth());
        tabcanvas.setTranslateX(100);
        tabcanvas.translateXProperty();

        gc = tabcanvas.getGraphicsContext2D();                                   //getgraphicscontent
        gc.setFill(Color.LIGHTGRAY);                                           //makes new tab light blue canvas
        gc.fillRect(0, 0, tabcanvas.getWidth(), tabcanvas.getHeight());       //fills canvas to gray

        undoStack = new Stack<>();
        redoStack = new Stack<>();
        currentScale = 1.0;


    }

    /**
     *
     * @return gets canvas from tab
     */
    public canvas2 aquirecanvas(){
        return this.tabcanvas;
    }

    /**
     *
     * @return gets the canvas from the tab that the user selected
     */
    public static canvas2 aquireselectedcanvas(){
        return aquiretab().aquirecanvas();
    }

    /**
     *
     * @return the tab selected by the user
     */
    public static tabclass aquiretab(){
        return (tabclass) HelloApplication.tabPane.getSelectionModel().getSelectedItem();
    }

    /**
     * Gets the width and height of canvas that is in selected tab,
     * and fills the canvas with a grey square giving it appearance of being cleared
     */
    public static void clear(){
        gc.clearRect(0, 0, aquireselectedcanvas().getWidth(), aquireselectedcanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, aquireselectedcanvas().getWidth(), aquireselectedcanvas().getHeight());       //fills canvas to gray
    }


    /**
     * This method is to save the content of a canvas.
     * It has to already be saved or have a file path from the open() method,
     * or else it will catch an error
     */
    public static void save(){
        try {

            WritableImage writableImage = new WritableImage((int) aquireselectedcanvas().getWidth(), (int) aquireselectedcanvas().getHeight());     //saves the right size of canvas
            Image snapshot = aquireselectedcanvas().snapshot(null, writableImage);                                  //snapshot of canvas
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", importfile);      //saves the png image
        } catch (Exception z) {
            System.out.println("Failed to save image: " + z); //output if cannot save
        }
    }

    /**
     * rotates canvas 90 degrees
     */
    public static void rotate90(){
        rotatepane.setRotate(rotatepane.getRotate()+90);
    }
    /**
     * rotates canvas 180 degrees
     */
    public static void rotate180(){
        rotatepane.setRotate(rotatepane.getRotate()+180);
    }
    /**
     * rotates canvas 270 degrees
     */
    public static void rotate270(){
        rotatepane.setRotate(rotatepane.getRotate()+270);
    }

    /**
     * flips canvas on x axis
     */
    public static void mirrorx(){
        rotatepane.setScaleX(rotatepane.getScaleX()*-1);
    }

    /***
     * flips mirror in y axis
     */
    public static void mirrory(){
        rotatepane.setScaleY(rotatepane.getScaleY()*-1);
    }

    /**
     * This is a method that creates a file chooser window for the user to select
     * a file path to save the canvas
     *
     */
    public static void saveas(){
        FileChooser fileChooser = new FileChooser();                                              //file chooser to select file
        fileChooser.setTitle("Save As");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));    //save png file
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));    //save jpg file
        File outputFile2 = fileChooser.showSaveDialog(HelloApplication.canvasstage);

        try {
            WritableImage writableImage2 = new WritableImage((int) aquireselectedcanvas().getWidth(), (int) aquireselectedcanvas().getHeight());
            Image snapshot2 = aquireselectedcanvas().snapshot(null, writableImage2);                              //takes snapshot of canvas
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot2, null), "png", outputFile2);
        } catch (Exception z) {
            System.out.println("Failed to save image: " + z);                                                  //text if save fails
        }
        outfile = outputFile2;

    }

    final static FileChooser fileChooser = new FileChooser();


    /**
     * This method creates an image from the selected import file
     * and draws the image on the canvas
     */
    public static void open() {
        importfile = fileChooser.showOpenDialog(HelloApplication.canvasstage);                 //shows file chooser
        if (importfile != null) {
            //Sets up selected image to display on screen
            img = new Image(importfile.toURI().toString());       //makes a new image
            aquireselectedcanvas().setHeight(img.getHeight());                          //adjust height and width of canvas
            aquireselectedcanvas().setWidth(img.getWidth());

            gc.drawImage(img, 0, 0);                               //lets you draw on canvas

        }
    }

    /**
     * This method clears the redo stack while pushing the snapshot on
     * to the undo stack
     */
    public static void pushundo(){
        redoStack.clear();
        undoStack.push(getSnapshot());
    }

    /**
     * This gets a snapshot of the canvas
     * @return the image that is taken of the canvas
     */
    private static Image getSnapshot() {
        tabclass.aquireselectedcanvas().setScaleX(1);
        tabclass.aquireselectedcanvas().setScaleY(1);
        snapshot = aquireselectedcanvas().snapshot(null,null);  //snapshots of the canvas
        tabclass.aquireselectedcanvas().setScaleX(currentScale);
        tabclass.aquireselectedcanvas().setScaleY(currentScale);
        return snapshot;
    }

    /**
     * sets redo image to the current image while setting the canvas to the last
     * snapshotted image
     */
    public static void undo(){
        if(hasUndo()){
            Image redo = getSnapshot();                 //redo image is snapshot of previous
            redoStack.push(redo);                   //push redo
            Image undoImage = undoStack.pop();          //sets undo image to undostock pop
            gc.drawImage(undoImage,0,0);            //draws the undo image

        }
    }

    /**
     * method that redoes the last undo of canvas
     */
    public static void redo(){
        if (hasRedo()) {
            Image undo = getSnapshot();             //undo image is snapshot of previous
            undoStack.push(undo);
            Image redoImage = redoStack.pop();
            gc.drawImage(redoImage, 0, 0);
        }

    }


    /**
     *
     * @return if the undo stack is empty
     */
    private static boolean hasUndo() {
        return !undoStack.isEmpty();      //check if undo is empty
    }

    /**
     *
     * @return if the redo stack is empty
     */
    private static boolean hasRedo() {
        return !redoStack.isEmpty();        //check if redo is empty
    }


}
