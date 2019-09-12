package Belavia.DataLayer.Entities;

import Belavia.BusinessLogic.IPrintable;

import java.io.Serializable;

public class Cargo implements IPrintable, Serializable {
    public Cargo(int weight, String name){
        this.Weight = weight;
        this.Name = name;
    }

    private int Weight;
    private String Name;

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String GetPrintableMetadata() {
        return " Weight: " + Weight + " Name: " + Name;
    }

    @Override
    public String toString() {
        return GetPrintableMetadata();
    }
}
