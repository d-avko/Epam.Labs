package Belavia.DataLayer.Entities;

import Belavia.BusinessLogic.IPrintable;
import Belavia.DataLayer.Entities.AirPort;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Flight implements Comparable<Flight>, IPrintable, Serializable {
    public Flight(AirPort from, AirPort to, Date departureDate, Date arrivalDate){
        this.From = from;
        this.To = to;
        this.DepartureDate = departureDate;
        this.ArrivalDate = arrivalDate;
    }

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
        return From.compareTo(flight.getFrom());
    }

    @Override
    public String GetPrintableMetadata() {
        return " From: " + From.GetPrintableMetadata() + " To: " + To.GetPrintableMetadata()
                + " DepartureDate: " + DepartureDate.toString()
                + " ArrivalDate: " + ArrivalDate.toString();
    }

    @Override
    public String toString() {
        return GetPrintableMetadata();
    }
}
