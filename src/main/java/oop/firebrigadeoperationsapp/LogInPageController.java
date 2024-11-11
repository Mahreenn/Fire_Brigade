package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LogInPageController {
    @FXML
    private ComboBox<String> selectUserCombobox;

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField passwordTextfield;

    ArrayList<Employee> empList = new ArrayList<>();

    @FXML
    public void initialize() {
        selectUserCombobox.getItems().addAll("Dispatcher","Firefighter","EMT","Training officer","Technician ","Battalion Chief (Captain)","Forensic Expert","Search operator");
    }


    @FXML
    void OnSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUpPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }



@FXML
void onLoginButtonClick(ActionEvent event) throws IOException {

    if( UsernameTextfield.getText().isBlank()){
        messageLabel.setText("Please enter username");
        return;
    }
    if( passwordTextfield.getText().isBlank()){
        messageLabel.setText("Please enter username");
        return;
    }
    if(selectUserCombobox.getSelectionModel().getSelectedItem()==null){
        messageLabel.setText("Please select user");
        return;
    }

    String username = UsernameTextfield.getText();
    String password = passwordTextfield.getText();
    String usertype = selectUserCombobox.getValue();
    for (Employee i :  empList ){

        if (username.equals(i.getUsername()) && password.equals(i.getPassword())) {
            if(usertype == "Dispatcher"){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dispatcherdashboard.fxml"));
                Parent root = fxmlLoader.load();

                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
            }
        }
    }

}

@FXML
void onAlertButtonClick(ActionEvent event) {

    }

}