package com.example.paintcode;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * toolbars class is going to be used to create the toolbar in the GUI
 * and place buttons and different things that are needed for the project
 *
 * @author Ryan Mintz
 */
public class toolbars extends ToolBar {
    public static ToggleButton drawbutton,squarebutton,rectanglebutton,circlebutton,elipsebutton,dashedlinebutton,
            erasebutton, arcbutton,eyedropbutton,selectbutton;

    public static Button undobutton,redobutton;
    public static ColorPicker colorPicker;
    public static ComboBox brushsize,tools;
    public static VBox timerbox;

    /**
     * Default constructor for the toolbar that created all the buttons
     */
    public toolbars(){
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.WHITE);
        Color value = colorPicker.getValue();               //value will be the chosen color


        /**
         * This next bit of code is setting up combo box for brush size
         * and the drop-down menu
         */
        brushsize = new ComboBox();
        brushsize.getItems().addAll(
                "8",
                "10",
                "15"
        );
        brushsize.setValue("8");                               //sets initial value



        final ToggleGroup group = new ToggleGroup();            //toggle button group

        /**
         * The next bit of code sets up the buttons that are on the toolbar
         * For each button it sets the max size of the button, then sets an image
         * to each button to make it have an icon. There is then a tooltip feature that
         * gives you info about the button when you hover over the icon
         */

        drawbutton = new ToggleButton();            //draw button with image
        drawbutton.setMaxSize(21, 21);
        Image drawImage = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\pencil1.png");
        ImageView drawImage2 = new ImageView(drawImage);
        drawImage2.setFitHeight(22);
        drawImage2.setPreserveRatio(true);
        Tooltip drawtooltip = new Tooltip();
        drawtooltip.setText("Lets you draw on the canvas!");
        drawbutton.setTooltip(drawtooltip);
        drawbutton.setGraphic(drawImage2);
        drawbutton.setToggleGroup(group);                       //sets initial value to draw
        drawbutton.setSelected(true);

        dashedlinebutton = new ToggleButton();          //dashed line button with image
        dashedlinebutton.setPrefSize(21, 21);
        Image drawImage3 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\dashedline2.png");
        ImageView drawImage4 = new ImageView(drawImage3);
        drawImage4.setFitHeight(22);
        drawImage4.setPreserveRatio(true);
        Tooltip dashlinetooltip = new Tooltip();
        dashlinetooltip.setText("Lets you draw a dashed line on the canvas!");
        dashedlinebutton.setTooltip(dashlinetooltip);
        dashedlinebutton.setGraphic(drawImage4);
        dashedlinebutton.setToggleGroup(group);

        erasebutton = new ToggleButton();                   //erasebutton with image
        erasebutton.setPrefSize(21, 21);
        Image drawImage5 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\eraser1.png");
        ImageView drawImage6 = new ImageView(drawImage5);
        drawImage6.setFitHeight(22);
        drawImage6.setPreserveRatio(true);
        Tooltip erasertooltip = new Tooltip();
        erasertooltip.setText("Lets you erase drawings on the canvas!");
        erasebutton.setTooltip(erasertooltip);
        erasebutton.setGraphic(drawImage6);
        erasebutton.setToggleGroup(group);

        selectbutton = new ToggleButton("Select");                   //erasebutton with image
        //selectbutton.setPrefSize(21, 21);
        selectbutton.setToggleGroup(group);

        circlebutton = new ToggleButton();              //circle button with image
        circlebutton.setPrefSize(21, 21);
        Image drawImage7 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\circle.png");
        ImageView drawImage8 = new ImageView(drawImage7);
        drawImage8.setFitHeight(22);
        drawImage8.setPreserveRatio(true);
        Tooltip circletooltip = new Tooltip();
        circletooltip.setText("Lets you draw a circle on the canvas!");
        circlebutton.setTooltip(circletooltip);
        circlebutton.setGraphic(drawImage8);
        circlebutton.setToggleGroup(group);

        squarebutton = new ToggleButton();          //square button with image
        squarebutton.setPrefSize(21, 21);
        Image drawImage9 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\square.png");
        ImageView drawImage10 = new ImageView(drawImage9);
        drawImage10.setFitHeight(22);
        drawImage10.setFitWidth(22);
        drawImage10.setPreserveRatio(true);
        Tooltip squaretooltip = new Tooltip();
        squaretooltip.setText("Lets you draw a square on the canvas!");
        squarebutton.setTooltip(squaretooltip);
        squarebutton.setGraphic(drawImage10);
        squarebutton.setToggleGroup(group);

