package oop.firebrigadeoperationsapp.Forensic_expert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;




public class forensic_DashboardController {
    @FXML
    private TextField IncidentLocationField;
    @FXML
    private TextField IncidentNamefield;
    @FXML
    private TextField IncidentNoField;
    @FXML
    private DatePicker IncidentDate;
    @FXML
    private Label massageLabel;
    @FXML
    private TextArea descriptionField;

    @FXML
    public void initialize() {
//        tableview initialize
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("dashboard_forensic_expert.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void LogOutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void OnProfileButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void OnPriviousIncidentButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("PreviousIncident.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);


    }

    @FXML
    public void OnDownloadButtonClick(ActionEvent Event) {
    }


    @FXML
    public void OnReportSubmitButtonClick(ActionEvent event) {
    }
}
