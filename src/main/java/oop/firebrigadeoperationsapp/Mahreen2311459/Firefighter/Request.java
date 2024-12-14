package oop.firebrigadeoperationsapp.Mahreen2311459.Firefighter;

import oop.firebrigadeoperationsapp.Mahreen2311459.Location;

public class Request {
    private int firefighterTeamNO;
    private String equipement;
    private int amount;
    private Location location;

    public Request(int firefighterTeamNO, String equipement, int amount, Location location) {
        this.firefighterTeamNO = firefighterTeamNO;
        this.equipement = equipement;
        this.amount = amount;
        this.location = location;
    }

    public int getFirefighterTeamNO() {
        return firefighterTeamNO;
    }

    public void setFirefighterTeamNO(int firefighterTeamNO) {
        this.firefighterTeamNO = firefighterTeamNO;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Request{" +
                "firefighterTeamNO=" + firefighterTeamNO +
                ", equipement='" + equipement + '\'' +
                ", amount=" + amount +
                ", location=" + location +
                '}';
    }

}
