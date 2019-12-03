package by.bsuir.wt_lab;

import by.bsuir.wt_lab.exception.DBException;
import by.bsuir.wt_lab.exception.ValidationException;
import by.bsuir.wt_lab.parser.SaxHandler;
import by.bsuir.wt_lab.service.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private final static String xmlFile = "src/main/resources/selectionCommittee.xml";
    private final static String xsdFile = "src/main/resources/selectionCommittee.xsd";

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws SAXException, IOException {

        logger.info("Start application...");

        try {
            XSDValidator.validate(new File(xmlFile), new File(xsdFile));
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return;
        }

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        SaxHandler saxHandler = new SaxHandler();
        xmlReader.setContentHandler(saxHandler);
        xmlReader.parse(new InputSource(xmlFile));

        MigrationService migrationService = MigrationService.getInstance();

        Connection connection;
        DBManager dbManager = DBManager.getInstance();
        try {
            connection = dbManager.getConnection();
            migrationService.migrateUniversities(connection, saxHandler.getUniversityList());
            migrationService.migrateFaculties(connection, saxHandler.getFacultyList());
            migrationService.migrateSpecialities(connection, saxHandler.getSpecialityList());
            migrationService.migrateApplicants(connection, saxHandler.getApplicantList());
            migrationService.migrateExamResults(connection, saxHandler.getExamResultList());
        } catch (DBException e) {
            logger.error(e.getMessage());
        }
    }
}
