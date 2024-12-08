package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import oop.firebrigadeoperationsapp.Mahreen.Firefighter.FirefighterDashboardController;
import oop.firebrigadeoperationsapp.Mahreen.Location;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static oop.firebrigadeoperationsapp.Mahreen.Location.fromStringToLocation;

public class newDashController {
        @FXML
        private AnchorPane updatealertstatusPANE;

        @FXML
        private AnchorPane viewrequestPANE;

        @FXML
        private AnchorPane generateReportPANE;

        @FXML
        private AnchorPane manualPANE;

        @FXML
        private AnchorPane inventoryrecordPANE;

        @FXML
        private AnchorPane sendPANE;

        @FXML
        private AnchorPane assignTeamPANE;
        
        //workflow1
        @FXML
        private AnchorPane viewAlertPANE;

        @FXML
        private Label msglblw1;

        @FXML
        private TableView<Alert> alertTableview;

        @FXML
        private TableColumn<Alert, Boolean> ambreq;

        @FXML
        private ComboBox<Boolean> ambreqCOMBOBOX;

        @FXML
        private TableColumn<Alert, String> areatypeTC;

        @FXML
        private ComboBox<String> areatypecombobox;

        @FXML
        private TableColumn<Alert , LocalDateTime> dateTC;

        @FXML
        private TableColumn<Alert, Location> locationTC;

        @FXML
        private ComboBox<String> locationcombobox;

        @FXML
        private DatePicker alertdp;


        //workflow2

        @FXML
        private TableView<Allocation> allocationtableview;

        @FXML
        private TableColumn<Allocation, Integer> alertidallocatedcol;

        @FXML
        private ComboBox<Integer> alertidcombox;

        @FXML
        private ComboBox<Integer> firefighterteamcombobox;

        @FXML
        private TableColumn<Allocation, Integer> teamNoCol;

        @FXML
        private Label msglblw2;


        //workflow 3
        @FXML
        private TableView<?> allocationtableview1;

        @FXML
        private TableView<?> allocationtableview11;

        @FXML
        private TableView<?> allocationtableview111;


        @FXML
        private Label mesaageLabel;

        @FXML
        private Label messageLabel1;

        @FXML
        private Label messageLabel11;


        @FXML
        private Label messageLabel1111;

        @FXML
        private Label messagelabel;

        @FXML
        private Label messagelabel1;

        @FXML
        private TableColumn<?, ?> noOfmembersCol;

        @FXML
        private TableColumn<?, ?> noOfmembersCol1;

        @FXML
        private TableColumn<?, ?> noOfmembersCol11;

        @FXML
        private TableColumn<?, ?> noOfmembersCol111;

        @FXML
        private TableColumn<?, ?> noOfmembersCol1111;

        @FXML
        private ComboBox<?> sendamountcombobox;

        @FXML
        private ComboBox<?> sendequipcombobox;



        @FXML
        private TableColumn<?, ?> teamNoCol1;

        @FXML
        private TableColumn<?, ?> teamNoCol11;

        @FXML
        private TableColumn<?, ?> teamNoCol111;

        public ObservableList<Alert> alertList = FXCollections.observableArrayList();
        public ObservableList<Allocation> allocationObservableList = FXCollections.observableArrayList();



        public void initialize(){
                //set invisible
            viewAlertPANE.setVisible(false);
            assignTeamPANE.setVisible(false);
            updatealertstatusPANE.setVisible(false);
            viewrequestPANE.setVisible(false);
            inventoryrecordPANE.setVisible(false);
            sendPANE.setVisible(false);
            generateReportPANE.setVisible(false);
            manualPANE.setVisible(false);


            //wokrkflow1
            alertdp.setValue(LocalDate.now());
            areatypecombobox.getItems().addAll("Residential","Industrial", "Commercial","Densely populated","Road");
            ambreqCOMBOBOX.getItems().addAll(true, false);
            locationcombobox.getItems().addAll("Uttara","Dhanmondi","Bashundhara","Mirpur");
            locationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
            areatypeTC.setCellValueFactory(new PropertyValueFactory<>("areaType"));
            dateTC.setCellValueFactory(new PropertyValueFactory<>("dateofAlert"));
            ambreq.setCellValueFactory(new PropertyValueFactory<>("ambulanceReq"));


            //wokrflow2
                firefighterteamcombobox.getItems().addAll(1,2,3,4,5);
                for (Alert alert : alertList) {
                        alertidcombox.getItems().add(alert.getAlertID());
                }
        }

