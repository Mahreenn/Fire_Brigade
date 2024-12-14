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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.HelloApplication;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.Allocation;
import oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher.UpdatestatussceneController;

import java.io.*;
import java.util.ArrayList;

public class FirefighterDashboardController {
    @FXML
    private Label messageLabel1;

    @FXML
    private AnchorPane respondtoAlertPANE;

    @FXML
    private AnchorPane updateEmergencyPANE;

    @FXML
    private TableColumn<Allocation, Integer> allocatedTeamTC;

    @FXML
    private TableColumn<Allocation, Integer> allocatedalertTC;

    @FXML
    private TableView<Allocation> alocationTableView;

    @FXML
    private TextField descriptiontextfield;

    @FXML
    private TextField injuredtextfeild;


    public void initialize() {
        allocatedTeamTC.setCellValueFactory(new PropertyValueFactory<>("alertid"));
        allocatedalertTC.setCellValueFactory(new PropertyValueFactory<>("teamno"));
    }

    @FXML
    void RespondtoAlertButton(ActionEvent event) {
        respondtoAlertPANE.setVisible(true);
        updateEmergencyPANE.setVisible(false);

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

   //workflow 2
    @FXML
    void updateemeregncybutton(ActionEvent event) {
        respondtoAlertPANE.setVisible(false);
        updateEmergencyPANE.setVisible(true);
    }


    @FXML
    void createoosbutton(ActionEvent event) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Allocations.bin"));
            String d = descriptiontextfield.getText();
            int injured = Integer.parseInt(injuredtextfeild.getText());

            Emergency e = new Emergency(d, injured);
            ArrayList<Emergency> emergencies = new ArrayList<>();
            emergencies.add(e);
            for (Emergency a : emergencies) {
                oos.writeObject(a);
            }
        } catch (IOException e) {
            System.out.println("io exception");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }


    }

    @FXML
    void updatebutton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mahreen2311459/Firefighter/EmergencyUpdates.fxml"));
        Parent root = fxmlLoader.load();

        UpdatestatussceneController controller = fxmlLoader.getController();
        controller.setAlert( );

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

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
    void viewcertbUTTON(ActionEvent event) {

    }

    @FXML
    void viewincidenreportButton(ActionEvent event) {

    }
}