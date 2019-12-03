package by.bsuir.wt_lab.service;

import by.bsuir.wt_lab.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {

    private static final Logger logger = LogManager.getLogger();

    public static void validate(File xmlFile, File xsdFile) throws ValidationException {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            logger.info("Validation succeed.");
        } catch (IOException e) {
            logger.error("Validation failed. " + e.getMessage());
            throw new ValidationException(e.getMessage());
        } catch (SAXException e) {
            logger.error("Validation failed. " + e.getMessage());
            throw new ValidationException(xmlFile.getName() + " is NOT valid: " + e.getMessage());
        }
    }

}
