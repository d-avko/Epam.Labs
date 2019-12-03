package belavia.dataLayer.entities;

import belavia.dataLayer.IPrintable;

import java.io.Serializable;

public class FlightPrice implements IPrintable, Serializable {
    public FlightPrice() {

    }

    public FlightPrice(double euroPrice, double bynPrice, double usdPrice) {
        this.usdPrice = usdPrice;
        this.bynPrice = bynPrice;
        this.euroPrice = euroPrice;
    }

    private int id;
    private double euroPrice;
    private double bynPrice;
    private double usdPrice;

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }

    public double getBynPrice() {
        return bynPrice;
    }

    public void setBynPrice(double bynPrice) {
        this.bynPrice = bynPrice;
    }

    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    @Override
    public String toString() {
        return getPrintableMetadata();
    }

    @Override
    public String getPrintableMetadata() {
        return " EUR: " + euroPrice + " BYN: " + bynPrice + " USD: " + usdPrice;
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
