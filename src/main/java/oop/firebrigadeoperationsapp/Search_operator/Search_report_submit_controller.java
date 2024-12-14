package oop.firebrigadeoperationsapp.Search_operator;

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
import java.util.ArrayList;
import java.util.List;

public class Search_report_submit_controller {
    @FXML
    private TextField IncidentLocationField;
    @FXML
    private TextField IncidentNamefield;
    @FXML
    private TextField IncidentNoField;
    @FXML
    private DatePicker IncidentDate;
    @FXML
    private Label massageLabel;
    @FXML
    private TextArea descriptionField;

    private static final List<SearchReport> searchReports = new ArrayList<>();

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


            SearchReport newReport = new SearchReport(
                    IncidentNoField.getText(),
                    IncidentNamefield.getText(),
                    descriptionField.getText(),
                    IncidentDate.getValue(),
                    IncidentLocationField.getText()
            );


            searchReports.add(newReport);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/oop/firebrigadeoperationsapp/Search_operator/SearchReport.bin"))) {
                oos.writeObject(searchReports);
            }

            massageLabel.setText("Successfully reported.");
        } catch (IOException e) {

            massageLabel.setText("Error saving report: " + e.getMessage());
        } catch (Exception e) {

            massageLabel.setText("An unexpected error occurred: " + e.getMessage());
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
