package by.bsuir.wt_lab.service;

import by.bsuir.wt_lab.entity.*;
import by.bsuir.wt_lab.exception.AlreadyExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({"SqlNoDataSourceInspection", "Duplicates"})
public class MigrationService {

    private static final Logger logger = LogManager.getLogger();
    private static MigrationService instance = null;

    private MigrationService() {
    }

    public static MigrationService getInstance() {
        if (instance == null) {
            instance = new MigrationService();
            logger.info("Get migration service instance");
        }
        return instance;
    }

    private boolean isIdExist(Connection connection, String tableName, int id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE id = ?;");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        return resultSet.first();
    }


    public void migrateApplicants(Connection connection, List<Applicant> applicantList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Applicant applicant : applicantList) {
            try {
                if (isIdExist(connection, "applicants", applicant.getId()))
                    throw new AlreadyExistException("Entity with id=" + applicant.getId() + " is already exists at table applicants.");
                statement = connection.prepareStatement(
                        "INSERT INTO applicants (id, surname, firstname, mobileNumber, emailAddress, specialityId) VALUES (?,?,?,?,?,?);");
                statement.setInt(1, applicant.getId());
                statement.setString(2, applicant.getSurname());
                statement.setString(3, applicant.getFirstName());
                statement.setString(4, applicant.getMobileNumber());
                statement.setString(5, applicant.getEmailAddress());
                statement.setInt(6, applicant.getSpecialityId());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateExamResults(Connection connection, List<ExamResult> examResultList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (ExamResult examResult : examResultList) {
            try {
                if (isIdExist(connection, "examresults", examResult.getId()))
                    throw new AlreadyExistException("Entity with id=" + examResult.getId() + " is already exists at table examresults.");
                statement = connection.prepareStatement(
                        "INSERT INTO examresults (id, schoolCertificateScore, languageSubject, languageExamScore, firstProfileSubject, firstProfileSubjectScore, secondProfileSubject, secondProfileSubjectScore, applicantId) VALUES (?,?,?,?,?,?,?,?,?);");
                statement.setInt(1, examResult.getId());
                statement.setInt(2, examResult.getSchoolCertificateScore());
                statement.setString(3, examResult.getLanguageSubject().toString());
                statement.setInt(4, examResult.getLanguageSubjectScore());
                statement.setString(5, examResult.getFirstProfileSubject().toString());
                statement.setInt(6, examResult.getFirstProfileSubjectScore());
                statement.setString(7, examResult.getSecondProfileSubject().toString());
                statement.setInt(8, examResult.getSecondProfileSubjectScore());
                statement.setInt(9, examResult.getId());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateSpecialities(Connection connection, List<Speciality> specialityList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Speciality speciality : specialityList) {
            try {
                if (isIdExist(connection, "specialities", speciality.getId()))
                    throw new AlreadyExistException("Entity with id=" + speciality.getId() + " is already exists at table specialities.");
                statement = connection.prepareStatement(
                        "INSERT INTO specialities (id, fullName, abbreviationName, specialityCode, facultyId, placeCount, firstProfileSubject, secondProfileSubject) VALUES (?,?,?,?,?,?,?,?);");
                statement.setInt(1, speciality.getId());
                statement.setString(2, speciality.getFullName());
                statement.setString(3, speciality.getAbbreviationName());
                statement.setString(4, speciality.getCode());
                statement.setInt(5, speciality.getFacultyId());
                statement.setInt(6, speciality.getPlaceCount());
                statement.setString(7, speciality.getFirstProfileSubject().toString());
                statement.setString(8, speciality.getSecondProfileSubject().toString());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateFaculties(Connection connection, List<Faculty> facultyList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (Faculty faculty : facultyList) {
            try {
                if (isIdExist(connection, "faculties", faculty.getId()))
                    throw new AlreadyExistException("Entity with id=" + faculty.getId() + " is already exists at table specialities.");
                statement = connection.prepareStatement(
                        "INSERT INTO faculties (id, fullName, abbreviationName, address, phoneNumber, universityId) VALUES (?,?,?,?,?,?);");
                statement.setInt(1, faculty.getId());
                statement.setString(2, faculty.getFullName());
                statement.setString(3, faculty.getAbbreviationName());
                statement.setString(4, faculty.getAddress());
                statement.setString(5, faculty.getPhoneNumber());
                statement.setInt(6, faculty.getUniversityId());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistException e) {
                logger.error(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    public void migrateUniversities(Connection connection, List<University> universityList) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        for (University university : universityList) {
            try {
                if (isIdExist(connection, "universities", university.getId()))
                    throw new AlreadyExistException("Entity with id=" + university.getId() + " is already exists at table universities.");
                statement = connection.prepareStatement(
                        "INSERT INTO universities (id, fullName, abbreviationName, address, phoneNumber) VALUES (?,?,?,?,?);");
                statement.setInt(1, university.getId());
                statement.setString(2, university.getFullName());
                statement.setString(3, university.getAbbreviationName());
                statement.setString(4, university.getAddress());
                statement.setString(5, university.getPhoneNumber());
                statement.executeUpdate();

            } catch (SQLException | AlreadyExistException e) {
                logger.info(e.getMessage());
            } finally {
                try {
                    if (resultSet != null)
                        resultSet.close();
                    if (statement != null)
                        statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
