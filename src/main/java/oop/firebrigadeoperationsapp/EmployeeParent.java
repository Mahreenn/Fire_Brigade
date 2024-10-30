package oop.firebrigadeoperationsapp;

public class EmployeeParent {
    String ID, name, contact;

    public EmployeeParent() {
    }

    public EmployeeParent(String ID, String name, String contact) {
        this.ID = ID;
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
