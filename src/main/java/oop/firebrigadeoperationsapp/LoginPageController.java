package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPageController {

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordTextfield;


    @FXML
    void OnSignUpButtonClick(ActionEvent event) {
        String username = UsernameTextfield.getText();
        if( username.isBlank()){
            messageLabel.setText("Please enter username");
        }

    }

    @FXML
    void onLoginButtonClick(ActionEvent event) {

    }

}
