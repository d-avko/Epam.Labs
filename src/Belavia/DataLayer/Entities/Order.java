package Belavia.DataLayer.Entities;

import Belavia.DataLayer.Entities.Cargo;
import Belavia.DataLayer.Entities.Customer;
import Belavia.DataLayer.Entities.Flight;
import Belavia.DataLayer.Entities.FlightPrice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    public Order(Customer customer,
                 Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo){
        this.Customer = customer;
        this.Flight = flight;
        this.Price = price;
        this.Cargo = cargo;
    }


    public Order(Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo){
        this.Flight = flight;
        this.Price = price;
        this.Cargo = cargo;
    }

    private int Id;
    private Customer Customer;
    private Flight Flight;
    private FlightPrice Price;
    private ArrayList<Cargo> Cargo;
    private Date TimePlaced;

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }

    public Flight getFlight() {
        return Flight;
    }

    public void setFlight(Flight flight) {
        Flight = flight;
    }

    public FlightPrice getPrice() {
        return Price;
    }

    public void setPrice(FlightPrice price) {
        Price = price;
    }

    public ArrayList<Cargo> getCargo() {
        return Cargo;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        Cargo = cargo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().getCanonicalName() != this.getClass().getCanonicalName()){
            return false;
        }

        return ((Order)obj).getId() == this.getId();
    }

    public Date getTimePlaced() {
        return TimePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        TimePlaced = timePlaced;
    }
}
