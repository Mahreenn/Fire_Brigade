package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SignUpPageController {
    @FXML
    private ComboBox<String> UserBox;
    @FXML
    private PasswordField SetPassField;
    @FXML
    private TextField SignUpNameField;
    @FXML
    private PasswordField ConfirmPassField;
    @FXML
    private Label messageLabel;
    @FXML
    private DatePicker dobDP;
    @FXML
    private TextField ContactField;

    private static final List<Employee> employeeList = new ArrayList<>();

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            while (true) {
                Employee E = (Employee) ois.readObject();
                employeeList.add(E);
            }
        } catch (IOException | ClassNotFoundException ignored) {
            // End of file or no file found is acceptable during initialization
        }
    }

    @FXML
    public void initialize() {
        UserBox.getItems().addAll(
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
    public void BackToLoginPageButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void OnSignUpButtonClick(ActionEvent event) {
        try {
            String username = SignUpNameField.getText().trim();
            if (username.isEmpty()) {
                messageLabel.setText("Username cannot be empty");
                return;
            }
            if (username.contains(" ")) {
                messageLabel.setText("Username cannot contain spaces");
                return;
            }

            String password = SetPassField.getText();
            if (!password.equals(ConfirmPassField.getText())) {
                messageLabel.setText("Passwords do not match");
                return;
            }

            LocalDate dob = dobDP.getValue();
            if (dob == null || dob.plusYears(18).isAfter(LocalDate.now())) {
                messageLabel.setText("User must be at least 18 years old!");
                return;
            }

            String contactNo = ContactField.getText().trim();
            if (contactNo.isEmpty()) {
                messageLabel.setText("Contact number cannot be empty");
                return;
            }

            // Check if username already exists
            for (Employee emp : employeeList) {
                if (emp.getUsername().equals(username)) {
                    messageLabel.setText("Username already exists");
                    return;
                }
            }

            Employee employee = new Employee(contactNo, username, password, dob);
            employeeList.add(employee);

            // Save updated employee list to file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
                for (Employee emp : employeeList) {
                    oos.writeObject(emp);
                }
            }

            messageLabel.setText("Sign up successful!");
            SignUpNameField.clear();
            SetPassField.clear();
            ConfirmPassField.clear();
            dobDP.setValue(null);
            ContactField.clear();
            UserBox.getSelectionModel().clearSelection();

        } catch (IOException e) {
            messageLabel.setText("File error: Unable to save employee data.");
        } catch (Exception e) {
            messageLabel.setText("Unexpected error occurred: " + e.getMessage());
        }
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }
}
