package by.bsuir.wt_lab.entity;

import java.util.Objects;

/**
 * Represents a faculty by full name, abbreviation, dean's office address,
 * dean's office phone number, university and a list of specialities
 *
 * @author Kseniya Pateyeva
 */
public class Faculty extends University {

    private int UniversityId;

    /**
     * Constructor without params sets default values, creates empty
     * {@code specialities} ArrayList
     */
    public Faculty() {
    }

    /**
     * Constructor defines all string value fields and university field
     *
     * @param fullName         faculty full name string value
     * @param abbreviationName faculty name abbreviation string value
     * @param address          dean's office address string value
     * @param phoneNumber      dean's office phone number string value
     * @param universityId       university id value
     */
    public Faculty(String fullName, String abbreviationName,
                   String address, String phoneNumber,
                   int universityId) {
        super(fullName, abbreviationName, address, phoneNumber);
        UniversityId = universityId;
    }

    public void setUniversityId(int universityId) {
        UniversityId = universityId;
    }

    public int getUniversityId() {
        return UniversityId;
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
        Faculty faculty = (Faculty) o;
        return Objects.equals(getId(), faculty.getId()) &&
                Objects.equals(getFullName(), faculty.getFullName()) &&
                Objects.equals(getAbbreviationName(), faculty.getAbbreviationName()) &&
                Objects.equals(getAddress(), faculty.getAddress()) &&
                Objects.equals(getPhoneNumber(), faculty.getPhoneNumber());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getAbbreviationName(),
                getAddress(), getPhoneNumber());
    }

    /**
     * Override toString() method. Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Faculty [FullName=" + getFullName()
                + ", AbbreviationName=" + getAbbreviationName()
                + ", Address=" + getAddress()
                + ", PhoneNumber=" + getPhoneNumber() + "]";
    }
}
