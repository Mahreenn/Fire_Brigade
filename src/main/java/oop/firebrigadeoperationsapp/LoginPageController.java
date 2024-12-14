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
    private TextField UsernameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label LoginMessageLabel;

    @FXML
    private ComboBox<String> selectUserCombobox;

    @FXML
    public void initialize() {
        // Adding roles to the combo box
        selectUserCombobox.getItems().addAll(
                "Dispatcher",
                "Firefighter",
                "EMT",
                "Training officer",
                "Technician",
                "Battalion Chief (Captain)",
                "Forensic Expert",
                "Search operator"
        );
    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        // Get input values
        String username = UsernameField.getText().trim();
        String password = PasswordField.getText();
        String selectedRole = selectUserCombobox.getSelectionModel().getSelectedItem();

        // Check for empty fields
        if (username.isEmpty() || password.isEmpty()) {
            LoginMessageLabel.setText("Username or Password cannot be empty");
            return;
        }
        if (selectedRole == null) {
            LoginMessageLabel.setText("Please select a role");
            return;
        }

        // Authenticate user
        List<Employee> employeeList = EmployeeManager.getEmployees();
        for (Employee employee : employeeList) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                // Set the logged-in user
                EmployeeManager.setLoggedInUser(employee);
                LoginMessageLabel.setText("Login successful");

                // Open the respective dashboard
                openDashboard(selectedRole, event);
                return;
            }
        }

        // If authentication fails
        LoginMessageLabel.setText("Invalid username or password");
    }

    private void openDashboard(String role, ActionEvent event) throws IOException {
        String fxmlFile = null;

        // Determine the correct dashboard file
        if (role.equals("Dispatcher")) {
            fxmlFile = "/oop/firebrigadeoperationsapp/Mahreen2311459/Dispatcher/newDash.fxml";
        } else if (role.equals("Firefighter")) {
            fxmlFile = "/oop/firebrigadeoperationsapp/Mahreen2311459/Firefighter/FirefighterDashboard.fxml";
        } else if (role.equals("EMT") || role.equals("Training officer")) {
            fxmlFile = "dashboard.fxml";
        } else if (role.equals("Technician")) {
            fxmlFile = "Technician/TechnicianDashBoard.fxml";
        } else if (role.equals("Battalion Chief (Captain)")) {
            fxmlFile = "BattalionChief/BattalionChiefDashbard.fxml";
        } else if (role.equals("Forensic Expert")) {
            fxmlFile = "forensic_expert/dashboard_forensic_expert.fxml";
        } else if (role.equals("Search operator")) {
            fxmlFile = "Search_operator/dashboard_search_operator.fxml";
            System.out.println(getClass().getResource(fxmlFile));
        }

        if (fxmlFile != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                LoginMessageLabel.setText("Error loading the dashboard.");
            }
        } else {
            LoginMessageLabel.setText("Dashboard for this role is not implemented yet.");
        }
    }



    public void OnSignUpButtonClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            LoginMessageLabel.setText("Error loading the sign-up page.");
        }

    }

    public void onAlertButtonClick(ActionEvent event) {

    }
}
