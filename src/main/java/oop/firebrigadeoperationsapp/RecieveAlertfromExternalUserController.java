package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RecieveAlertfromExternalUserController {

    @FXML
    private ComboBox<?> areaTypeCombobox;

    @FXML
    private TextField descriptionTf;

    @FXML
    private DatePicker incidentdatdp;

    @FXML
    private TextField incidenttimetf;

    @FXML
    private ComboBox<?> locationCombobox;

    @FXML
    private Label messageLabel;

    @FXML
    void OnsubmitAlertButtonClick(ActionEvent event) {

    }

}
