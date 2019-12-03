package by.bsuir.wt_lab.parser;

import by.bsuir.wt_lab.entity.*;
import by.bsuir.wt_lab.tagEnum.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    private List<Applicant> applicantList = new ArrayList<>();
    private Applicant applicant;

    private List<ExamResult> examResultList = new ArrayList<>();
    private ExamResult examResult;

    private List<University> universityList = new ArrayList<>();
    private University university;

    private List<Faculty> facultyList = new ArrayList<>();
    private Faculty faculty;

    private List<Speciality> specialityList = new ArrayList<>();
    private Speciality speciality;

    private StringBuilder text;
    private EntityTag entityTag = EntityTag.NONE;

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public List<ExamResult> getExamResultList() {
        return examResultList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        text = new StringBuilder();
        EntityTag rootTag = EntityTag.NONE;
        try {
            rootTag = EntityTag.valueOf(qName.toUpperCase());
            entityTag = rootTag;
        } catch (IllegalArgumentException e) {
        }
        switch (rootTag) {
            case APPLICANT:
                applicant = new Applicant();
                applicant.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case EXAMRESULT:
                examResult = new ExamResult();
                examResult.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case UNIVERSITY:
                university = new University();
                university.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case FACULTY:
                faculty = new Faculty();
                faculty.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case SPECIALITY:
                speciality = new Speciality();
                speciality.setId(Integer.parseInt(attributes.getValue("id")));
                break;
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String qNameUpperCase = qName.toUpperCase();
        switch (entityTag) {
            case APPLICANT: {
                ApplicantTag applicantTag = ApplicantTag.NONE;
                try {
                    applicantTag = ApplicantTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (applicantTag) {
                    case SURNAME:
                        applicant.setSurname(text.toString());
                        break;
                    case FIRSTNAME:
                        applicant.setFirstName(text.toString());
                        break;
                    case EMAILADDRESS:
                        applicant.setEmailAddress(text.toString());
                        break;
                    case MOBILENUMBER:
                        applicant.setMobileNumber(text.toString());
                        break;
                    case SPECIALITYID:
                        applicant.setSpecialityId(Integer.parseInt(text.toString()));
                        break;
                    default:
                        applicantList.add(applicant);
                        applicant = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
            }
            break;
            case EXAMRESULT: {
                ExamResultTag examResultTag = ExamResultTag.NONE;
                try {
                    examResultTag = ExamResultTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (examResultTag) {
                    case SCHOOLCERTIFICATESCORE:
                        examResult.setSchoolCertificateScore(Integer.parseInt(text.toString()));
                        break;
                    case LANGUAGESUBJECT:
                        examResult.setLanguageSubject(ExamResult.LanguageSubject.valueOf(text.toString().toUpperCase()));
                        break;
                    case LANGUAGEEXAMSCORE:
                        examResult.setLanguageSubjectScore(Integer.parseInt(text.toString()));
                        break;
                    case FIRSTPROFILESUBJECT:
                        examResult.setFirstProfileSubject(ExamResult.ProfileSubject.valueOf(text.toString().toUpperCase()));
                        break;
                    case FIRSTPROFILESUBJECTSCORE:
                        examResult.setFirstProfileSubjectScore(Integer.parseInt(text.toString()));
                        break;
                    case SECONDPROFILESUBJECT:
                        examResult.setSecondProfileSubject(ExamResult.ProfileSubject.valueOf(text.toString().toUpperCase()));
                        break;
                    case SECONDPROFILESUBJECTSCORE:
                        examResult.setSecondProfileSubjectScore(Integer.parseInt(text.toString()));
                        break;
                    default:
                        examResultList.add(examResult);
                        examResult = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
            }
            break;
            case UNIVERSITY: {
                UniversityTag universityTag = UniversityTag.NONE;
                try {
                    universityTag = UniversityTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (universityTag) {
                    case FULLNAME:
                        university.setFullName(text.toString());
                        break;
                    case ABBREVIATIONNAME:
                        university.setAbbreviationName(text.toString());
                        break;
                    case ADDRESS:
                        university.setAddress(text.toString());
                        break;
                    case PHONENUMBER:
                        university.setPhoneNumber(text.toString());
                        break;
                    default:
                        universityList.add(university);
                        university = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
                break;
            }
            case FACULTY: {
                FacultyTag facultyTag = FacultyTag.NONE;
                try {
                    facultyTag = FacultyTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (facultyTag) {
                    case FULLNAME:
                        faculty.setFullName(text.toString());
                        break;
                    case ABBREVIATIONNAME:
                        faculty.setAbbreviationName(text.toString());
                        break;
                    case ADDRESS:
                        faculty.setAddress(text.toString());
                        break;
                    case PHONENUMBER:
                        faculty.setPhoneNumber(text.toString());
                        break;
                    case UNIVERSITYID:
                        faculty.setUniversityId(Integer.parseInt(text.toString()));
                        break;
                    default:
                        facultyList.add(faculty);
                        faculty = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
                break;
            }
            case SPECIALITY: {
                SpecialityTag specialityTag = SpecialityTag.NONE;
                try {
                    specialityTag = SpecialityTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                }
                switch (specialityTag) {
                    case FULLNAME:
                        speciality.setFullName(text.toString());
                        break;
                    case ABBREVIATIONNAME:
                        speciality.setAbbreviationName(text.toString());
                        break;
                    case SPECIALITYCODE:
                        speciality.setCode(text.toString());
                        break;
                    case FIRSTPROFILESUBJECT:
                        speciality.setFirstProfileSubject(ExamResult.ProfileSubject.valueOf(text.toString().toUpperCase()));
                        break;
                    case SECONDPROFILESUBJECT:
                        speciality.setSecondProfileSubject(ExamResult.ProfileSubject.valueOf(text.toString().toUpperCase()));
                        break;
                    case PLACECOUNT:
                        speciality.setPlaceCount(Integer.parseInt(text.toString()));
                        break;
                    case FACULTYID:
                        speciality.setFacultyId(Integer.parseInt(text.toString()));
                        break;
                    default:
                        specialityList.add(speciality);
                        speciality = null;
                        entityTag = EntityTag.NONE;
                        break;
                }
                break;
            }
        }
    }
}
