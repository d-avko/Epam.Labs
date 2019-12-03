package by.bsuir.wt_lab.entity;

import java.util.Objects;

/**
 * Represents speciality by full name, abbreviation, code, places count,
 * current passing score, faculty, first CT subject, second CT subject
 * and a list of applicants
 *
 * @author Kseniya Pateyeva
 */
public class Speciality extends Entity {

    /**
     * Speciality full name string value
     */
    private String FullName;
    /**
     * Speciality name abbreviation
     */
    private String AbbreviationName;
    /**
     * Speciality code
     */
    private String Code;
    /**
     * Speciality faculty
     */
    private int FacultyId;
    /**
     * Speciality place count
     */
    private int PlaceCount;
    /**
     * Speciality first profile CT subject
     */
    private ExamResult.ProfileSubject FirstProfileSubject;
    /**
     * Speciality second profile CT subject
     */
    private ExamResult.ProfileSubject SecondProfileSubject;

    /**
     * Constructor without params sets default values, creates empty
     * {@code applicants} ArrayList
     */
    public Speciality() {
        FirstProfileSubject = ExamResult.ProfileSubject.NONE;
    }

    /**
     * Constructor defines all string and int value fields, facultyId
     * and profile subjects
     *
     * @param fullName             speciality full name string value
     * @param abbreviationName     speciality name abbreviation string value
     * @param code                 speciality code value
     * @param placeCount          speciality vacant places count value
     * @param passingScore  speciality current passing score value
     * @param facultyId              speciality facultyId object
     * @param firstProfileSubject  speciality first profile CT subject value
     * @param secondProfileSubject speciality second profile CT subject value
     */
    Speciality(String fullName, String abbreviationName, String code,
               int placeCount, int passingScore,
               int facultyId, ExamResult.ProfileSubject firstProfileSubject,
               ExamResult.ProfileSubject secondProfileSubject) {
        FullName = fullName;
        AbbreviationName = abbreviationName;
        Code = code;
        PlaceCount = placeCount;
        FacultyId = facultyId;
        FirstProfileSubject = firstProfileSubject;
        SecondProfileSubject = secondProfileSubject;
    }

    /**
     * Sets speciality full name
     *
     * @param fullName speciality full name string value
     */
    public void setFullName(String fullName) {
        FullName = fullName;
    }

    /**
     * Gets speciality full name
     *
     * @return speciality full name string value
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * Sets speciality name abbreviation
     *
     * @param abbreviationName speciality name abbreviation string value
     */
    public void setAbbreviationName(String abbreviationName) {
        AbbreviationName = abbreviationName;
    }

    /**
     * Gets speciality name abbreviation
     *
     * @return speciality name abbreviation string value
     */
    public String getAbbreviationName() {
        return AbbreviationName;
    }

    /**
     * Sets speciality code
     *
     * @param code speciality code value
     */
    public void setCode(String code) {
        Code = code;
    }

    /**
     * Gets speciality code
     *
     * @return speciality code value
     */
    public String getCode() {
        return Code;
    }

    /**
     * Sets speciality vacant places count
     *
     * @param placeCount speciality vacant places count value
     */
    public void setPlaceCount(int placeCount) {
        PlaceCount = placeCount;
    }

    /**
     * Gets speciality vacant places count
     *
     * @return speciality vacant places count value
     */
    public int getPlaceCount() {
        return PlaceCount;
    }

    /**
     * Sets speciality facultyId
     *
     * @param facultyId speciality facultyId object
     */
    public void setFacultyId(int facultyId) {
        FacultyId = facultyId;
    }

    /**
     * Gets speciality faculty
     *
     * @return speciality faculty object
     */
    public int getFacultyId() {
        return FacultyId;
    }

    /**
     * Sets speciality first profile CT subject
     *
     * @param firstProfileSubject speciality first profile CT subject value
     */
    public void setFirstProfileSubject(ExamResult.ProfileSubject firstProfileSubject) {
        FirstProfileSubject = firstProfileSubject;
    }

    /**
     * Gets speciality first profile CT subject
     *
     * @return speciality first profile CT subject value
     */
    public ExamResult.ProfileSubject getFirstProfileSubject() {
        return FirstProfileSubject;
    }

    /**
     * Sets speciality second profile CT subject
     *
     * @param secondProfileSubject speciality second profile CT subject value
     */
    public void setSecondProfileSubject(ExamResult.ProfileSubject secondProfileSubject) {
        SecondProfileSubject = secondProfileSubject;
    }

    /**
     * Gets speciality second profile CT subject
     *
     * @return speciality second profile CT subject value
     */
    public ExamResult.ProfileSubject getSecondProfileSubject() {
        return SecondProfileSubject;
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
        Speciality that = (Speciality) o;
        return getCode().equals(that.getCode()) &&
                getPlaceCount() == that.getPlaceCount() &&
                Objects.equals(getFullName(), that.getFullName()) &&
                Objects.equals(getAbbreviationName(), that.getAbbreviationName()) &&
                Objects.equals(getFacultyId(), that.getFacultyId()) &&
                getFirstProfileSubject() == that.getFirstProfileSubject() &&
                getSecondProfileSubject() == that.getSecondProfileSubject();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getAbbreviationName(), getCode(),
                getPlaceCount(), getFacultyId(),
                getFirstProfileSubject(), getSecondProfileSubject());
    }

    /**
     * Override toString() method. Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Speciality [FullName=" + FullName
                + ", AbbreviationName=" + AbbreviationName
                + ", Code=" + Code
                + ", PlaceCount=" + PlaceCount
                + ", FacultyId=" + FacultyId
                + ", FirstProfileSubject=" + FirstProfileSubject
                + ", SecondProfileSubject=" + SecondProfileSubject + "]";
    }
}
