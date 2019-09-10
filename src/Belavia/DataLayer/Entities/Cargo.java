package Belavia.DataLayer.Entities;

public class Cargo {
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
}
