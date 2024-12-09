package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import java.io.*;

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
import oop.firebrigadeoperationsapp.AppendableObjectOutputStream;
import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static oop.firebrigadeoperationsapp.Mahreen2311459.Location.fromStringToLocation;

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
        private TableColumn<Alert, Boolean> ambreqTC;

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
        private Label msglblw3;

        @FXML
        private TableColumn<Alert, String> statTC;

        @FXML
        private TableView<Alert> statusTableview;

        @FXML
        private TableColumn<Alert, Integer> alrtTC;


        @FXML
        private TableView<?> allocationtableview11;


        @FXML
        private Label msglblw4;

        @FXML
        private Label msglblw5;


        @FXML
        private Label msglblw6;

        @FXML
        private Label msglblw7;

        @FXML
        private Label msglblw8;

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

        private Alert edittedalert;

        public void setEdittedalert(Alert edittedalert) {
            this.edittedalert = edittedalert;
        }

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
            ambreqTC.setCellValueFactory(new PropertyValueFactory<>("ambulanceReq"));


            //wokrflow2
                firefighterteamcombobox.getItems().addAll(1,2,3,4,5);

                if (!alertList.isEmpty()) {
                    for (Alert alert : alertList) {
                        alertidcombox.getItems().add(alert.getAlertID());
                    }
                }
                teamNoCol.setCellValueFactory(new PropertyValueFactory<>("alertid"));
                alertidallocatedcol.setCellValueFactory(new PropertyValueFactory<>("teamno"));

        }

       //workflow1
        @FXML
        public void viewAlertButton(ActionEvent actionEvent) throws Exception {
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
        void createfilebutton(ActionEvent event)throws IOException {
                ObjectOutputStream oos = null;
                if (! alertTableview.getItems().isEmpty()) {

                        try {
                                oos = new AppendableObjectOutputStream(new FileOutputStream("alerts.bin", true));
                                for(Alert a:alertTableview.getItems()){
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
        public void assignteambutton(ActionEvent actionEvent)throws Exception{
            System.out.println(" error");
                viewAlertPANE.setVisible(false);
                assignTeamPANE.setVisible(true);
                updatealertstatusPANE.setVisible(false);
                viewrequestPANE.setVisible(false);
                inventoryrecordPANE.setVisible(false);
                sendPANE.setVisible(false);
                generateReportPANE.setVisible(false);
                manualPANE.setVisible(false);
        }

      //  public ObservableList<Allocation> allocationObservableList = FXCollections.observableArrayList();
        @FXML
        void viewassignmentsbutton(ActionEvent event) throws IOException {
            if (firefighterteamcombobox.getValue() != null && alertidcombox.getValue() != null) {
                int team = firefighterteamcombobox.getValue();
                int id = alertidcombox.getValue();
                Allocation a = new Allocation(team, id);
                allocationtableview.getItems().add(a);
            } else {
                msglblw2.setText("Please select a team and alert ID.");
            }

            if (allocationtableview.getItems().isEmpty()) {
                msglblw2.setText(" ");
                msglblw2.setText("no allocations made");
            } else {
                ObjectOutputStream oos = null;
                try {
                    oos = new AppendableObjectOutputStream(new FileOutputStream("Allocations.bin"));
                    for (Allocation a : allocationtableview.getItems()) {
                        oos.writeObject(a);
                    }
                } catch (IOException e) {
                    msglblw2.setText(" Error ");
                } finally {
                    if (oos != null) {
                        oos.close();
                    }
                }
            }
        }


    //workflow3
    @FXML
    public void updatealalertstatusbutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(true);
        viewrequestPANE.setVisible(false);
        inventoryrecordPANE.setVisible(false);
        sendPANE.setVisible(false);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);
    }

    @FXML
    void loadalertsbutton(ActionEvent event) throws IOException {
        ObjectInputStream ois = null;
        Alert a = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("alerts.bin"));
            while(true){
                a = (Alert)ois.readObject();
                //load in table view
                statusTableview.getItems().add(a);
            }
        }
        catch(ClassNotFoundException e){
            msglblw3.setText("Invalid user file format!");
        }
        catch (IOException e){
            msglblw3.setText(" Error");
        }

        finally {
            if (ois != null)
                ois.close();
        }
    }

    @FXML
    void updatebutton(ActionEvent event) {

    }

    //workflow4
    @FXML
    public void viewrequestbutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(false);
        viewrequestPANE.setVisible(true);
        inventoryrecordPANE.setVisible(false);
        sendPANE.setVisible(false);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);

    }

    //workflow5
    @FXML
    public void inventoryrecordbutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(false);
        viewrequestPANE.setVisible(false);
        inventoryrecordPANE.setVisible(true);
        sendPANE.setVisible(false);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);

    }

    //workflow6
    @FXML
    public void sendinventorybutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(false);
        viewrequestPANE.setVisible(false);
        inventoryrecordPANE.setVisible(false);
        sendPANE.setVisible(true);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);
    }




    //workflow7
        @FXML
        public void generateincidentreportbutton(ActionEvent event) {
            viewAlertPANE.setVisible(false);
            assignTeamPANE.setVisible(false);
            updatealertstatusPANE.setVisible(false);
            viewrequestPANE.setVisible(false);
            inventoryrecordPANE.setVisible(false);
            sendPANE.setVisible(false);
            generateReportPANE.setVisible(true);
            manualPANE.setVisible(false);
        }



        @FXML
        void loaddatabutton(ActionEvent event) {

        }

        @FXML
        void logoutButon(ActionEvent event) {

        }

    //workflow8
        @FXML
        public void manualbutton(ActionEvent event) {
            viewAlertPANE.setVisible(false);
            assignTeamPANE.setVisible(false);
            updatealertstatusPANE.setVisible(false);
            viewrequestPANE.setVisible(false);
            inventoryrecordPANE.setVisible(false);
            sendPANE.setVisible(false);
            generateReportPANE.setVisible(false);
            manualPANE.setVisible(true);

        }



}
