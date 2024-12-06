package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

import oop.firebrigadeoperationsapp.Mahreen.Location;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Alert implements Serializable {
    private LocalDate dateofAlert;
    private String areaType; // e.g., Residential, Commercial,
    private Boolean ambulanceReq;
    private Location location;

    public Alert(LocalDate dateofAlert, String areaType, Boolean ambulanceReq, Location location) {
        this.dateofAlert = dateofAlert;
        this.areaType = areaType;
        this.ambulanceReq = ambulanceReq;
        this.location = location;
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
}
