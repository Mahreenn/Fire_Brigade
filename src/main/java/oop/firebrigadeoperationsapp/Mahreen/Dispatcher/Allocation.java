package oop.firebrigadeoperationsapp.Mahreen.Dispatcher;

public class Allocation {
    public int alertid;
    public int teamno;

    public Allocation(int alertid, int teamno) {
        this.alertid = alertid;
        this.teamno = teamno;
    }

    public int getAlertid() {
        return alertid;
    }

    public void setAlertid(int alertid) {
        this.alertid = alertid;
    }

    public int getTeamno() {
        return teamno;
    }

    public void setTeamno(int teamno) {
        this.teamno = teamno;
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "alertid=" + alertid +
                ", teamno=" + teamno +
                '}';
    }
}
