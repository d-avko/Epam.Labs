package Belavia.DataLayer.Entities;

import Belavia.DataLayer.Entities.AirPort;

import java.util.Comparator;
import java.util.Date;

public class Flight implements Comparable<Flight> {
    public Flight(AirPort from, AirPort to, Date departureDate, Date arrivalDate){
        this.From = from;
        this.To = to;
        this.DepartureDate = departureDate;
        this.ArrivalDate = arrivalDate;
    }
    private int Id;
    private AirPort From;
    private AirPort To;
    private Date DepartureDate;
    private Date ArrivalDate;

    public AirPort getFrom() {
        return From;
    }

    public void setFrom(AirPort from) {
        From = from;
    }

    public AirPort getTo() {
        return To;
    }

    public void setTo(AirPort to) {
        To = to;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date departureDate) {
        DepartureDate = departureDate;
    }

    public Date getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    @Override
    public int compareTo(Flight flight) {
        return Comparator.comparing(Flight::getId)
                .compare(this, flight);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
