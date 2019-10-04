package belavia.dataLayer.entities;

import belavia.businessLogic.IPrintable;

import java.io.Serializable;

public class Cargo implements IPrintable, Serializable {
    public Cargo(){

    }

    public Cargo(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    private int weight;
    private String name;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPrintableMetadata() {
        return " Weight: " + weight + " Name: " + name;
    }

    @Override
    public String toString() {
        return getPrintableMetadata();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
