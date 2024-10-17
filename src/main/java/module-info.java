module oop.firebrigadeoperationsapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.firebrigadeoperationsapp to javafx.fxml;
    exports oop.firebrigadeoperationsapp;
}