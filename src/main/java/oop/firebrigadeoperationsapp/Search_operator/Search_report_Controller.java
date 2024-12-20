package oop.firebrigadeoperationsapp.Search_operator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
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

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Search_report_Controller {


    @FXML
    private TableColumn<SearchReport,String> DescriptionColoum;

    @FXML
    private TableColumn<SearchReport,String> IncidentNameColumn;

    @FXML
    private TableColumn<SearchReport,String> LocationColumn;

    @FXML
    private TableColumn<SearchReport, LocalDate> dateColumn;

    @FXML
    private TableColumn<SearchReport,String> incidentIdColumn;

    @FXML
    private TableView<SearchReport> tableview;


    public void initialize() {
        try {
            incidentIdColumn.setCellValueFactory(new PropertyValueFactory<SearchReport, String>("ID"));
            IncidentNameColumn.setCellValueFactory(new PropertyValueFactory<SearchReport, String>("name"));
            LocationColumn.setCellValueFactory(new PropertyValueFactory<SearchReport, String>("location"));
            DescriptionColoum.setCellValueFactory(new PropertyValueFactory<SearchReport, String>("description"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<SearchReport,LocalDate>("date"));


            if (SearchReport.getSearchreport().isEmpty()) {
                System.out.println("Adding test data...");
                SearchReport.getSearchreport().add(new SearchReport("1", "Fire in uttora", "Major fire incident", LocalDate.now(), "Downtown"));
                SearchReport.getSearchreport().add(new SearchReport("2", "fire in basundhara ", "Rescued trapped workers", LocalDate.now().minusDays(1), "Suburbs"));
            }

            tableview.getItems().addAll(SearchReport.getSearchreport());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void OnDownloadButtonClick(ActionEvent actionEvent) {
        // pdf download
        // Open FileChooser to select save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Documents", "*.pdf")
        );


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(stage);

        if (selectedFile == null) {

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
    public void OnBackButtonClick(ActionEvent event) throws IOException {
        //        scence switch to Profile.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_search_operator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;


    }
}
