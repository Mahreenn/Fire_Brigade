package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import oop.firebrigadeoperationsapp.HelloApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class RecieveAlertfromExternalUserController {

    @FXML
    private ComboBox<Boolean> ambulancereqCombobox;

    @FXML
    private ComboBox<String> areaTypeCombobox;

    @FXML
    private ComboBox<String> locationCombobox;

    @FXML
    private TextField descriptionTf;

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
        ObjectOutputStream oos= null;
        Try{
            oos = new ObjectOutputStream(new FileOutputStream("alerts.bin"));
            while(true){

            }
        }
        catch(IOException){
            messageLabel.setText(" a");
        }
        catch(){

        }

        finally{
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
