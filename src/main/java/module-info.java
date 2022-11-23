module com.example.paintcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.paintcode to javafx.fxml;
    exports com.example.paintcode;
}