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
    private TableView tableview;

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



    //    forensic_Dashboard Fxml Button

    @FXML
    public void OnProfileButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }


     // forensic_Dashboard Fxml Button
    @FXML
    public void OnPreviousIncidentButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("PreviousIncident.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);


    }



//    for downloading pdf in previous Incident Fxml
    @FXML
    public void OnDownloadButtonClick(ActionEvent Event) {
    }



    //for submitting report in Forensic report submit FXML
    @FXML
    public void OnReportSubmitButtonClick(ActionEvent event) {
    }


    // forensic_Dashboard Fxml Button
    @FXML
    public void OnReportSubmissionButtonClick(ActionEvent actionEvent) {
    }




    //for loading previous incident in the table view.
    @FXML
    public void OnLoadPreviousForensicReportButtonClick(ActionEvent actionEvent) {
    }



    //for loading previous forensic report that submitted by the forensic expert in the same table view.
    @FXML
    public void OnLoadPreviousIncidentsButtonClick(ActionEvent actionEvent) {
    }
}
