package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

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
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class viewDetailsController {

    ArrayList<Firefighter> FirefighterTeam = new ArrayList<>();
    @FXML
    private Label messagelabel;

    @FXML
    void downloaddetailsbutton(ActionEvent event)throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Documents", "*.pdf")
        );

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showSaveDialog(stage);
        if (selectedFile == null) {
            return;
        }

        messagelabel.setText("");
        PdfWriter writer = new PdfWriter(selectedFile);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Table table = new Table(new float[]{3, 3, 1});
        table.setWidth(UnitValue.createPercentValue(100));

        table.addHeaderCell("Username")
                .addHeaderCell("Contact")
                .addHeaderCell("Age");

        for (Firefighter u: FirefighterTeam ) {
            table.addCell(u.getUsername())
                    .addCell(u.getContact())
                    .addCell("" + u.getAge());
        }

        document.add(table);

        document.close();
        messagelabel.setText("PDF created successfully at " + selectedFile.getAbsolutePath());

    }

    @FXML
    void backbutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirefighterDashboard.fxml"));
        Parent root;
        root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        return;

    }

}
