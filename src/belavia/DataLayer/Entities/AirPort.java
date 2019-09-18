package belavia.DataLayer.Entities;

import belavia.BusinessLogic.IPrintable;

import java.io.Serializable;

public class AirPort implements Comparable<AirPort>, IPrintable, Serializable {
    public AirPort(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    private String code;
    private String fullName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getPrintableMetadata() {
        return " Code: " + code + " Fullname: " + fullName;
    }


    @Override
    public int compareTo(AirPort airPort) {
        return code.compareTo(airPort.getCode());
    }

    @Override
    public String toString() {
        return getPrintableMetadata();
    }
}
