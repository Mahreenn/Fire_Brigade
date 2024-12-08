package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SignUpPageController {
    @javafx.fxml.FXML
    private ComboBox<String> UserBox;
    @javafx.fxml.FXML
    private PasswordField SetPassField;
    @javafx.fxml.FXML
    private TextField SignUpNameField;
    @javafx.fxml.FXML
    private PasswordField ConfirmPassField;
    @FXML
    private Label massageLabel;
    @FXML
    private DatePicker dobDP;
    @FXML
    private TextField ContactField;

    @FXML
    public void initialize() {
        UserBox.getItems().addAll("Dispatcher","Firefighter","EMT","Training officer","Technician ","Battalion Chief (Captain)","Forensic Expert","Search operator");
    }

    @javafx.fxml.FXML
    public void BackToLoginPageButton(ActionEvent event)  throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @javafx.fxml.FXML
    public void OnSignUpButtonClick(ActionEvent event) {
//        create a user  after getting the data from the user and set text in te massageLabel
        try {
            String username = SignUpNameField.getText();
            if (username.isBlank() || username.isEmpty()) {
                massageLabel.setText("Username cannot be empty");
                return;
            }
            if(username.contains(" ")){
                massageLabel.setText("Username cannot contain spaces");
                return;
            }

            if (!SetPassField.getText().equals(ConfirmPassField.getText())) {
                massageLabel.setText("Passwords do not match");
                return;
            }
            String password = ConfirmPassField.getText();


            LocalDate dob = dobDP.getValue();
            if (dob == null || dob.plusYears(18).isAfter(LocalDate.now())){
                massageLabel.setText("User must be at least 18 years old!");
                return;
            }
            String contactNo = ContactField.getText();
            if (contactNo.isBlank() || contactNo.isEmpty()) {
                massageLabel.setText("Contact number cannot be empty");
                return;
            }

            Employee employee = new Employee( contactNo,username, password,dob );

        }
        catch (NumberFormatException e){
            massageLabel.setText("Invalid age!");
        }


        massageLabel.setText("Sign in successful");

    }
}
