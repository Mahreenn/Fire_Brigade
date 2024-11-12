package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;




public class LoginPageController {

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private Label messageLabel;
    @FXML
    private PasswordField passwordfield;

    String username, password;


    @FXML
    void OnSignUpButtonClick(ActionEvent event){
    }

    @FXML
    void onLoginButtonClick(ActionEvent event) {

        if( !username.isEmpty()){
            username= UsernameTextfield.getText();

        }else {
            messageLabel.setText("Please enter username");
        }
        if( !password.isEmpty()){
            password= passwordfield.getText();

        }else {
            messageLabel.setText("Please enter password");
        }

    }

}
