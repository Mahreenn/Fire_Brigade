package oop.firebrigadeoperationsapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static Employee loggedInUser = null;

    static {
        employeeList.add(new Employee("1", "01311","user1","1234pass", LocalDate.now().minusYears(30)));
        employeeList.add(new Employee("2", "01611","user2", "123pw",LocalDate.now().minusYears(20).minusMonths(2)));
        employeeList.add(new Employee("3", "01811", "user3", "123password", LocalDate.now().minusYears(50).minusMonths(6).minusDays(20)));
    }

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
