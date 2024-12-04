module oop.firebrigadeoperationsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;


    opens oop.firebrigadeoperationsapp to javafx.fxml;
    exports oop.firebrigadeoperationsapp;
    exports oop.firebrigadeoperationsapp.Mahreen.Dispatcher;
    opens oop.firebrigadeoperationsapp.Mahreen.Dispatcher to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Mahreen;
    opens oop.firebrigadeoperationsapp.Mahreen to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Mahreen.Firefighter;
    opens oop.firebrigadeoperationsapp.Mahreen.Firefighter to javafx.fxml;
}