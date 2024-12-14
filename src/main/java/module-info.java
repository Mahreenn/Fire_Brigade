module oop.firebrigadeoperationsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;
    requires javafx.graphics;
    requires java.desktop;

    opens oop.firebrigadeoperationsapp to javafx.fxml;
    exports oop.firebrigadeoperationsapp;
    exports oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;
    opens oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Mahreen2311459;
    opens oop.firebrigadeoperationsapp.Mahreen2311459 to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;
    opens oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter to javafx.fxml;
    exports oop.firebrigadeoperationsapp.BattalionChief;
    opens oop.firebrigadeoperationsapp.BattalionChief to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Search_operator;
    opens oop.firebrigadeoperationsapp.Search_operator to javafx.fxml;
    opens oop.firebrigadeoperationsapp.Forensic_expert to javafx.fxml;
    exports oop.firebrigadeoperationsapp.Forensic_expert;
}