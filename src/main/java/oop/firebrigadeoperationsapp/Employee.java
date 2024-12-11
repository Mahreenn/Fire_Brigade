package oop.firebrigadeoperationsapp;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class Employee implements Serializable {
    private String  contact,username,password;
    LocalDate dob;

   public Employee () {
   }

    public Employee( String contact, String username, String password, LocalDate dob) {
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.dob = dob;
    }

//    public String getID() {
//        return ID;
//    }

//    public void setID(String ID) {
//        this.ID = ID;
//    }

    public String getContact() {
        return contact;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Employee{" +
//                "ID='" + ID + '\'' +
                ", contact='" + contact + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public int getAge() {
        return (int) this.dob.until(LocalDate.now(),YEARS);
    }

}
