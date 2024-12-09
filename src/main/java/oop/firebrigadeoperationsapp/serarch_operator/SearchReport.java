package oop.firebrigadeoperationsapp.serarch_operator;

import oop.firebrigadeoperationsapp.Mahreen.Location;

import java.time.LocalDate;

public class SearchReport  {
    String ID, name, description;
    LocalDate date;
    private Location location;

    public SearchReport(String ID, String name, String description, LocalDate date, Location location) {
        this.ID = ID;
        this.name = name;
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
        return "SearchReport{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location=" + location +
                '}';
    }
}
