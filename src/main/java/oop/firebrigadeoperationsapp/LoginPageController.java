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
import java.util.List;

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
    void onLoginButtonClick(ActionEvent event) throws IOException {
        if(selectUserCombobox.getSelectionModel().getSelectedItem()==null){
            messageLabel.setText("Please Select user");
            return;
        }
        String username = UsernameTextfield.getText();
        String password = passwordTextfield.getText();
        String selectedUser = selectUserCombobox.getSelectionModel().getSelectedItem();

        List<Employee> employeeList=EmployeeManager.getEmployee();
        for(Employee e:employeeList){
            if(e.getUsername().equals(username) && e.getPassword().equals(password)){
                EmployeeManager.setLoggedInUser(e);
                messageLabel.setText("Logged in Successfully");

                if (selectedUser.equals("Dispatcher")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newDash.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;

                }
                else if(selectedUser.equals("Firefighter")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirefighterDashboard.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("EMT")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("Training officer")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("Technician ")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TechnicianDashBoard.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("Battalion Chief (Captain)")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BattalionChiefDashbard.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("Forensic Expert")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_forensic_expert.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }
                else if(selectedUser.equals("Search operator")){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard_search_operator.fxml"));
                    Parent root = fxmlLoader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    return;
                }


            }
        }



    }

}