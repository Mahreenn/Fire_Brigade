package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class RecieveAlertfromExternalUserController {

    @FXML
    private ComboBox<Boolean> ambulancereqCombobox;

    @FXML
    private ComboBox<String> areaTypeCombobox;

    @FXML
    private ComboBox<String> locationCombobox;

    @FXML
    private TextField descriptionTf;

    @FXML
    private DatePicker incidentdatdp;

    @FXML
    private TextField incidenttimetf;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize(){
        incidentdatdp.setValue(LocalDate.now());
        areaTypeCombobox.getItems().addAll("Residential","Industrial", "Commercial","Densely populated","Road");
        ambulancereqCombobox.getItems().addAll(true, false);
        locationCombobox.getItems().addAll("Uttara","Dhanmondi","Bashundhara","Mirpur");
    }

    @FXML
    void OnsubmitAlertButtonClick(ActionEvent event) {
        if(incidentdatdp.getValue().isAfter(LocalDate.now())){
            messageLabel.setText("Incident date cannot be in Future");
        }
        messageLabel.setText("Your Alert has been submitted to a Dispatcher near you");

    }

    //back to the login page
    @FXML
    public void backButtonClick(ActionEvent event)  throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
