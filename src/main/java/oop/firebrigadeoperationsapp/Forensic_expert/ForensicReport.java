package oop.firebrigadeoperationsapp.Forensic_expert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ForensicReport implements Serializable {
    private String ForensicReportID, ForensicReportname, ForensicReportdescription;
    private String IncidentLocation;
    private LocalDate IncidentDate;


    public ForensicReport(String forensicReportID, String forensicReportname, String forensicReportdescription, String incidentLocation, LocalDate incidentDate) {
        ForensicReportID = forensicReportID;
        ForensicReportname = forensicReportname;
        ForensicReportdescription = forensicReportdescription;
        IncidentLocation = incidentLocation;
        IncidentDate = incidentDate;
    }

    private static final List<ForensicReport> forensicReports = new ArrayList<>();

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/oop/firebrigadeoperationsapp/Forensic_expert/ForensicReport.bin"))) {
            while (true) {
                ForensicReport R = (ForensicReport) ois.readObject();
                forensicReports.add(R);
            }
        } catch (IOException | ClassNotFoundException ignored) {
            // End of file or no file found is acceptable during initialization
        }
    }

    public static List<ForensicReport> getForensicreport() {return forensicReports ;}

    public String getForensicReportID() {
        return ForensicReportID;
    }

    public void setForensicReportID(String forensicReportID) {
        ForensicReportID = forensicReportID;
    }

    public String getForensicReportname() {
        return ForensicReportname;
    }

    public void setForensicReportname(String forensicReportname) {
        ForensicReportname = forensicReportname;
    }

    public String getForensicReportdescription() {
        return ForensicReportdescription;
    }

    public void setForensicReportdescription(String forensicReportdescription) {
        ForensicReportdescription = forensicReportdescription;
    }

    public String getIncidentLocation() {
        return IncidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        IncidentLocation = incidentLocation;
    }

    public LocalDate getIncidentDate() {
        return IncidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        IncidentDate = incidentDate;
    }

    @Override
    public String toString() {
        return "ForensicReport{" +
                "ForensicReportID='" + ForensicReportID + '\'' +
                ", ForensicReportname='" + ForensicReportname + '\'' +
                ", ForensicReportdescription='" + ForensicReportdescription + '\'' +
                ", IncidentLocation='" + IncidentLocation + '\'' +
                ", IncidentDate=" + IncidentDate +
                '}';
    }
}
