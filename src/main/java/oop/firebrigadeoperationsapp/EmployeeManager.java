package oop.firebrigadeoperationsapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static Employee loggedInUser = null;


    public static  List<Employee> getEmployee(){
        return employeeList;
    }

    public static void deleteEmployee(Employee emp) {
        employeeList.remove(emp);
        System.out.println("Employee deleted: " + emp.getUsername());
        System.out.println("Current number of registered users: " + employeeList.size());
        System.out.println();
    }
    public static void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("User added: " + emp.getUsername());
        System.out.println("Current number of registered users: " + employeeList.size());
        System.out.println();
    }

    public static Employee getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Employee loggedInUser) {
        EmployeeManager.loggedInUser = loggedInUser;
    }

}
