package by.bsuir.wt_lab.entity;

import java.io.Serializable;

public class Entity implements Serializable {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
