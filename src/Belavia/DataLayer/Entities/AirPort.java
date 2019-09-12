package Belavia.DataLayer.Entities;

import Belavia.BusinessLogic.IPrintable;

import java.io.Serializable;

public class AirPort implements Comparable<AirPort>, IPrintable, Serializable {
    public AirPort(String code, String fullName){
        this.Code = code;
        this.FullName = fullName;
    }

    private String Code;
    private String FullName;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String GetPrintableMetadata() {
        return " Code: " + Code + " Fullname: " + FullName;
    }


    @Override
    public int compareTo(AirPort airPort) {
        return Code.compareTo(airPort.getCode());
    }

    @Override
    public String toString() {
        return GetPrintableMetadata();
    }
}
