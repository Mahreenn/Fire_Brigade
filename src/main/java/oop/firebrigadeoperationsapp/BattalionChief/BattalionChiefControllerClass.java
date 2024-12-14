package oop.firebrigadeoperationsapp.BattalionChief;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BattalionChiefControllerClass {

    @FXML
    private ComboBox<String> ComboId;

    @FXML
    private Button LogOutId;

    @FXML
    private AnchorPane PaneId;

    @FXML
    private Button assignOperationButton;

    @FXML
    private Button exitOrderButton;

    @FXML
    private Button loadProgressButton;

    @FXML
    private Button resupplyRequestButton;

    @FXML
    private Button superviseId;

    @FXML
    private Button supplyId;

    @FXML
    private Button transferId;

    @FXML
    private Button updateRequestButton;

    @FXML
    private TextField messageField;

    @FXML
    private Button okButton;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Item> itemTable;

    @FXML
    private TableColumn<Item, String> itemColumn;

    @FXML
    private Button downloadButton;

    @FXML
    private TextArea textView;

    @FXML
    private Button textViewOkButton;

    @FXML
    private TextArea assignTextArea;

    @FXML
    private Button assignButton;

    @FXML
    private ComboBox<String> superviseComboBox;

    @FXML
    private TextArea superviseTextArea;

    @FXML
    private Button superviseOkButton;

    private ObservableList<Item> itemList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> transferComboBox;

    @FXML
    private Button transferButton;

    @FXML
    void OnExitButton(ActionEvent event) {
        messageField.setVisible(true);
        okButton.setVisible(true);
    }

    @FXML
    void onOkButton(ActionEvent event) {
        String message = messageField.getText();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("exitMessage.bin"))) {
            oos.writeObject(message);
            System.out.println("Message written to exitMessage.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        messageField.setVisible(false);
        okButton.setVisible(false);
    }

    @FXML
    void OnUpdatebutton(ActionEvent event) {
        StringBuilder content = new StringBuilder();
        List<String> fileNames = List.of("alerts.bin", "IncidentReport.bin", "SearchReport_sadik.bin");

        for (String fileName : fileNames) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Object obj = ois.readObject();
                content.append(obj.toString()).append("\n");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        textView.setText(content.toString());
        textView.setVisible(true);
        textViewOkButton.setVisible(true);
    }

    @FXML
    void onTextViewOkButton(ActionEvent event) {
        textView.setVisible(false);
        textViewOkButton.setVisible(false);
    }

    @FXML
    void OnprogresssButton(ActionEvent event) {

    }

    @FXML
    void OnresupplyButton(ActionEvent event) {
        ComboId.setVisible(true);
        addButton.setVisible(true);
        itemTable.setVisible(true);
        downloadButton.setVisible(true);

        ComboId.getItems().addAll(
                "Water supply", "Fire Apparatus", "Fire resistant Jacket", "Helmets",
                "Thick gloves", "Protective boots", "Lighting Equipment", "Fire extinguisher"
        );
    }

    @FXML
    void onAddButton(ActionEvent event) {
        String selectedItem = ComboId.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemList.add(new Item(selectedItem));
            itemTable.setItems(itemList);
        }
    }

    @FXML
    void onDownloadButton(ActionEvent event) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("requested_item.bin"))) {
            oos.writeObject(new ArrayList<>(itemList));
            System.out.println("Items written to requested_item.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemTable.setVisible(false);
        ComboId.setVisible(false);
        downloadButton.setVisible(false);
        addButton.setVisible(false);
    }

    @FXML
    void onAssignButton(ActionEvent event) {
        assignTextArea.setVisible(true);
        assignButton.setVisible(true);
    }

    @FXML
    void onAssignButtonClick(ActionEvent event) {
        String instruction = assignTextArea.getText();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AssignTask.bin"))) {
            oos.writeObject(instruction);
            System.out.println("Instruction written to AssignTask.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assignTextArea.setVisible(false);
        assignButton.setVisible(false);
    }

    @FXML
    void onSuperviseButton(ActionEvent event) {
        superviseComboBox.setVisible(true);
        superviseTextArea.setVisible(true);
        superviseOkButton.setVisible(true);

        superviseComboBox.getItems().setAll(
                "Technician", "Forensic expert", "Search OP", "Fire Fighter", "Dispatcher", "Training Officer"
        );
    }

    @FXML
    void onSuperviseOkButton(ActionEvent event) {
        String selectedRole = superviseComboBox.getSelectionModel().getSelectedItem();
        String text = superviseTextArea.getText();
        String fileName = selectedRole.replace(" ", "") + "Sup.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(text);
            System.out.println("Text written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        superviseComboBox.setVisible(false);
        superviseTextArea.setVisible(false);
        superviseOkButton.setVisible(false);
    }


    @FXML
    void onSupplyButton(ActionEvent event) {

    }


    @FXML
    void onTransferButton(ActionEvent event) {
        transferComboBox.setVisible(true);
        transferButton.setVisible(true);

        transferComboBox.getItems().setAll(
                "Incident.bin", "search.bin", "alert.bin"
        );
    }

    @FXML
    void onTransferButtonClick(ActionEvent event) {
        String selectedFile = transferComboBox.getSelectionModel().getSelectedItem();
        String sourceFileName = "";

        switch (selectedFile) {
            case "Incident.bin":
                sourceFileName = "IncidentReport.bin";
                break;
            case "search.bin":
                sourceFileName = "SearchReport_sadik.bin";
                break;
            case "alert.bin":
                sourceFileName = "alerts.bin";
                break;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFileName));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataCenter.bin"))) {
            Object data = ois.readObject();
            oos.writeObject(data);
            System.out.println("Data transferred to DataCenter.bin");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        transferComboBox.setVisible(false);
        transferButton.setVisible(false);
    }

    @FXML
    void OnLogOutButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oop/firebrigadeoperationsapp/LoginPage.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Item {
        private String item;

        public Item(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }
}