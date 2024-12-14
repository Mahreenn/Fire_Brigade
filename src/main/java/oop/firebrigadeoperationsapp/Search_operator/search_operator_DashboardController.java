package oop.firebrigadeoperationsapp.Search_operator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.Document;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.Employee;
import oop.firebrigadeoperationsapp.Forensic_expert.IncidentReport;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class search_operator_DashboardController {

    @FXML
    public void OnProfileButtonClick(ActionEvent event) throws IOException {
        //        scence switch to Profile.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/Profile.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;

    }
    @FXML
    public void OnPreviousSearchOperationButtonClick(ActionEvent event) throws IOException {
        //        scence switch to Profile.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("previous_search_operation.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;


    }

    @FXML
    public void OnReportSubmissionButtonClick(ActionEvent event) throws IOException { //this button has no work
        //        scence switch to reportSubmission_search_operator.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/Search_operator/reportSubmission_search_operator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;

    }

    @FXML
    public void OnLogOutButtonClick(ActionEvent event) throws IOException {
        //        scence switch to LoginPage.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/LoginPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;

    }

    @FXML
    public void OnEmergencyButtonClick(ActionEvent event) throws IOException {
        //        scence switch to emergency_searchOperator.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/Search_operator/emergency_searchOperator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;


    }
    @FXML
    public void OnBackButtonClick(ActionEvent event) throws IOException {
        //        scence switch to Profile.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_search_operator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }

    @Deprecated
    public void onCreateSearchTeamButtonClick(ActionEvent actionEvent) {

    }

    @FXML
    public void OnCreateSearchTeamDashboardButtonClick(ActionEvent event) throws IOException {
        //        scence switch to create search team.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Create_search_team.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }

    @FXML
    public void OnPreviousIncidentButtonClick(ActionEvent event)throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/Search_operator/PreviousIncident.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }

}
