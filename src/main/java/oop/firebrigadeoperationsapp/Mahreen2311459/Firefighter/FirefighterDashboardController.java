package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.Allocation;

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
    void logoutButon(ActionEvent event) {

    }


}