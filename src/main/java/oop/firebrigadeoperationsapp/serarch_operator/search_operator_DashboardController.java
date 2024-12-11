package oop.firebrigadeoperationsapp.serarch_operator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import static com.itextpdf.kernel.pdf.PdfName.Document;

public class search_operator_DashboardController {


    @FXML
    private TableColumn<SearchReport,String> DescriptionColoum;
    @FXML
    private TableColumn<SearchReport,String> IncidentNameColumn;
    @FXML
    private TableColumn<SearchReport,String> incidentIdColumn;
    @FXML
    private TableColumn<SearchReport,String> LocationColumn;
    @FXML
    private TableView<SearchReport> tableview;
    @FXML
    private TableColumn<SearchReport,LocalDate> dateColumn;

    public void initialize() {
        incidentIdColumn.setCellValueFactory(new PropertyValueFactory<>("IncidentId"));
        IncidentNameColumn.setCellValueFactory(new PropertyValueFactory<>("IncidentName"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
        DescriptionColoum.setCellValueFactory(new PropertyValueFactory<>("Description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));

        tableview.getItems().addAll(SearchReport.getSearchreport());
    }

    @FXML
    public void OnProfileButtonClick(ActionEvent event) throws IOException {
        //        scence switch to Profile.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
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
    public void OnReportSubmissionButtonClick(ActionEvent actionEvent) { //this button has no work
        //        scence switch to reportSubmission_search_operator.fxml

    }

    @javafx.fxml.FXML
    public void OnLogOutButtonClick(ActionEvent event) throws IOException {
        //        scence switch to LoginPage.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;

    }

    @FXML
    public void OnEmergencyButtonClick(ActionEvent event) throws IOException {
        //        scence switch to emergency_searchOperator.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emergency_searchOperator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;


    }


    @FXML
    public void OnDownloadButtonClick(ActionEvent actionEvent) {
//        pdf download
        // Open FileChooser to select save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Documents", "*.pdf")
        );

        // Show save dialog
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile == null) {
            // User canceled the save dialog
            return;
        }

        try {
            // Initialize PDF writer
            PdfWriter writer = new PdfWriter(selectedFile);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Create a table with columns
            Table table = new Table(new float[]{3, 2, 2, 3, 2});
            table.setWidth(UnitValue.createPercentValue(100));

            // Add headers
            table.addHeaderCell("Incident ID")
                    .addHeaderCell("Incident Name")
                    .addHeaderCell("Location")
                    .addHeaderCell("Description")
                    .addHeaderCell("Date");

            // Add data for selected rows in the TableView
            for (SearchReport report : tableview.getSelectionModel().getSelectedItems()) {
                table.addCell(report.getID())
                        .addCell(report.getName())
                        .addCell(report.getLocation())
                        .addCell(report.getDescription())
                        .addCell(report.getDate().toString());
            }

            // Add table to document
            document.add(table);

            // Close document
            document.close();

            // Show success message
            System.out.println("PDF created successfully at " + selectedFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while creating PDF: " + e.getMessage());
        }
    }

    @FXML
    public void LoadPreviousSearchOperationButtonClick(ActionEvent actionEvent) {


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

    @FXML
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
}
