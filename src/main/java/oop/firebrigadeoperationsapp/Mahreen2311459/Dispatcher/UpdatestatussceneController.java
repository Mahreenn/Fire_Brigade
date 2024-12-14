package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.HelloApplication;

import java.io.IOException;
import java.util.List;

public class UpdatestatussceneController {

    @FXML
    private Label message;

    @FXML
    private TextField alertidtextfield;

    @FXML
    private TextField statustextfield;

    private Alert alert;

    public void setAlert(Alert alert) {
        this.alert = alert;

        String s = String.valueOf(alert.getAlertID());
        alertidtextfield.setText(s);
        statustextfield.setText((alert.getStatus()));
    }

    @FXML
    public void statusupdatebutton(javafx.event.ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(alertidtextfield.getText());
        String status = statustextfield.getText();

        List<Alert> alertsList = Alert.readAlertsFromFile();

        Alert updatedAlert = Alert.findAlertById(alertsList, id);
        if (updatedAlert != null) {
            updatedAlert.setStatus(status);
            Alert.writeAlertsToFile(alertsList);
            message.setText("Status updated successfully.");
        } else {
            message.setText("Alert not found.");
        }

    }

    public void closebutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mahreen2311459/Dispatcher/newDash.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
