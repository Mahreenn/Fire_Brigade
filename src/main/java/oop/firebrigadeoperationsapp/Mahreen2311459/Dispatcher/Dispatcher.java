package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;


import oop.firebrigadeoperationsapp.Employee;
import oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter.Firefighter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dispatcher extends Employee implements Serializable {
    public Dispatcher() {
    }

    public Dispatcher( String contact, String username, String password, LocalDate dob) {
        super( contact, username, password, dob);
    }

    // Method to send an alert
    public void sendAlert(Alert alert) {
        System.out.println("Sending alert: " + alert);
    }

    // Method to upload an incident report
    public void generateIncidentReport() {
        // Logic to upload an incident report
    }

    // Method to generate a report
    public String generateReport(String type) {
        // Logic to generate a report based on the type
        System.out.println("Generating " + type + " report...");
        return "Report of type: " + type; // Placeholder return value
    }

    // Method to copy emergency to incident
 //   public void copyEmergencyToIncident(Emergency emergency) {
        // Logic to copy emergency details to an incident
   //     System.out.println("Emergency details copied to new incident: " + emergency);}

    // Method to allocate resources
    public void allocateResource(String resourceType) {
        // Logic to allocate resources based on the type
        System.out.println("Allocating resource: " + resourceType);
    }

    // Method to order inventory
    public void orderInventory(String inventoryType) {
        // Logic to order inventory based on type
        System.out.println("Ordering inventory: " + inventoryType);
    }

    // Method to create a budget
    public double makeBudget(double amount) {
        System.out.println("Budget created with amount: $" + amount);
        return amount;
    }

    // Method to assign teams to an incident or task
    public void assignTeams(ArrayList<Firefighter> firefighters) {
        System.out.println("Assigning teams: ");
        for (Firefighter firefighter : firefighters) {
            System.out.println("Assigned firefighter: " + firefighter);
        }
    }


}
