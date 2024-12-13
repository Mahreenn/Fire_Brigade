package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class UpdatestatussceneController {

    @FXML
    private TextField alrtidss;

    @FXML
    private TextField statusidss;

    private Alert alert;

    public void setAlert(Alert alert) {
        this.alert = alert;

        String s = String.valueOf(alert.getAlertID());
        alrtidss.setText(s);
        statusidss.setText((alert.getStatus()));
    }

    @FXML
    public void statusupdatessbutton(ActionEvent event) {
        int id = Integer.parseInt(alrtidss.getText());
        String status = statusidss.getText();


    }

}
