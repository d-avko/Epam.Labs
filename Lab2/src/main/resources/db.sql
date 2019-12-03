CREATE DATABASE IF NOT EXISTS selection_committee;
USE selection_committee;

CREATE TABLE IF NOT EXISTS
  universities
(
  id               INT(4) PRIMARY KEY NOT NULL,
  fullName         VARCHAR(255)       NOT NULL,
  abbreviationName VARCHAR(50),
  address          VARCHAR(255),
  phoneNumber      VARCHAR(12)
);
CREATE TABLE IF NOT EXISTS
  faculties
(
  id               INT(4) PRIMARY KEY NOT NULL,
  fullName         VARCHAR(255),
  abbreviationName VARCHAR(50),
  address          VARCHAR(255),
  phoneNumber      VARCHAR(12),
  universityId     INT(4),
  FOREIGN KEY (universityId) REFERENCES universities (id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS
  specialities
(
  id                   INT(4) PRIMARY KEY NOT NULL,
  fullName             VARCHAR(255),
  abbreviationName     VARCHAR(50),
  specialityCode       VARCHAR(8),
  facultyId            INT(4),
  placeCount           INT(4),
  firstProfileSubject  VARCHAR(20),
  secondProfileSubject VARCHAR(20),
  FOREIGN KEY (facultyId) REFERENCES faculties (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS
  applicants
(
  id           INT(4) PRIMARY KEY NOT NULL,
  surname      VARCHAR(255)       NOT NULL,
  firstName    VARCHAR(255)       NOT NULL,
  mobileNumber VARCHAR(14),
  emailAddress VARCHAR(255),
  specialityId INT(4),
  FOREIGN KEY (specialityId) REFERENCES specialities (id) ON DELETE RESTRICT

);
CREATE TABLE IF NOT EXISTS
  examResults
(
  id                        INT(4) PRIMARY KEY NOT NULL,
  schoolCertificateScore    INT(1),
  languageSubject           VARCHAR(11),
  languageExamScore         INT(1),
  firstProfileSubject       VARCHAR(20),
  firstProfileSubjectScore  INT(1),
  secondProfileSubject      VARCHAR(20),
  secondProfileSubjectScore VARCHAR(20),
  applicantId               INT(4),
  FOREIGN KEY (applicantId) REFERENCES applicants (id) ON DELETE CASCADE
);