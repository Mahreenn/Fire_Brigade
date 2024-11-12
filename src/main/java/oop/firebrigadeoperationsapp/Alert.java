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

}
