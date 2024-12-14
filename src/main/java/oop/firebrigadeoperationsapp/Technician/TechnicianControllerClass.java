package oop.firebrigadeoperationsapp.Technician;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TechnicianControllerClass {

    @FXML
    private Button TrainId;

    @FXML
    private ComboBox<String> comboId;

    @FXML
    private AnchorPane paneId;

    @FXML
    private Button readButtonId;

    @FXML
    private Button trainButtonId;

    @FXML
    private TextArea textAreaId;

    @FXML
    void initialize() {
        comboId.getItems().addAll(
                "EquipUses", "equp_update", "operational_advice", "repair_request", "training_personel"
        );
    }

    @FXML
    void OnTrainingButton(ActionEvent event) {
        String fileName = "training_personel.bin";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object content = ois.readObject();
            textAreaId.setText(content.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            textAreaId.setText("Error reading file: " + fileName);
        }
    }

    @FXML
    void OnnReadButton(ActionEvent event) {
        String selectedItem = comboId.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String fileName = selectedItem + ".bin";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Object content = ois.readObject();
                textAreaId.setText(content.toString());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                textAreaId.setText("Error reading file: " + fileName);
            }
        }
    }

    @FXML
    void OnTrainButton(ActionEvent event) {
        textAreaId.setVisible(false);
        System.out.println("Training");
    }
}