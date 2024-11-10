package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpPageController {
    @javafx.fxml.FXML
    private ComboBox<String> UserBox;
    @javafx.fxml.FXML
    private PasswordField SetPassField;
    @javafx.fxml.FXML
    private TextField SignUpNameField;
    @javafx.fxml.FXML
    private PasswordField ConfirmPassField;
    @javafx.fxml.FXML
    private TextField SignUpMailField;
    @FXML
    public void initialize() {
        UserBox.getItems().addAll("Dispatcher","Firefighter","EMT","Training officer","Technician ","Battalion Chief (Captain)","Forensic Expert","Search operator");
    }

    @javafx.fxml.FXML
    public void BackToLoginPageButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void OnSignUpButtonClick(ActionEvent actionEvent) {

    }
}
