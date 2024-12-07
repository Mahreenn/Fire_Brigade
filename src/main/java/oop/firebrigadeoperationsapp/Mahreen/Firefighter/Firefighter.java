package oop.firebrigadeoperationsapp.Mahreen.Firefighter;

import oop.firebrigadeoperationsapp.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class Firefighter extends Employee implements Serializable {
    public int firefighterTeamNO;

    public Firefighter(String ID, String contact, String username, String password, LocalDate dob, int firefighterTeamNO) {
        super(ID, contact, username, password, dob);
        this.firefighterTeamNO = firefighterTeamNO;
    }

    public Firefighter(int firefighterTeamNO) {
        this.firefighterTeamNO = firefighterTeamNO;
    }

    public int getFirefighterTeamNO() {
        return firefighterTeamNO;
    }

    public void setFirefighterTeamNO(int firefighterTeamNO) {
        this.firefighterTeamNO = firefighterTeamNO;
    }

    @Override
    public String toString() {
        return "Firefighter{" +
                "firefighterTeamNO=" + firefighterTeamNO +
                '}';
    }
}
