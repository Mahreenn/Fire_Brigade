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

public class LoginPageController {

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private ComboBox<String> selectUserCombobox;

    @FXML
    public void initialize() {
        selectUserCombobox.getItems().addAll("Dispatcher","Firefighter","EMT","Training officer","Technician ","Battalion Chief (Captain)","Forensic Expert","Search operator");
    }

    @FXML
    void OnSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void onAlertButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("recieveAlertfromExternalUser.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void onLoginButtonClick(ActionEvent event) {
        if(selectUserCombobox.getSelectionModel().getSelectedItem()==null){
            messageLabel.setText("Please Select user");
            return;
        }
        if(UsernameTextfield.getText().equals(" ")){
            messageLabel.setText("Please enter valid username");
            return;
        }
        if(UsernameTextfield.getText().isBlank()){
            messageLabel.setText("Please enter username");
            return;
        }

        if(passwordTextfield.getText().isBlank()){
            messageLabel.setText("Please enter password");
            return;
        }

    }

}