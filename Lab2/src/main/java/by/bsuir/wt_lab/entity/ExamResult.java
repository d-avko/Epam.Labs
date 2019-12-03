package by.bsuir.wt_lab.entity;

import java.util.Objects;

/**
 * Class represents results of all needed exams
 *
 * @author Kseniya Pateyeva
 */
public class ExamResult extends Entity {

    public enum LanguageSubject {
        NONE,
        RUSSIAN,
        BELORUSSIAN
    }

    public enum ProfileSubject {
        NONE,
        PHYSICS,
        MATHS,
        CHEMISTRY,
        BIOLOGY,
        FOREIGN_LANGUAGE,
        HISTORY_OF_BELARUS,
        SOCIAL_SCIENCE,
        GEOGRAPHY,
        WORLD_HISTORY
    }

    /**
     * School certificate score
     */
    private int SchoolCertificateScore;
    /**
     * Score of language (russian/belorussian) CT
     */
    private LanguageSubject LanguageSubject;
    private int LanguageSubjectScore;
    /**
     * Score of first profile subject CT
     */
    private ProfileSubject FirstProfileSubject;
    private int FirstProfileSubjectScore;
    /**
     * Score of second profile subject CT
     */

    private ProfileSubject SecondProfileSubject;
    private int SecondProfileSubjectScore;

    /**
     * Constructor without parameters. Set all fields a zero value
     */
    public ExamResult() {
        SchoolCertificateScore = 0;
        LanguageSubjectScore = 0;
        FirstProfileSubjectScore = 0;
        SecondProfileSubjectScore = 0;
    }

    /**
     * Constructor sets all fields with params values
     *
     * @param schoolCertificateScore    school certificate score
     * @param languageSubjectScore      score of language (russian/belorussian) CT
     * @param firstProfileSubjectScore  score of first profile subject CT
     * @param secondProfileSubjectScore score of second profile subject CT
     */
    ExamResult(int schoolCertificateScore, int languageSubjectScore, int firstProfileSubjectScore, int secondProfileSubjectScore) {
        setSchoolCertificateScore(schoolCertificateScore);
        setLanguageSubjectScore(languageSubjectScore);
        setFirstProfileSubjectScore(firstProfileSubjectScore);
        setSecondProfileSubjectScore(secondProfileSubjectScore);
    }

    /**
     * Sets school certificate score value. Checks value, if it is greater the max score value,
     * sets zero value.
     *
     * @param schoolCertificateScore score value of the school certificate value
     */
    public void setSchoolCertificateScore(int schoolCertificateScore) {
        if (schoolCertificateScore > 100) {
            SchoolCertificateScore = 0;
        } else
            SchoolCertificateScore = schoolCertificateScore;
    }

    /**
     * Gets value of SchoolCertificateScore field
     *
     * @return school certificate results score
     */
    public int getSchoolCertificateScore() {
        return SchoolCertificateScore;
    }

    public void setLanguageSubject(ExamResult.LanguageSubject languageSubject) {
        LanguageSubject = languageSubject;
    }

    public ExamResult.LanguageSubject getLanguageSubject() {
        return LanguageSubject;
    }

    /**
     * Sets second exam score value. Checks value, if it is greater the max exam score,
     * sets zero value.
     *
     * @param languageSubjectScore score value of the language (russian/belorussian) CT
     */
    public void setLanguageSubjectScore(int languageSubjectScore) {
        if (languageSubjectScore > 100) {
            LanguageSubjectScore = 0;
        } else
            LanguageSubjectScore = languageSubjectScore;
    }

    /**
     * Gets value of LanguageSubjectScore field
     *
     * @return language exam results score
     */
    public int getLanguageSubjectScore() {
        return LanguageSubjectScore;
    }

    public void setFirstProfileSubject(ProfileSubject firstProfileSubject) {
        FirstProfileSubject = firstProfileSubject;
    }

    public ProfileSubject getFirstProfileSubject() {
        return FirstProfileSubject;
    }

    /**
     * Sets first exam score value. Checks value, if it is greater the max exam score,
     * sets zero value.
     *
     * @param firstProfileSubjectScore score value of the first profile subject exam
     */
    public void setFirstProfileSubjectScore(int firstProfileSubjectScore) {
        if (firstProfileSubjectScore > 100) {
            FirstProfileSubjectScore = 0;
        } else
            FirstProfileSubjectScore = firstProfileSubjectScore;
    }

    /**
     * Gets value of FirstProfileSubjectScore field
     *
     * @return first exam results score
     */
    public int getFirstProfileSubjectScore() {
        return FirstProfileSubjectScore;
    }

    public void setSecondProfileSubject(ProfileSubject secondProfileSubject) {
        SecondProfileSubject = secondProfileSubject;
    }

    public ProfileSubject getSecondProfileSubject() {
        return SecondProfileSubject;
    }

    /**
     * Sets second exam score value. Checks value, if it is greater the max exam score,
     * sets zero value.
     *
     * @param secondProfileSubjectScore score value of the second profile subject exam
     */
    public void setSecondProfileSubjectScore(int secondProfileSubjectScore) {
        if (secondProfileSubjectScore > 100) {
            SecondProfileSubjectScore = 0;
        } else
            SecondProfileSubjectScore = secondProfileSubjectScore;
    }

    /**
     * Gets value of SecondProfileSubjectScore field
     *
     * @return second exam results score
     */
    public int getSecondProfileSubjectScore() {
        return SecondProfileSubjectScore;
    }

    /**
     * Gets total score
     *
     * @return sum of all exam's results
     */
    public int getExamScore() {
        return SchoolCertificateScore +
                LanguageSubjectScore +
                FirstProfileSubjectScore +
                SecondProfileSubjectScore;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * To be equals to each other objects need to be of the same class,
     * not null value, and have the equal fields values.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ExamResult examResult = (ExamResult) obj;
        return ((this.SchoolCertificateScore == examResult.SchoolCertificateScore) &&
                (this.LanguageSubjectScore == examResult.LanguageSubjectScore) &&
                (this.FirstProfileSubjectScore == examResult.FirstProfileSubjectScore) &&
                (this.SecondProfileSubjectScore == examResult.SecondProfileSubjectScore));
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(SchoolCertificateScore, LanguageSubjectScore, FirstProfileSubjectScore, SecondProfileSubjectScore);
    }

    /**
     * Override toString() method. Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "ExamResults [SchoolCertificateScore=" + SchoolCertificateScore
                + ", LanguageSubjectScore=" + LanguageSubjectScore
                + ", FirstProfileSubjectScore=" + FirstProfileSubjectScore
                + ", SecondProfileSubjectScore=" + SecondProfileSubjectScore + "]";
    }
}
