package com.example.paintcode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class that extends the application. This class is used to set the scene and window
 * that will be used to build off
 * @author Ryan Mintz
 */
public final class HelloApplication extends Application {

    public static canvas2 canvas;
    public static TabPane tabPane;
    public GraphicsContext gc;
    public static BorderPane grid;
    public static ScrollPane scroller;
    public static Stage canvasstage;

    /**
     *
     * @param stage
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {

        /**
         * creating scrollpane, borderpane and tabpane
         */
        scroller = new ScrollPane();
        grid = new BorderPane();
        tabPane = new TabPane();


        canvasstage = stage;
        canvas = new canvas2();

        /**
         * Calling toolbar and menubar class to create interface
         */
        toolbars toolBar1 = new toolbars();
        menuclass mainmenu2 = new menuclass();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(mainmenu2,toolBar1);

        /**
         * Setting the vbox with main menu and toolbar to the top of the borderpane
         */
        grid.setTop(vBox);

        //adding initial tab
        addTab(tabPane);

        /**
         * Next block of code is setting the stage window, and setting tabpane to center of grid
         */
        //setting window
        Scene scene = new Scene(grid);
        stage.setTitle("Pain(t)");
        stage.setWidth(850);                            //setting height and width of scene
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();                                       //shows scene
        grid.setCenter(tabPane);
        gc = tabclass.aquireselectedcanvas().getGraphicsContext2D();



    }

    /**
     * This method is to add a tab to the tabpane.
     */
    public static void addthetab() {
        addTab(tabPane);
    }

    /**
     * This method adds a new tab to the tabpane by calling the tabclass
     * @param tabPane
     */
    private static void addTab(TabPane tabPane) {
        tabclass tab = new tabclass();
        tabPane.getTabs().add(tab);                             //adds the tab
        tabPane.getSelectionModel().select(tab);                //selects the new tab to work on
    }

    /**
     * Main of the program
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}