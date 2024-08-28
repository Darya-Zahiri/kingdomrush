module com.example.finalpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.media;


    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
    exports view;
    opens view to javafx.fxml;
}