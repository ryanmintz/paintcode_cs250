package com.example.paintcode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class is used to create the menu bar of the project
 * @author Ryan Mintz
 */
public class menuclass extends MenuBar {

    public static MenuItem NewProject;
    public static MenuBar mainmenu;
    public static Button exityesbutton,exitnobutton;

    /**
     * Default constructor for the menu class, that sets up the menu with all the tools, file, and help menus
     */
    public menuclass() {
      super();
      Menu fileMenu = new Menu("_File");                                               //creating menu items File, and Help
      Menu helpMenu = new Menu("_Help");
      Menu toolMenu = new Menu("Tools");
      Menu flip = new Menu ("Flip");
      MenuItem fliphorizontally = new MenuItem("Flip Horizontally");
        MenuItem flipvertically = new MenuItem("Flip Vertically");
        flip.getItems().addAll(fliphorizontally,flipvertically);
        Menu settingMenu = new Menu("_Settings");
      Menu Autosave = new Menu("Autosave");
      MenuItem Select = new MenuItem("Select");
      Menu Rotate = new Menu("Rotate");
        MenuItem rotate90 = new MenuItem("Rotate 90");
        MenuItem rotate180 = new MenuItem("Rotate 180");
        MenuItem rotate270 = new MenuItem("Rotate 270");
        Rotate.getItems().addAll(rotate90,rotate180,rotate270);
        Menu Autosaveenable = new Menu("Enable");
      MenuItem Autosavedisable = new MenuItem("Disable");
      Autosave.getItems().addAll(Autosaveenable, Autosavedisable);
      MenuItem save30seconds = new MenuItem("30 Seconds");
      MenuItem save1minute = new MenuItem("1 Minute");
      MenuItem save5minutes = new MenuItem("5 Minute");
      Autosaveenable.getItems().addAll(save30seconds, save1minute, save5minutes);
      MenuItem Open = new MenuItem("Open...");//creating menu items that will go inside of file and exit
      MenuItem Cut = new MenuItem("Cut");
      MenuItem Save = new MenuItem("Save");
      MenuItem SaveAs = new MenuItem("Save As...");
      NewProject = new MenuItem("New Project...");
      MenuItem Exit = new MenuItem("Exit");
      MenuItem Clear = new MenuItem("Clear");
      MenuItem Help = new MenuItem("Help");
      Exit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));         //exit keyboard shortcut
      SaveAs.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));       //save as keyboard shortcut
      Save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));         //save keyboard shortcut
      NewProject.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));         //new project keyboard shortcut
      Help.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));         //help keyboard shortcut
      Open.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));         //open keyboard shortcut
      Clear.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));         //clear keyboard shortcut
      fileMenu.getItems().addAll(Open, NewProject, Save, SaveAs, Clear, Exit);                                         //sets file menu
      helpMenu.getItems().addAll(Help);//help menu
      toolMenu.getItems().addAll(Rotate,flip, Cut);
      settingMenu.getItems().addAll(Autosave);

      this.getMenus().addAll(fileMenu, toolMenu, helpMenu, settingMenu);

        /**
         * setOnAction for when SaveAs button is pressed. This calls the saveas()
         * method from tabclass class.
         */
      SaveAs.setOnAction(
              new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent e) {
                      tabclass.saveas();
                  }
              });

        /**
         * setOnAction for when open button is pressed. This calls the open()
         * method from tabclass class.
         */
        Open.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        tabclass.open();
                    }
                });

        /**
         * This method will open a new window that will ask the user if they want
         * to exit and close the program. It sets up buttons and text in the display window and will close the program
         * after yes or no is selected with the window that pops up when exit is pressed
         */
        Exit.setOnAction((ActionEvent t) -> {

            Stage exitstage = new Stage();
            exitstage.setTitle("Save before closing");               //title of the program
            GridPane exitgrid = new GridPane();
            exitgrid.setAlignment(Pos.CENTER);                            //help tab set to center

            Text exittext1 = new Text("    Your data might not be saved");
            Text exittext2 = new Text("Do you want to save before you exit?");
            exittext1.setStyle("-fx-font: 18 arial;");
            exittext2.setStyle("-fx-font: 18 arial;");
            exitnobutton = new Button("No");
            exityesbutton = new Button("Yes");


            exitgrid.setVgap(5);
            exitgrid.setHgap(5);
            exitgrid.add(exittext1,0,0);
            exitgrid.add(exittext2,0,1);
            exitgrid.add(exityesbutton,1,2);
            exitgrid.add(exitnobutton,0,2);


            exityesbutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tabclass.save();
                    System.exit(0);
                }
            });
            exitnobutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.exit(0);
                }
            });

            Scene helpscene = new Scene(exitgrid, 370, 170);      //size of help window
            exitstage.setScene(helpscene);
            exitstage.setResizable(false);
            exitstage.show();

        });


        /**
         * Calls tabclass.save() if save button is called
         */
        Save.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       tabclass.save();
                    }
                }
        );

        /**
         * This set on action sets the autosave time to 30 seconds
         */
        save30seconds.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        autosave.time = 30;
                    }
                }
        );

        /**
         * This set on action sets the autosave time to 1 minute, which is 60 seconds
         */
        save1minute.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        autosave.time = 60;
                    }
                }
        );

        /**
         * This set on action sets the autosave time to 5 minutes, which is 300 seconds
         */
        save5minutes.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        autosave.time = 300;
                    }
                }
        );

        /**
         * This set on action disables autosave, which also just sets the autosave value to very high so it never
         * calls autsave
         */
        Autosavedisable.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        autosave.time = 999999999;
                    }
                }
        );

        rotate90.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.rotate90();
                    }
                }
        );
        rotate180.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.rotate180();
                    }
                }
        );
        rotate270.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.rotate270();
                    }
                }
        );

        fliphorizontally.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.mirrorx();
                    }
                }
        );

        flipvertically.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.mirrory();
                    }
                }
        );

        Cut.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                            tabclass.undo();
                            tabclass.aquireselectedcanvas().cut(canvas2.getx1(), canvas2.gety1(), canvas2.getx2(), canvas2.gety2());
                    }
                }
        );

        /**
         * This set on action calls tabclass.clear() when the clear menu item is selected
         */
        Clear.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.clear();
                    }
                }
        );

        /**
         * This set on action adds a tab to the tabpane when the new project menu item is selected
         */
        NewProject.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        HelloApplication.addthetab();            //if new project is selected, create new tab
                    }
                }
        );


        /**
         * Pulls up help screen if help button is pressed
         */

        //help menu item action
        Help.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        Stage helpstage = new Stage();
                        helpstage.setTitle("Help");                         //title of the program
                        GridPane helpgrid = new GridPane();
                        helpgrid.setAlignment(Pos.CENTER);                            //help tab set to center
                        Text helptext = new Text("Ryan Mintz's Pain(t) Application");
                        helpgrid.add(helptext, 1, 1, 1, 1);
                        Text helptext2 = new Text("Version 1.9.0");                              //help text
                        helpgrid.add(helptext2, 1, 2, 1, 2);
                        Text helptext3 = new Text("Email ryan.mintz@valpo.edu for help");
                        helpgrid.add(helptext3, 1, 4, 1, 4);
                        Scene helpscene = new Scene(helpgrid, 300, 200);      //size of help window
                        helpstage.setScene(helpscene);
                        helpstage.show();

                    }
                }
        );

    }


}
