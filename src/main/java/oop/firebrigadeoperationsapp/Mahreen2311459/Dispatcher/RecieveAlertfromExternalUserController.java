package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import static oop.firebrigadeoperationsapp.Mahreen2311459.Location.fromStringToLocation;

public class RecieveAlertfromExternalUserController {

    @FXML
    private ComboBox<Boolean> ambulancereqCombobox;

    @FXML
    private ComboBox<String> areaTypeCombobox;

    @FXML
    private ComboBox<String> locationCombobox;

  //  @FXML
  //  private TextField incidenttimetf;

    @FXML
    private DatePicker incidentdatdp;


    @FXML
    private Label messageLabel;

  //  private ObservableList<Alert> alertList = FXCollections.observableArrayList();

 //   public void setAlertList(ObservableList<Alert> alertList) {
  //      this.alertList = alertList;}

    @FXML
    public void initialize(){
        incidentdatdp.setValue(LocalDate.now());
        areaTypeCombobox.getItems().addAll("Residential","Industrial", "Commercial","Densely populated","Road");
        ambulancereqCombobox.getItems().addAll(true, false);
        locationCombobox.getItems().addAll("Uttara","Dhanmondi","Bashundhara","Mirpur");
    }



    @FXML
    void OnsubmitAlertButtonClick(ActionEvent event) throws IOException {
        if(incidentdatdp.getValue().isAfter(LocalDate.now())){
            messageLabel.setText("Incident date cannot be in Future");
        }
        //deptCB.getSelectionModel().getSelectedItem() == null
        if(areaTypeCombobox.getSelectionModel().getSelectedItem()==null){
            messageLabel.setText("make Selection ");
        }
        LocalDate  date = incidentdatdp.getValue();
      //  LocalTime time = (LocalTime) incidenttimetf.getText();
        String location =   locationCombobox.getValue();
        Location loc =  fromStringToLocation(location);
        String area = areaTypeCombobox.getValue();
        Boolean ambReq = ambulancereqCombobox.getValue();


      //  ArrayList<Alert> alertList = new ArrayList<>();
        Alert newA = new Alert(date,area,ambReq,loc);

        ObjectOutputStream oos= null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("alerts.bin"));
            while(true){
                oos.writeObject(newA);
            }
        }
        catch(IOException e){
            messageLabel.setText(" a");
        } finally{
            if (oos != null)
                oos.close();
        }

        messageLabel.setText("Your Alert has been submitted to a Dispatcher near you");

    }

    //back to the login page
    @FXML
    public void backButtonClick(ActionEvent event)  throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = FxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
