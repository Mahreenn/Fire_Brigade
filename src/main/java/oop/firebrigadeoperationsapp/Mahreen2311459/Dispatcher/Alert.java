package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alert implements Serializable {
    private static int nextAlertID = 1;

    public int alertID;
    private LocalDate dateofAlert;
    private String areaType; // e.g., Residential, Commercial,
    private Boolean ambulanceReq;
    private Location location;
    private String status = "Pending";

    public Alert(LocalDate dateofAlert, String areaType, Boolean ambulanceReq, Location location) {
        this.alertID = nextAlertID++;
        this.dateofAlert = dateofAlert;
        this.areaType = areaType;
        this.ambulanceReq = ambulanceReq;
        this.location = location;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAlertID() {
        return alertID;
    }

    public void setAlertID(int alertID) {
        this.alertID = alertID;
    }

    public LocalDate getDateofAlert() {
        return dateofAlert;
    }

    public void setDateofAlert(LocalDate dateofAlert) {
        this.dateofAlert = dateofAlert;
    }


    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public Boolean getAmbulanceReq() {
        return ambulanceReq;
    }

    public void setAmbulanceReq(Boolean ambulanceReq) {
        this.ambulanceReq = ambulanceReq;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    static List<Alert> readAlertsFromFile() {
        List<Alert> alertsList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alerts.bin"))) {
            alertsList = (List<Alert>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return alertsList;
    }

    static void writeAlertsToFile(List<Alert> alertsList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alerts.bin"))) {
            oos.writeObject(alertsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     static Alert findAlertById(List<Alert> alertsList, int id) {
        for (Alert alert : alertsList) {
            if (alert.getAlertID() == id) {
                return alert;
            }
        }
        return null;
    }

}
