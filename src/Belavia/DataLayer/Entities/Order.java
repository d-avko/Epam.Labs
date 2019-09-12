package Belavia.DataLayer.Entities;

import Belavia.BusinessLogic.IPrintable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable, IPrintable {
    public Order(int id,
                 Customer customer,
                 Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo){
        this.Customer = customer;
        this.Flight = flight;
        this.Price = price;
        this.Cargo = cargo;
        this.Id = id;
        this.TimePlaced = new Date();
    }

    public Order(int id,
                 Flight flight,
                 FlightPrice price,
                 ArrayList<Cargo> cargo){
        this.Flight = flight;
        this.Price = price;
        this.Cargo = cargo;
        this.TimePlaced = new Date();
        this.Id = id;
    }

    public Order(int id,
                 Flight flight,
                 FlightPrice price){
        this.Flight = flight;
        this.Price = price;
        this.Id = id;
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
        if(!obj.getClass().getCanonicalName().equals(this.getClass().getCanonicalName())){
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

    @Override
    public String GetPrintableMetadata() {
        StringBuilder cargo = new StringBuilder();

        if(Cargo != null){
            for(var stuff: Cargo){
                cargo.append(stuff.GetPrintableMetadata());
            }
        }

        return  " Id: " + this.getId() + " Customer: " +
                this.Customer.GetPrintableMetadata() +
                " Flight: " +
                this.Flight.GetPrintableMetadata() +
                " TimePlaced: " +
                this.TimePlaced.toString() +
                " Customer's cargo: " +
                ((cargo.toString().equals("")) ? "Empty": cargo.toString());
    }
}
