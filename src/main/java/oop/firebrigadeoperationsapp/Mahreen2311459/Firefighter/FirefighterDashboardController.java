package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.HelloApplication;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.Allocation;

import java.io.IOException;

public class FirefighterDashboardController {

    @FXML
    private AnchorPane respondtoAlertPANE;

    @FXML
    private TableView<Allocation> allocationTableView;

    @FXML
    private TableColumn<Allocation, Integer> teamColumn;
    @FXML
    private TableColumn<Allocation, Integer> alertidColumn;

    private ObservableList<Allocation> allocationObservableList;

    public void setAllocations(ObservableList<Allocation> allocations) {
        this.allocationObservableList = allocations;
    }

    @FXML
    void RespondtoAlertButton(ActionEvent event) {
        respondtoAlertPANE.setVisible(true);
    }

    @FXML
    public void showallocationsButtion(ActionEvent event) {
        if (allocationObservableList != null && !allocationObservableList.isEmpty()) {

        } else {

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


}