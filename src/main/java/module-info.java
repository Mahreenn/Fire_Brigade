module oop.firebrigadeoperationsapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.firebrigadeoperationsapp to javafx.fxml;
    exports oop.firebrigadeoperationsapp;
    exports oop.firebrigadeoperationsapp.Dispatcher;
    opens oop.firebrigadeoperationsapp.Dispatcher to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Firefighter;
    opens oop.firebrigadeoperationsapp.Firefighter to javafx.fxml;
}