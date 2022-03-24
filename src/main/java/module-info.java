module com.example.uhrzeit {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uhrzeit to javafx.fxml;
    exports com.example.uhrzeit.controller;
    opens com.example.uhrzeit.controller to javafx.fxml;
}