package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

public class Emergency {
    public String description;
    public int injured;

    public Emergency(String description, int injured) {
        this.description = description;
        this.injured = injured;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getInjured() {
        return injured;
    }

    public void setInjured(int injured) {
        this.injured = injured;
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "description='" + description + '\'' +
                ", injured=" + injured +
                '}';
    }
}
