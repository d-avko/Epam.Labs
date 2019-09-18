package belavia.DataLayer.Entities;

import belavia.BusinessLogic.IPrintable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable, IPrintable {
    public Order(int id,
                 Customer customer,
                 Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo) {
        this.customer = customer;
        this.flight = flight;
        this.price = price;
        this.cargo = cargo;
        this.id = id;
        this.timePlaced = new Date();
    }

    public Order(int id,
                 Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo) {
        this.flight = flight;
        this.price = price;
        this.cargo = cargo;
        this.timePlaced = new Date();
        this.id = id;
    }

    public Order(int id,
                 Flight flight,
                 FlightPrice price) {
        this.flight = flight;
        this.price = price;
        this.id = id;
    }

    private int id;
    private Customer customer;
    private Flight flight;
    private FlightPrice price;
    private ArrayList<Cargo> cargo;
    private Date timePlaced;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public FlightPrice getPrice() {
        return price;
    }

    public void setPrice(FlightPrice price) {
        this.price = price;
    }

    public ArrayList<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Cargo> cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().getCanonicalName().equals(this.getClass().getCanonicalName())) {
            return false;
        }

        return ((Order) obj).getId() == this.getId();
    }

    public Date getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(Date timePlaced) {
        this.timePlaced = timePlaced;
    }

    @Override
    public String getPrintableMetadata() {
        StringBuilder cargo = new StringBuilder();

        if (this.cargo != null) {
            for (var stuff : this.cargo) {
                cargo.append(stuff.getPrintableMetadata());
            }
        }

        return " Id: " + this.getId() + " Customer: " +
                this.customer.getPrintableMetadata() +
                " Flight: " +
                this.flight.getPrintableMetadata() +
                " TimePlaced: " +
                this.timePlaced.toString() +
                " Customer's cargo: " +
                ((cargo.toString().equals("")) ? "Empty" : cargo.toString());
    }
}
