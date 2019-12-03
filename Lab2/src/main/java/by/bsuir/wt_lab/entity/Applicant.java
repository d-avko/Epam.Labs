package by.bsuir.wt_lab.entity;

import java.util.Objects;

/**
 * Class containing applicant's info
 *
 * @author Kseniya Pateyeva
 */
public class Applicant extends Entity implements Comparable<Applicant> {

    /**
     * Applicant's surname
     */
    private String Surname;
    /**
     * Applicant's first name
     */
    private String FirstName;

    /**
     * Applicant's mobile number
     */
    private String MobileNumber;
    /**
     * Applicant's email
     */
    private String EmailAddress;

    /**
     * Applicant's score
     */
    private int Score;
    /**
     * Applicant's class code
     */
    private int SpecialityId;

    private int ExamResultId;

    /**
     * Constructor without parameters
     */
    public Applicant() {
    }

    /**
     * Sets first name field
     *
     * @param firstName string value
     */
    public void setFirstName(String firstName) {
        FirstName=firstName;
    }

    /**
     * Gets first name string value
     *
     * @return first name string value
     */
    public String getFirstName() {
        return FirstName;
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
        Applicant that = (Applicant) o;
        return Objects.equals(FirstName, that.FirstName) &&
                Objects.equals(Surname, that.Surname) &&
                Objects.equals(MobileNumber, that.MobileNumber) &&
                Objects.equals(EmailAddress, that.EmailAddress) &&
                Objects.equals(Score, that.Score) &&
                Objects.equals(SpecialityId, that.SpecialityId);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Surname, FirstName, MobileNumber, EmailAddress, Score, SpecialityId, ExamResultId);
    }

    /**
     * Override toString() method. Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Applicant [FirstName=" + getFirstName()
                + ", Surname=" + getSurname()
                + ", MobileNumber=" + getMobileNumber()
                + ", EmailAddress=" + getEmailAddress()
                + ", Score=" + getScore()
                + ", SpecialityId=" + getSpecialityId() + "]";
    }

    /**
     * Sets surname field
     *
     * @param surname string value
     */
    public void setSurname(String surname) {
        Surname= surname;
    }

    /**
     * Gets surname string value
     *
     * @return surname string value
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * Sets mobile number field
     *
     * @param mobileNumber string value
     */
    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    /**
     * Gets mobile number string value
     *
     * @return mobile number string value
     */
    public String getMobileNumber() {
        return MobileNumber;
    }

    /**
     * Sets email address field
     *
     * @param emailAddress string value
     */
    public void setEmailAddress(String emailAddress) {
        EmailAddress  = emailAddress;
    }

    /**
     * Gets email address string value
     *
     * @return email address string value
     */
    public String getEmailAddress() {
        return EmailAddress;
    }

    /**
     * Sets score field
     */
    public void setScore(int score) {
        Score = score;
    }

    /**
     * Gets score value
     *
     * @return score value
     */
    public int getScore() {
       return Score;
    }

    public void setSpecialityId(int specialityId) {
        SpecialityId = specialityId;
    }

    public int getSpecialityId() {
        return SpecialityId;
    }

    public void setExamResultId(int examResultId) {
        ExamResultId = examResultId;
    }

    public int getExamResultId() {
        return ExamResultId;
    }

    @Override
    public int compareTo(Applicant o) {
        return this.getSurname().compareTo(o.getSurname());
    }
}
