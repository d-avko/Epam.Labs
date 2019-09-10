package Belavia.DataLayer.Entities;

public class AirPort {
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
}
