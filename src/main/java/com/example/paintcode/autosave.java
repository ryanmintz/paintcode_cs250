package com.example.paintcode;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.TimerTask;

/**
 * This class is used to autosave the canvas
 * @author Ryan Mintz
 */
public class autosave extends TimerTask {
    public static int time;
    public static File autosavefile;
    public static Label timerLabel = new Label();

    /**
     * This sets the initial time for the autosave feature
     */
    public autosave(){
        Platform.runLater(()->{
            time = 1000;
        });
    }

    /**
     * This is the run method that is setting the label for the timer to the toolbar
     * This run method is also what is writing the image to the file path that is specified.
     */
    @Override
    public void run() {
        Platform.runLater(()->{
            timerLabel = new Label(time + "seconds");
            timerLabel.setTextFill(Color.LIGHTGRAY);
            toolbars.timerbox.getChildren().setAll(timerLabel);
        });
        time--;
        if(time ==0){
            Platform.runLater(()->{
                try {
                    autosavefile = new File("C:\\Users\\user\\Desktop\\cs250\\paintcode\\saved images\\autosave.png");
                    WritableImage writableImage = new WritableImage((int) tabclass.aquireselectedcanvas().getWidth(), (int) tabclass.aquireselectedcanvas().getHeight());     //saves the right size of canvas
                    Image snapshot = tabclass.aquireselectedcanvas().snapshot(null, writableImage);                                  //snapshot of canvas
                    ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", autosavefile);      //saves the png image
                } catch (Exception z) {
                    System.out.println("Failed to save image: " + z); //output if cannot save
                }
            });
            Platform.runLater(()->{
                time = 15;
            });
        }
    }
}
