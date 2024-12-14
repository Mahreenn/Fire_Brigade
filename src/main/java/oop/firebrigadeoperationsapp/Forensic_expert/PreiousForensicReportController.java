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
    private TableColumn<ForensicReport,String> ReportDescriptionColoum;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> ReportNameColumn;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> reportIdColumn;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport,String> ReportLocationColumn;
    @javafx.fxml.FXML
    private TableView<ForensicReport> ReportTableview;
    @javafx.fxml.FXML
    private TableColumn<ForensicReport, LocalDate> ReportDateColumn;

    @javafx.fxml.FXML
    public void initialize() {
        try {
//        System.out.println("Initializing TableView...");

            reportIdColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("ForensicReportID"));
            ReportNameColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("ForensicReportname"));
            ReportLocationColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("IncidentLocation"));
            ReportDescriptionColoum.setCellValueFactory(new PropertyValueFactory<ForensicReport,String>("ForensicReportdescription"));
            ReportDateColumn.setCellValueFactory(new PropertyValueFactory<ForensicReport,LocalDate>("IncidentDate"));

            if (ForensicReport.getForensicreport().isEmpty()) {
                System.out.println("Adding test data...");
                ForensicReport.getForensicreport().add(new ForensicReport("1", "Chemical Analysis of Fire Debris", "The analysis confirmed traces of accelerants indicating arson.", "Uttara", LocalDate.now().minusDays(2)));
                ForensicReport.getForensicreport().add(new ForensicReport("2", "Explosion Residue Analysis", "Residue analysis identified ammonium nitrate as the primary component.", "Bashundhara", LocalDate.now().minusWeeks(1)));
                ForensicReport.getForensicreport().add(new ForensicReport("3", "Structural Integrity Assessment", "Forensic assessment revealed a weak foundation and faulty design.", "Mirpur", LocalDate.now().minusMonths(1)));
                ForensicReport.getForensicreport().add(new ForensicReport("4", "DNA Analysis of Victims", "DNA analysis was performed to identify victims of the factory fire.", "Gazipur", LocalDate.now().minusDays(5)));
                ForensicReport.getForensicreport().add(new ForensicReport("5", "Toxic Gas Identification", "Toxicology reports detected the presence of hydrogen sulfide in the vicinity.", "Chattogram", LocalDate.now()));
            }


            ReportTableview.getItems().addAll(ForensicReport.getForensicreport());
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
            for (ForensicReport report : ReportTableview.getSelectionModel().getSelectedItems()) {
                table.addCell(report.getForensicReportID())
                        .addCell(report.getForensicReportname())
                        .addCell(report.getIncidentLocation())
                        .addCell(report.getForensicReportdescription())
                        .addCell(report.getIncidentDate().toString());
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/Forensic_expert/dashboard_forensic_expert.fxml"));
        Parent root;
        root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
    }
}