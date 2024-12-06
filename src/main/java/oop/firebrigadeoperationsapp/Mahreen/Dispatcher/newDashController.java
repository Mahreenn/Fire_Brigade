package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
        private Label mesaageLabelw1;

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
        private TableColumn<?, ?> dateTC;

        @FXML
        private TableColumn<?, ?> locationTC;

        @FXML
        private ComboBox<?> locationcombobox;

        @FXML
        private DatePicker alertdp;


        //workflow2

        @FXML
        private TableView<?> allocationtableview;

        @FXML
        private TableView<?> allocationtableview1;

        @FXML
        private TableView<?> allocationtableview11;

        @FXML
        private TableView<?> allocationtableview111;

        @FXML
        private TableColumn<?, ?> alertidallocatedcol;

        @FXML
        private ComboBox<?> alertidcombox;

        @FXML
        private ComboBox<?> firefighterteamcombobox;




        @FXML
        private Label mesaageLabel;

        @FXML
        private Label messageLabel1;

        @FXML
        private Label messageLabel11;

        @FXML
        private Label messageLabel111;

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
        private TableColumn<?, ?> teamNoCol;

        @FXML
        private TableColumn<?, ?> teamNoCol1;

        @FXML
        private TableColumn<?, ?> teamNoCol11;

        @FXML
        private TableColumn<?, ?> teamNoCol111;



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

        }

        @FXML
        void assignteambutton(ActionEvent event) {

        }

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
        void passinfotofffromalertbutton(ActionEvent event) {

        }


        @FXML
        void sendinventorybutton(ActionEvent event) {

        }

        @FXML
        void sendtoteamButton(ActionEvent event) {

        }

        @FXML
        void updatealalertstatusbutton(ActionEvent event) {

        }

        @FXML
        void viewAlertButton(ActionEvent event) {

        }

        @FXML
        void viewalertsbutton(ActionEvent event) {

        }

        @FXML
        void viewassignmentsbutton(ActionEvent event) {

        }

        @FXML
        void viewrequestbutton(ActionEvent event) {

        }

        @FXML
        void writetofilebutton(ActionEvent event) {

        }

}
