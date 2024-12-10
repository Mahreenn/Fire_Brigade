package oop.firebrigadeoperationsapp;

import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

import java.time.LocalDate;

public class incidentReport {
    String ID, name, description;
    LocalDate date;
    private Location location;

    public incidentReport(String name, String ID, String description, LocalDate date, Location location) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "incidentReport{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location=" + location +
                '}';
    }
}

