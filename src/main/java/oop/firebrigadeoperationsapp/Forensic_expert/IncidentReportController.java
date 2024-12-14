package oop.firebrigadeoperationsapp.Forensic_expert;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class IncidentReportController {

    @FXML
    private TableColumn<IncidentReport,String> IncidentLocationColumn;
    @FXML
    private TableColumn<IncidentReport,String> IncidentDescriptionColumn;
    @FXML
    private TableView<IncidentReport> Incidenttableview;
    @FXML
    private TableColumn<IncidentReport,String> IncidentIdColumn;
    @FXML
    private TableColumn<IncidentReport, LocalDate> IncidentDateColumn;
    @FXML
    private TableColumn<IncidentReport,String> incidentNameColumn;

    @FXML
    public void initialize() {
        try {
            IncidentIdColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("ID"));
            incidentNameColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("name"));
            IncidentLocationColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("location"));
            IncidentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,String>("description"));
            IncidentDateColumn.setCellValueFactory(new PropertyValueFactory<IncidentReport,LocalDate>("date"));


            if (IncidentReport.getIncidentReports().isEmpty()) {
                System.out.println("Adding test data...");
                IncidentReport.getIncidentReports().add(new IncidentReport("1", "Fire in Uttara", "A major fire broke out in a residential building.", LocalDate.now(), "Uttara"));
                IncidentReport.getIncidentReports().add(new IncidentReport("2", "Building Collapse in Bashundhara", "A commercial building partially collapsed.", LocalDate.now(), "Bashundhara"));
                IncidentReport.getIncidentReports().add(new IncidentReport("3", "Market Fire in Gulshan", "A fire engulfed several shops in a market.", LocalDate.now().minusDays(1), "Gulshan"));
            }


            // Adding data to the TableView
            Incidenttableview.getItems().addAll(IncidentReport.getIncidentReports());
            System.out.println("Initialization completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("dashboard_forensic_expert.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void LogOutButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/LoginPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void OnDownloadButtonClick(ActionEvent Event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Documents", "*.pdf")
        );

        // Show save dialog
        Stage stage = (Stage) ((Node) Event.getSource()).getScene().getWindow();
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
}
