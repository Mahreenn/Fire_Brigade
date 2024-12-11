package oop.firebrigadeoperationsapp.Forensic_expert;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.Search_operator.SearchReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class PreiousForensicReportController
{
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> DescriptionColoum;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> IncidentNameColumn;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> incidentIdColumn;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> LocationColumn;
    @javafx.fxml.FXML
    private TableView<ForensicReport> tableview;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport, LocalDate> dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
        try {
//        System.out.println("Initializing TableView...");

            incidentIdColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("ID"));
            IncidentNameColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("name"));
            LocationColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("location"));
            DescriptionColoum.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("description"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,LocalDate>("date"));

            if (SearchReport.getSearchreport().isEmpty()) {
                System.out.println("Adding test data...");
                SearchReport.getSearchreport().add(new SearchReport("1", "Fire in uttora", "Major fire incident", LocalDate.now(), "Downtown"));
                SearchReport.getSearchreport().add(new SearchReport("2", "fire in basundhara ", "Rescued trapped workers", LocalDate.now().minusDays(1), "Suburbs"));
            }

            tableview.getItems().addAll(ForensicReport.getForensicreport());
            System.out.println("Initialization completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void OnDownloadButtonClick(ActionEvent actionEvent) {
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
            for (ForensicReport report : tableview.getSelectionModel().getSelectedItems()) {
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

    @javafx.fxml.FXML
    public void OnLogOutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/LoginPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }

    @javafx.fxml.FXML
    public void OnBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("oop/firebrigadeoperationsapp/Forensic_expert/dashboard_forensic_expert.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }
}