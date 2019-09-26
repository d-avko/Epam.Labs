package belavia.dataLayer.entities;

import belavia.businessLogic.IPrintable;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Comparable<Flight>, IPrintable, Serializable {
    public Flight(){

    }

    public Flight(AirPort from, AirPort to, Date departureDate, Date arrivalDate) {
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    private AirPort from;
    private AirPort to;
    private Date departureDate;
    private Date arrivalDate;

    public AirPort getFrom() {
        return from;
    }

    public void setFrom(AirPort from) {
        this.from = from;
    }

    public AirPort getTo() {
        return to;
    }

    public void setTo(AirPort to) {
        this.to = to;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public int compareTo(Flight flight) {
        return from.compareTo(flight.getFrom());
    }

    @Override
    public String getPrintableMetadata() {
        return " From: " + from.getPrintableMetadata() + " To: " + to.getPrintableMetadata()
                + " DepartureDate: " + departureDate.toString()
                + " ArrivalDate: " + arrivalDate.toString();
    }

    @Override
    public String toString() {
        return getPrintableMetadata();
    }
}
