package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.HelloApplication;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.Allocation;

import java.io.*;

public class FirefighterDashboardController {
    @FXML
    private Label messageLabel1;

    @FXML
    private AnchorPane respondtoAlertPANE;

    @FXML
    private TableColumn<Allocation, Integer> allocatedTeamTC;

    @FXML
    private TableColumn<Allocation, Integer> allocatedalertTC;

    @FXML
    private TableView<Allocation> alocationTableView;

    public void initialize() {
        allocatedTeamTC.setCellValueFactory(new PropertyValueFactory<>("alertid"));
        allocatedalertTC.setCellValueFactory(new PropertyValueFactory<>("teamno"));
    }

    @FXML
    void RespondtoAlertButton(ActionEvent event) {
        respondtoAlertPANE.setVisible(true);
    }

    @FXML
    public void showallocationsbutton(ActionEvent event)throws IOException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Allocations.bin"));
            Allocation a;
            alocationTableView.getItems().clear();

            while (true) {
                try {
                    a = (Allocation) ois.readObject();
                    alocationTableView.getItems().add(a);
                }
                catch (EOFException e) {
                  messageLabel1.setText("success");
                  break;
                }
            }
        } catch (ClassNotFoundException e) {
            messageLabel1.setText("Allocation class not found.");
        } catch (FileNotFoundException e) {
            messageLabel1.setText("File not found.");
        } catch (IOException e) {
            messageLabel1.setText("Could not read allocations.");
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
    @FXML
    void logoutButon(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void makeequipmentrequestbutton(ActionEvent event) {

    }


    @FXML
    void updateemeregncybutton(ActionEvent event) {

    }

    @FXML
    void viewcertbUTTON(ActionEvent event) {

    }

    @FXML
    void viewincidenreportButton(ActionEvent event) {

    }
}