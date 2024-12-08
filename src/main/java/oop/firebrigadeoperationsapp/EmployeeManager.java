package oop.firebrigadeoperationsapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static Employee loggedInUser = null;



    static {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("employee.bin"));
            while (true){
                Employee E = (Employee) ois.readObject();
                employeeList.add(E);
                System.out.println("Added employee: " + E.toString());
            }
        }
        catch (Exception e){}
        finally {
            if (ois != null){
                try {
                    ois.close();
                }
                catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static  List<Employee> getEmployee(){return employeeList;}

    public static Employee checkLogIn(String username, String password) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        Employee E = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("employee.bin"));
            while (true) {
                E = (Employee) ois.readObject();
                if (E.getUsername().equals(username) && E.getPassword().equals(password))
                    break;
            }
        }
        catch (IOException e){
            return null;
        }
        finally {
            if (ois != null)
                ois.close();
        }
        return E;
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
