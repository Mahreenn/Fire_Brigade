package oop.firebrigadeoperationsapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static Employee loggedInUser = null;

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.bin"))) {
            while (true) {
                try {
                    Employee E = (Employee) ois.readObject();
                    employeeList.add(E);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading employees: " + e.getMessage());
        }
    }

    public static List<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    public static Employee checkLogIn(String username, String password) {
        for (Employee emp : employeeList) {
            if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
                loggedInUser = emp;
                return emp;
            }
        }
        return null;
    }

    public static void deleteEmployee(Employee emp) {
        employeeList.remove(emp);
        saveEmployeesToFile();
        System.out.println("Employee deleted: " + emp.getUsername());
    }

    public static void addEmployee(Employee emp) {
        employeeList.add(emp);
        saveEmployeesToFile();
        System.out.println("Employee added: " + emp.getUsername());
    }

    private static void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.bin"))) {
            for (Employee emp : employeeList) {
                oos.writeObject(emp);
            }
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }

    public static Employee getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Employee user) {
        loggedInUser = user;
    }
}
