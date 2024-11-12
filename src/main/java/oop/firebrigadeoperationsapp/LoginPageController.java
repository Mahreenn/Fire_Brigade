package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private PasswordField passwordfield;

    String username, password;


    @FXML
    void OnSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

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
