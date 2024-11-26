package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Label massageLabel;
    @FXML
    private Label massageLable;

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
    }

    @javafx.fxml.FXML
    public void OnSignUpButtonClick(ActionEvent event) {
//        create a user  after getting the data from the user and set text in te massageLabel


        massageLabel.setText("Sign in successful");

    }
}
