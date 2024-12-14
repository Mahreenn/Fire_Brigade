package oop.firebrigadeoperationsapp.Mahreen2311459.Dispatcher;

import java.util.ArrayList;

public class Inventory {
    private int amount;
    private String equipmentname;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public Inventory(int amount, String equipmentname) {
        this.amount = amount;
        this.equipmentname = equipmentname;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "amount=" + amount +
                ", equipmentname='" + equipmentname + '\'' +
                '}';
    }
    public static ArrayList<Inventory> getInventoryList() {
        ArrayList<Inventory> list = new ArrayList<>();
        list.add(new Inventory(50,"Fire Extinguisher"));
        list.add(new Inventory(30,"Ladder" ));
        list.add(new Inventory(70,"Water hosepipe"));
        return list;
    }
}
