package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;


import oop.firebrigadeoperationsapp.Employee;
import oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter.Firefighter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Dispatcher extends Employee implements Serializable {

    public Dispatcher( String contact, String username, String password, LocalDate dob) {
        super( contact, username, password, dob);
    }


    public void sendAlert(Alert alert) {
        System.out.println("Sending alert: " + alert);
    }


    public String generateReport(String type) {

        System.out.println("Generating " + type + " report...");
        return "Report of type: " + type;
    }

    public void allocateResource(String resourceType) {
        System.out.println("Allocating resource: " + resourceType);
    }

    public void orderInventory(String inventoryType) {
        // Logic to order inventory based on type
        System.out.println("Ordering inventory: " + inventoryType);
    }

    public double makeBudget(double amount) {
        System.out.println("Budget created with amount: $" + amount);
        return amount;
    }

    public void assignTeams(ArrayList<Firefighter> firefighters) {
        System.out.println("Assigning teams: ");
        for (Firefighter firefighter : firefighters) {
            System.out.println("Assigned firefighter: " + firefighter);
        }
    }


}