        rectanglebutton = new ToggleButton();           //rectangle button with image
        rectanglebutton.setMinSize(21,21);
        Image drawImage11 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\rectangle2.png");
        ImageView drawImage12 = new ImageView(drawImage11);
        drawImage12.setFitHeight(23);
        drawImage12.setFitWidth(23);
        drawImage12.setPreserveRatio(true);
        Tooltip rectangletooltip = new Tooltip();
        rectangletooltip.setText("Lets you draw a rectangle on the canvas!");
        rectanglebutton.setTooltip(rectangletooltip);
        rectanglebutton.setGraphic(drawImage12);
        rectanglebutton.setToggleGroup(group);

        elipsebutton = new ToggleButton();              //ellipse button with image
        elipsebutton.setMinSize(21,24);
        Image drawImage13 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\elipse.png");
        ImageView drawImage14 = new ImageView(drawImage13);
        drawImage14.setFitHeight(23);
        drawImage14.setFitWidth(23);
        drawImage14.setPreserveRatio(true);
        Tooltip elipsetooltip = new Tooltip();
        elipsetooltip.setText("Lets you draw an ellipse on the canvas!");
        elipsebutton.setTooltip(elipsetooltip);
        elipsebutton.setGraphic(drawImage14);
        elipsebutton.setToggleGroup(group);

        eyedropbutton = new ToggleButton();          //dashed line button with image
        eyedropbutton.setPrefSize(21, 21);
        Image drawImage15 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\eyedropper2.png");
        ImageView drawImage16 = new ImageView(drawImage15);
        drawImage16.setFitHeight(22);
        drawImage16.setPreserveRatio(true);
        Tooltip eyedroptooltip = new Tooltip();
        eyedroptooltip.setText("Eyedropper tool lets you select a color from the canvas");
        eyedropbutton.setTooltip(eyedroptooltip);
        eyedropbutton.setGraphic(drawImage16);
        eyedropbutton.setToggleGroup(group);

        undobutton = new Button();          //dashed line button with image
        undobutton.setPrefSize(21, 21);
        Image drawImage17 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\undo.png");
        ImageView drawImage18 = new ImageView(drawImage17);
        drawImage18.setFitHeight(22);
        drawImage18.setPreserveRatio(true);
        Tooltip undotooltip = new Tooltip();
        undotooltip.setText("Undoes the last canvas action!");
        undobutton.setTooltip(undotooltip);
        undobutton.setGraphic(drawImage18);

        redobutton = new Button();          //dashed line button with image
        redobutton.setPrefSize(21, 21);
        Image drawImage19 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\redo.png");
        ImageView drawImage20 = new ImageView(drawImage19);
        drawImage20.setFitHeight(22);
        drawImage20.setPreserveRatio(true);
        Tooltip redotooltip = new Tooltip();
        redotooltip.setText("Redoes the last canvas action!");
        redobutton.setTooltip(redotooltip);
        redobutton.setGraphic(drawImage20);

        arcbutton = new ToggleButton();          //dashed line button with image
        arcbutton.setPrefSize(21, 21);
        Image drawImage21 = new Image("C:\\Users\\user\\Desktop\\cs250\\paintcode\\buttonimages\\arc2.png");
        ImageView drawImage22 = new ImageView(drawImage21);
        Tooltip tt = new Tooltip();
        tt.setText("Lets you draw an arc on the canvas!");
        arcbutton.setTooltip(tt);
        drawImage22.setFitHeight(22);
        drawImage22.setPreserveRatio(true);
        arcbutton.setGraphic(drawImage22);
        arcbutton.setToggleGroup(group);

        timerbox = new VBox();
        //toolbar


        /**
         * This next bit of code is setting the buttons to the toolbar, and splitting them
         * up with separators
         */
        this.getItems().addAll(drawbutton, dashedlinebutton, erasebutton,undobutton,redobutton,selectbutton);    //sets items in toolbar
        this.getItems().add(new Separator());
        this.getItems().addAll(eyedropbutton,colorPicker, brushsize);    //sets items in toolbar
        this.getItems().add(new Separator());
        this.getItems().addAll(circlebutton, squarebutton, rectanglebutton, elipsebutton,arcbutton,timerbox);    //sets items in toolbar



        /**
         * This set on action calls tabclass.undo() when the undo button is pressed
         * This will undo anything that happens on the canvas
         */
        undobutton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.undo();                    //if new project is selected, create new tab
                    }
                }
        );

        /**
         * This set on action calls tabclass.redo() when the redo button is pressed
         */
        redobutton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        tabclass.redo();                    //if new project is selected, create new tab
                    }
                }
        );

    }


}
