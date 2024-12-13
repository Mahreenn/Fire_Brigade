package oop.firebrigadeoperationsapp.Forensic_expert;

import oop.firebrigadeoperationsapp.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IncidentReport {
    String ID, name, description;
    LocalDate date;
    String location;

    public IncidentReport(String ID, String name, String description, LocalDate date, String location) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
    }
    private static final List<IncidentReport> incidentReports = new ArrayList<>();

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IncidentReport.bin"))) {
            while (true) {
                IncidentReport R = (IncidentReport) ois.readObject();
                incidentReports.add(R);
            }
        } catch (IOException | ClassNotFoundException ignored) {
            // End of file or no file found is acceptable during initialization
        }
    }

    public static List<IncidentReport> getIncidentReports() {return incidentReports ;}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "IncidentReport{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }


}


