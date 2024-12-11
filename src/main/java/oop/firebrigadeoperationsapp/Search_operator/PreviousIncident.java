package oop.firebrigadeoperationsapp.Search_operator;

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
import oop.firebrigadeoperationsapp.Forensic_expert.IncidentReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class PreviousIncident
{
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> IncidentLocationColumn;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> IncidentDescriptionColumn;
    @javafx.fxml.FXML
    private TableView<IncidentReport> Incidenttableview;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> IncidentIdColumn;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, LocalDate> IncidentDateColumn;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport,String> incidentNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
        IncidentIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        incidentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        IncidentLocationColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        IncidentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        IncidentDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        Incidenttableview.getItems().setAll(IncidentReport.getincidentReports());

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
            for (IncidentReport report : Incidenttableview.getSelectionModel().getSelectedItems()) {
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
    public void onbackbuttonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_search_operator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }

    @javafx.fxml.FXML
    public void OnlogOutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/LoginPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }
}