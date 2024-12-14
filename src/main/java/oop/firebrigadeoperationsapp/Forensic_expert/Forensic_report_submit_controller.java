package oop.firebrigadeoperationsapp.Forensic_expert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Forensic_report_submit_controller {
    @FXML
    private DatePicker IncidentDate;

    @FXML
    private TextField IncidentLocationField;

    @FXML
    private TextField IncidentNamefield;

    @FXML
    private TextField IncidentNoField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private Label massageLabel;


    //for submitting report in Forensic report submit FXML
    @FXML
    public void OnReportSubmitButtonClick(ActionEvent event) {
        System.out.println("Submit button clicked");
        try {

            if (IncidentNoField.getText().isEmpty() || IncidentNamefield.getText().isEmpty() ||
                    descriptionField.getText().isEmpty() || IncidentDate.getValue() == null ||
                    IncidentLocationField.getText().isEmpty()) {
                massageLabel.setText("Please fill in all fields.");
                return;
            }


            ForensicReport newReport = new ForensicReport(
                    IncidentNoField.getText(),
                    IncidentNamefield.getText(),
                    descriptionField.getText(),
                    IncidentLocationField.getText(),
                    IncidentDate.getValue()
            );


            ForensicReport.getForensicreport().add(newReport);


            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/oop/firebrigadeoperationsapp/Forensic_expert/ForensicReport.bin"))) {
                oos.writeObject(ForensicReport.getForensicreport());
            }


            massageLabel.setText("Successfully submitted the forensic report.");
        } catch (IOException e) {
            massageLabel.setText("Error saving report: " + e.getMessage());
        } catch (Exception e) {
            massageLabel.setText("An unexpected error occurred: " + e.getMessage());
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
}
