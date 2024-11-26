package oop.firebrigadeoperationsapp;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alert {
    private LocalDate dateofAlert;
    private LocalTime timeofAlert;
    private String smalldescription;
    private String areaType; // e.g., Residential, Commercial,
    private Boolean ambulanceReq;
    private Location location;

    public Alert(LocalDate dateofAlert, LocalTime timeofAlert, String smalldescription, String areaType, Boolean ambulanceReq, Location location) {
        this.dateofAlert = dateofAlert;
        this.timeofAlert = timeofAlert;
        this.smalldescription = smalldescription;
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

    public LocalTime getTimeofAlert() {
        return timeofAlert;
    }

    public void setTimeofAlert(LocalTime timeofAlert) {
        this.timeofAlert = timeofAlert;
    }

    public String getSmalldescription() {
        return smalldescription;
    }

    public void setSmalldescription(String smalldescription) {
        this.smalldescription = smalldescription;
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
