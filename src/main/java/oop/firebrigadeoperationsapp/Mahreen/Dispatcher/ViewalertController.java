package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.HelloApplication;
import oop.firebrigadeoperationsapp.Mahreen.Location;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ViewalertController {

    @FXML
    private CheckBox ambulanceCheckbox;

    @FXML
    private TableColumn<Alert, String> areatypeTC;

    @FXML
    private TableColumn<Alert, LocalDate> dateTC;

    @FXML
    private TableColumn<Alert, Location> locationTC;

    @FXML
    private Label messageLabel;

    @FXML
    private TableView<Alert> tableview;

    @FXML
    private TableColumn<Alert, LocalTime> timeTC;

    private ObservableList<Alert> alertList;

    public void setAlertList(ObservableList<Alert> alertList) {
        this.alertList = alertList;
        tableview.setItems(alertList);
    }

    @FXML
    public void initialize() {
        dateTC.setCellValueFactory(new PropertyValueFactory<>("dateofAlert"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("timeofAlert"));
        areatypeTC.setCellValueFactory(new PropertyValueFactory<>("areaType"));
        locationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    @FXML
    void onback(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DispatcherDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);


    }

    @FXML
    void oncontactButton(ActionEvent event) {

        messageLabel.setText(" alert sentr to Firefigheters and captains");
    }


}