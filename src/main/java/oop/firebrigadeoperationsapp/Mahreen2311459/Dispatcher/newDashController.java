package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import oop.firebrigadeoperationsapp.AppendableObjectOutputStream;
import oop.firebrigadeoperationsapp.HelloApplication;
import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        private AnchorPane chartPANE;

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

        //workflow 6
        @FXML
        private Label msglblw6;

        @FXML
        private BarChart<String, Number> barchart;


        //workflow 7
        @FXML
        private TextField sourcetf;

        @FXML
        private TextField desttf;

        @FXML
        private Label msglblw7;


        //workflow 8
        @FXML
        private TextArea manualtextarea;

        @FXML
        private Label msglblw8;






        @FXML
        private Label msglblw4;

        @FXML
        private Label msglblw5;



        @FXML
        private ComboBox<?> sendamountcombobox;

        @FXML
        private ComboBox<?> sendequipcombobox;



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
            chartPANE.setVisible(false);
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
            alertidcombox.getItems().addAll(1,2,3,4,5,6,7,8);
            teamNoCol.setCellValueFactory(new PropertyValueFactory<>("alertid"));
            alertidallocatedcol.setCellValueFactory(new PropertyValueFactory<>("teamno"));

            //workflow3
            alrtTC.setCellValueFactory(new PropertyValueFactory<>("alertID"));
            statTC.setCellValueFactory(new PropertyValueFactory<>("status") );

        }

       //workflow1
        @FXML
        public void viewAlertButton(ActionEvent actionEvent) throws Exception {
                viewAlertPANE.setVisible(true);
                assignTeamPANE.setVisible(false);
                updatealertstatusPANE.setVisible(false);
                viewrequestPANE.setVisible(false);
                inventoryrecordPANE.setVisible(false);
                chartPANE.setVisible(false);
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
                chartPANE.setVisible(false);
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
        chartPANE.setVisible(false);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);
    }

    ArrayList<Alert> alertList = new ArrayList<>();
    //ObservableList<Alert> alertList = FXCollections.observableArrayList();
    @FXML
    void loadalertsbutton(ActionEvent event) throws IOException {
        ObjectInputStream ois = null;
        try{ ois = new ObjectInputStream(new FileInputStream("alerts.bin"));
            statusTableview.getItems().clear();
            while(true){
                Alert a = (Alert)ois.readObject();
                alertList.add(a);
            }
        }
        catch(EOFException e){
            statusTableview.getItems().clear();
            statusTableview.getItems().addAll(alertList);
            msglblw3.setText("success");
        }
        catch(ClassNotFoundException e){
            msglblw3.setText("Invalid file format!");
        }
        catch (IOException e){
            e.printStackTrace();
            msglblw3.setText("Error");
        }
        finally {
            if (ois != null)
                ois.close();
        }
    }

    @FXML
    void updatebutton(ActionEvent event) throws IOException {
        Alert selectedalert = statusTableview.getSelectionModel().getSelectedItem();
        if (selectedalert == null){
            msglblw3.setText("make selection");
            return;
        }
        // change scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Mahreen2311459/Dispatcher/updatestatusscene.fxml"));
        Parent root = fxmlLoader.load();

        UpdatestatussceneController controller = fxmlLoader.getController();
        controller.setAlert(selectedalert);

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }


    //workflow4
    @FXML
    public void viewrequestbutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(false);
        viewrequestPANE.setVisible(true);
        inventoryrecordPANE.setVisible(false);
        chartPANE.setVisible(false);
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
        chartPANE.setVisible(false);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);

    }

    //workflow6
    @FXML
    public void inventorychartbutton(ActionEvent event) {
        viewAlertPANE.setVisible(false);
        assignTeamPANE.setVisible(false);
        updatealertstatusPANE.setVisible(false);
        viewrequestPANE.setVisible(false);
        inventoryrecordPANE.setVisible(false);
        chartPANE.setVisible(true);
        generateReportPANE.setVisible(false);
        manualPANE.setVisible(false);
    }

    public void generateChartbutton(ActionEvent event) {
        ArrayList<Inventory> inventoryList = Inventory.getInventoryList();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Equipment");
        yAxis.setLabel("Quantity");

        barchart = new BarChart<>(xAxis, yAxis);
        barchart.setTitle("Inventory Chart");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Inventory Equipments");

        for (Inventory i : inventoryList) {
            String equipment = i.getEquipmentname();
            int quantity = i.getAmount();
            series.getData().add(new XYChart.Data<>(equipment, quantity));
        }

        barchart.getData().add(series);

        chartPANE.getChildren().clear();
        chartPANE.getChildren().add(barchart);

    }



    //workflow7
        @FXML
        public void generateincidentreportbutton(ActionEvent event) {
            viewAlertPANE.setVisible(false);
            assignTeamPANE.setVisible(false);
            updatealertstatusPANE.setVisible(false);
            viewrequestPANE.setVisible(false);
            inventoryrecordPANE.setVisible(false);
            chartPANE.setVisible(false);
            generateReportPANE.setVisible(true);
            manualPANE.setVisible(false);
        }

    @FXML
    void sourcebutton(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile == null) return;
        sourcetf.setText(selectedFile.getAbsolutePath());
    }

    @FXML
    void destbutton(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fc.showSaveDialog(null);
        if (selectedFile == null) return;
        desttf.setText(selectedFile.getAbsolutePath());
    }

    @FXML
    void copybutton(ActionEvent event) throws IOException {
        String srcFilename = sourcetf.getText();
        String destFilename = desttf.getText();

        if (srcFilename.isEmpty() || destFilename.isEmpty()) {
            msglblw7.setText("Source or Destination file path is empty!");
            return;
        }

        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(srcFilename);
            fout = new FileOutputStream(destFilename, true);

            byte[] data = new byte[1024];
            Instant start = Instant.now();
            int size;

            while ((size = fin.read(data)) != -1) {
                fout.write(data, 0, size);
            }

            Instant end = Instant.now();
            long timeTaken = Duration.between(start, end).toMillis();
            msglblw7.setText("Copy Success. Time Taken: " + timeTaken + " ms");

        } catch (IOException e) {
            msglblw7.setText("Error: " + e.getMessage());
        } finally {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
        }
    }






    //workflow8
        @FXML
        public void manualbutton(ActionEvent event) {
            viewAlertPANE.setVisible(false);
            assignTeamPANE.setVisible(false);
            updatealertstatusPANE.setVisible(false);
            viewrequestPANE.setVisible(false);
            inventoryrecordPANE.setVisible(false);
            chartPANE.setVisible(false);
            generateReportPANE.setVisible(false);
            manualPANE.setVisible(true);

        }
        @FXML
        void displaymanualbutton(ActionEvent event)throws IOException {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("manual.txt"));
                String line;
                manualtextarea.clear();
                while ((line = br.readLine()) !=null) {
                    manualtextarea.appendText(line + "\n");
                }
            }
            catch(FileNotFoundException e){
                msglblw8.setText("Error: Could not open file!");
            }
            catch(IOException e) {
                msglblw8.setText("Error: Could not read from the file!");
            }
            finally {
                if (br != null)
                    br.close();
            }

        }
        @FXML
        void saveedittedmanualbuttom(ActionEvent event) throws IOException {
            msglblw8.setText("");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("manual.txt", true))) {
                String textappended = manualtextarea.getText();
                bw.append(textappended);
                bw.newLine();
                msglblw8.setText("success");
            } catch (EOFException e) {
                msglblw8.setText("File saved");
            } catch (IOException e) {
                msglblw8.setText("Error!");
            }

        }

        @FXML
        void pdfmanualbutton(ActionEvent event) throws FileNotFoundException {
            // Clear any previous messages
            msglblw8.setText("");

            // FileChooser for selecting the .txt file
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("files", "*.txt"));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile == null) {
                return;
            }
            FileChooser saveFileChooser = new FileChooser();
            saveFileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
            File saveFile = saveFileChooser.showSaveDialog(stage);
            if (saveFile == null) {
                return;
            }

            try {
                // Create the PDF writer and document
                PdfWriter writer = new PdfWriter(saveFile);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                // Read the .txt file and add each line to the PDF
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;

                // Read each line from the .txt file and add it as a paragraph to the PDF
                while ((line = reader.readLine()) != null) {
                    document.add(new Paragraph(line));  // Add each line of text as a paragraph
                }

                reader.close();  // Close the reader after reading the file
                document.close();  // Close the document to finish writing the PDF

                // Set success message with the path of the saved PDF
                msglblw8.setText("PDF created successfully at " + saveFile.getAbsolutePath());

            } catch (IOException e) {
                // In case of an error, show the error message
                msglblw8.setText("Error while creating PDF: " + e.getMessage());
            }
        }



        @FXML
        void logoutButon(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginPage.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

    }

    public void loaddatabutton(ActionEvent event) {
        // Your code to handle the event
    }


}
