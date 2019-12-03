package by.bsuir.wt_lab.entity;

import java.util.Objects;

/**
 * Represents university by full name, abbreviation, address, phone number
 * and a list of faculties
 *
 * @author Kseniya Pateyeva
 */
public class University extends Entity {
    /**
     * University full name string value
     */
    private String FullName;
    /**
     * University name abbreviation
     */
    private String AbbreviationName;
    /**
     * University main building address
     */
    private String Address;
    /**
     * University selection committee phone number
     */
    private String PhoneNumber;

    /**
     * Constructor without params sets default values, creates empty
     * {@code faculties} ArrayList
     */
    public University() {
    }

    /**
     * Constructor defines all string value fields
     *
     * @param fullName         university full name string value
     * @param abbreviationName university name abbreviation string value
     * @param address          university main building address string value
     * @param phoneNumber      university selection committee phone number string value
     */
    University(String fullName, String abbreviationName,
               String address, String phoneNumber) {
        FullName = fullName;
        AbbreviationName = abbreviationName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    /**
     * Sets university full name
     *
     * @param fullName university full name string value
     */
    public void setFullName(String fullName) {
        FullName = fullName;
    }

    /**
     * Gets university full name
     *
     * @return university full name string value
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * Sets university name abbreviation
     *
     * @param abbreviationName university name abbreviation string value
     */
    public void setAbbreviationName(String abbreviationName) {
        AbbreviationName = abbreviationName;
    }

    /**
     * Gets university name abbreviation
     *
     * @return university name abbreviation string value
     */
    public String getAbbreviationName() {
        return AbbreviationName;
    }

    /**
     * Sets university main building address
     *
     * @param address university main building address string value
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * Gets university main building address
     *
     * @return university main building address string value
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Sets university selection committee phone number
     *
     * @param phoneNumber university selection committee phone number string value
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    /**
     * Gets university selection committee phone number
     *
     * @return university selection committee phone number string value
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * To be equals to each other objects need to be of the same class,
     * not null value, and have the equal fields values.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(getFullName(), that.getFullName()) &&
                Objects.equals(getAbbreviationName(), that.getAbbreviationName()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getAbbreviationName(), getAddress(),
                getPhoneNumber());
    }

    /**
     * Override toString() method. Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "University [FullName=" + FullName
                + ", AbbreviationName=" + AbbreviationName
                + ", Address=" + Address
                + ", PhoneNumber=" + PhoneNumber + "]";
    }
}
