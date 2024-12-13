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

public class PreviousIncidentController
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
        try {
            IncidentIdColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            incidentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            IncidentLocationColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            IncidentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            IncidentDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));


            if (IncidentReport.getIncidentReports().isEmpty()) {
                System.out.println("Adding test data...");
                IncidentReport.getIncidentReports().add(new IncidentReport("1", "Fire in Uttara", "A major fire broke out in a residential building.", LocalDate.now(), "Uttara"));
                IncidentReport.getIncidentReports().add(new IncidentReport("2", "Building Collapse in Bashundhara", "A commercial building partially collapsed.", LocalDate.now(), "Bashundhara"));
                IncidentReport.getIncidentReports().add(new IncidentReport("3", "Market Fire in Gulshan", "A fire engulfed several shops in a market.", LocalDate.now().minusDays(1), "Gulshan"));
                IncidentReport.getIncidentReports().add(new IncidentReport("4", "Road Accident in Mohakhali", "A collision between two buses caused traffic congestion.", LocalDate.now().minusDays(2), "Mohakhali"));
                IncidentReport.getIncidentReports().add(new IncidentReport("5", "Chemical Explosion in Chattogram", "A factory explosion resulted in injuries.", LocalDate.now().minusWeeks(1), "Chattogram"));
                IncidentReport.getIncidentReports().add(new IncidentReport("6", "Warehouse Fire in Keraniganj", "A fire destroyed a large warehouse.", LocalDate.now(), "Keraniganj"));
                IncidentReport.getIncidentReports().add(new IncidentReport("7", "Flood in Sylhet", "Flash floods caused severe damage to properties.", LocalDate.now().minusDays(3), "Sylhet"));
                IncidentReport.getIncidentReports().add(new IncidentReport("8", "Gas Leak in Narayanganj", "A gas leak led to a minor explosion.", LocalDate.now().minusDays(4), "Narayanganj"));
                IncidentReport.getIncidentReports().add(new IncidentReport("9", "Rescue Operation in Barishal", "Rescued fishermen trapped during a storm.", LocalDate.now().minusWeeks(2), "Barishal"));
                IncidentReport.getIncidentReports().add(new IncidentReport("10", "Train Accident in Tongi", "A train derailed causing casualties.", LocalDate.now(), "Tongi"));
                IncidentReport.getIncidentReports().add(new IncidentReport("11", "Fire in Old Dhaka", "A fire broke out in a chemical storage facility.", LocalDate.now().minusDays(5), "Old Dhaka"));
                IncidentReport.getIncidentReports().add(new IncidentReport("12", "Bridge Collapse in Rajshahi", "A small bridge collapsed due to heavy load.", LocalDate.now().minusDays(6), "Rajshahi"));
                IncidentReport.getIncidentReports().add(new IncidentReport("13", "Boat Capsize in Patuakhali", "A passenger boat capsized during heavy rainfall.", LocalDate.now(), "Patuakhali"));
                IncidentReport.getIncidentReports().add(new IncidentReport("14", "Market Fire in Khulna", "A fire gutted over 50 shops in a local market.", LocalDate.now().minusDays(7), "Khulna"));
                IncidentReport.getIncidentReports().add(new IncidentReport("15", "Landslide in Bandarban", "Heavy rainfall triggered a landslide.", LocalDate.now().minusWeeks(1), "Bandarban"));
                IncidentReport.getIncidentReports().add(new IncidentReport("16", "Factory Fire in Gazipur", "A garment factory caught fire.", LocalDate.now(), "Gazipur"));
                IncidentReport.getIncidentReports().add(new IncidentReport("17", "Building Collapse in Mirpur", "An old building collapsed due to structural weakness.", LocalDate.now().minusDays(2), "Mirpur"));
                IncidentReport.getIncidentReports().add(new IncidentReport("18", "Flood in Cox's Bazar", "Coastal areas flooded after heavy rain.", LocalDate.now(), "Cox's Bazar"));
                IncidentReport.getIncidentReports().add(new IncidentReport("19", "Power Plant Fire in Sirajganj", "A fire broke out in a power plant unit.", LocalDate.now().minusDays(3), "Sirajganj"));
                IncidentReport.getIncidentReports().add(new IncidentReport("20", "Gas Explosion in Savar", "A gas cylinder explosion injured several workers.", LocalDate.now().minusWeeks(1), "Savar"));
            }

            Incidenttableview.getItems().setAll(IncidentReport.getIncidentReports());

        }catch (Exception e) {
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
    public void OnBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_search_operator.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;
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
}