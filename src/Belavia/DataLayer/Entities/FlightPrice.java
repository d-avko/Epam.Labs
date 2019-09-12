package Belavia.DataLayer.Entities;

import Belavia.BusinessLogic.IPrintable;

import java.io.Serializable;

public class FlightPrice implements IPrintable, Serializable {

    public FlightPrice(double euroPrice, double bynPrice, double usdPrice){
        this.UsdPrice = usdPrice;
        this.BynPrice = bynPrice;
        this.EuroPrice = euroPrice;
    }

    private double EuroPrice;
    private double BynPrice;
    private double UsdPrice;

    public double getEuroPrice() {
        return EuroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        EuroPrice = euroPrice;
    }

    public double getBynPrice() {
        return BynPrice;
    }

    public void setBynPrice(double bynPrice) {
        BynPrice = bynPrice;
    }

    public double getUsdPrice() {
        return UsdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        UsdPrice = usdPrice;
    }

    @Override
    public String toString() {
        return GetPrintableMetadata();
    }

    @Override
    public String GetPrintableMetadata() {
        return " EUR: " + EuroPrice +  " BYN: " + BynPrice + " USD: " + UsdPrice;
    }
}