       //workflow1
        @FXML
        void viewAlertButton(ActionEvent event) {
                viewAlertPANE.setVisible(true);
                assignTeamPANE.setVisible(false);
                updatealertstatusPANE.setVisible(false);
                viewrequestPANE.setVisible(false);
                inventoryrecordPANE.setVisible(false);
                sendPANE.setVisible(false);
                generateReportPANE.setVisible(false);
                manualPANE.setVisible(false);
        }

        @FXML
        void viewalertsbutton(ActionEvent event) {
                if(alertdp.getValue().isAfter(LocalDate.now())){
                        msglblw1.setText("Incident date cannot be in Future");
                }
                if(areatypecombobox.getSelectionModel().getSelectedItem()==null){
                        msglblw1.setText("make area type Selection ");
                }

                LocalDate  incidentdate = alertdp.getValue();
                String incidentloc =   locationcombobox.getValue();
                Location loc =  fromStringToLocation(incidentloc);
                String area = areatypecombobox.getValue();
                Boolean ambRequest = ambreqCOMBOBOX.getValue();

                Alert newAlert = new Alert(incidentdate, area, ambRequest, loc);

                alertList.add(newAlert);
                alertTableview.getItems().addAll((alertList));
        }

        @FXML
        void passinfotofffromalertbutton(ActionEvent event)throws IOException {
                ObjectOutputStream oos = null;
                if (! alertTableview.getItems().isEmpty()) {

                        try {
                                oos = new ObjectOutputStream(new FileOutputStream("alerts.bin", true));
                                for(Alert a:alertList){
                                        oos.writeObject(a);
                                }
                                alertList.clear();
                                msglblw1.setText("object written to alerts.bin");

                        } catch (IOException e) {
                                msglblw1.setText("error!");
                        }
                        finally {
                                if (oos!=null){
                                        oos.close();
                                }
                        }
                }else {
                        msglblw1.setText("No data to write!");
                }
        }

        //workflow 2
        @FXML
        void assignteambutton(ActionEvent event) {
                viewAlertPANE.setVisible(false);
                assignTeamPANE.setVisible(true);
                updatealertstatusPANE.setVisible(false);
                viewrequestPANE.setVisible(false);
                inventoryrecordPANE.setVisible(false);
                sendPANE.setVisible(false);
                generateReportPANE.setVisible(false);
                manualPANE.setVisible(false);
        }

        @FXML
        void viewassignmentsbutton(ActionEvent event) {

        }

//        @FXML
//        void sendtoteamButton(ActionEvent event) {
//                for(Allocation a: allocationObservableList){
//                    FirefighterDashboardController.respondToAlert(a);
//                }
//        }


       //workflow3
        @FXML
        void filterbutton(ActionEvent event) {

        }

        @FXML
        void generateincidentreportbutton(ActionEvent event) {

        }

        @FXML
        void inventoryrecordbutton(ActionEvent event) {

        }

        @FXML
        void loaddatabutton(ActionEvent event) {

        }

        @FXML
        void logoutButon(ActionEvent event) {

        }

        @FXML
        void manualbutton(ActionEvent event) {

        }


        @FXML
        void sendinventorybutton(ActionEvent event) {

        }


        @FXML
        void updatealalertstatusbutton(ActionEvent event) {

        }


        @FXML
        void viewrequestbutton(ActionEvent event) {

        }

        @FXML
        void writetofilebutton(ActionEvent event) {

        }

}
