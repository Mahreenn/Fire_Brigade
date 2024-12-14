package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.Alert;

public class EmergencyUpdatesController {

    Emergency

    private Emergency emergency;

    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;


        desctf.setText();
        injtf.setText((emergency.getStatus()));
    }

    @FXML
    private TextField desctf;

    @FXML
    private TextField injtf;

    @FXML
    void updateemerbutton(ActionEvent event) {

    }

}
