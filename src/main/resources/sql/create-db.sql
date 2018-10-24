CREATE SCHEMA IF NOT EXISTS Medical_institute;

USE Medical_institute;

DROP TABLE IF EXISTS Visit, Diagnosis, Medical_case, pdf_file, Patient, Medical_staff, Case_status;

CREATE TABLE IF NOT EXISTS Medical_case
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number               CHAR(10) NOT NULL UNIQUE,
	beginning_date       DATE NOT NULL,
	ending_date          DATE NULL,
	id_status            INTEGER NOT NULL,
	id_patient           INTEGER NOT NULL,
	id_medical_staff     INTEGER NOT NULL
);



CREATE TABLE IF NOT EXISTS Case_status
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name                 VARCHAR(20) NOT NULL UNIQUE,
	description          VARCHAR(200) NULL
);



CREATE TABLE IF NOT EXISTS Diagnosis
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name                 VARCHAR(100) NOT NULL,
	diagnosis_date       DATE NOT NULL,
	comment              VARCHAR(1000) NULL,
	id_medical_staff     INTEGER NOT NULL,
	id_case              INTEGER NOT NULL
);



CREATE TABLE IF NOT EXISTS Medical_staff
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name                 VARCHAR(15) NOT NULL,
	surname              VARCHAR(20) NOT NULL,
	birthday             DATE NOT NULL,
	password             VARCHAR(200) NOT NULL,
	email                VARCHAR(30) NOT NULL UNIQUE
);



CREATE TABLE IF NOT EXISTS Patient
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name                 VARCHAR(15) NOT NULL,
	surname              VARCHAR(20) NOT NULL,
	birthday             DATE NOT NULL,
	passport_details     VARCHAR(200) NOT NULL UNIQUE,
	address              VARCHAR(200) NOT NULL,
	email                VARCHAR(30) NOT NULL UNIQUE,
	phone_number         VARCHAR(20) NOT NULL UNIQUE,
	comment              VARCHAR(1000) NULL,
	social_security_number INTEGER NOT NULL UNIQUE
);



CREATE TABLE IF NOT EXISTS Visit
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	visit_date       DATE NOT NULL,
	beginning_time       TIME NOT NULL,
	ending_time          TIME NOT NULL,
	id_medical_staff     INTEGER NOT NULL,
	id_patient           INTEGER NOT NULL
);



CREATE TABLE IF NOT EXISTS pdf_file
(
	id                   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name                 VARCHAR(20) NOT NULL,
	data                 MEDIUMBLOB NOT NULL,
	id_case              INTEGER NOT NULL
);



ALTER TABLE Medical_case
ADD FOREIGN KEY CASE_CASE_STATUS_FK (id_status) REFERENCES Case_status (id);



ALTER TABLE Medical_case
ADD FOREIGN KEY CASE_PATIENT_FK (id_patient) REFERENCES Patient (id);



ALTER TABLE Medical_case
ADD FOREIGN KEY CASE_MEDICAL_STAFF_FK (id_medical_staff) REFERENCES Medical_staff (id);



ALTER TABLE Diagnosis
ADD FOREIGN KEY DIAGNOSIS_MEDICAL_STAFF_FK (id_medical_staff) REFERENCES Medical_staff (id);



ALTER TABLE Diagnosis
ADD FOREIGN KEY DIAGNOSIS_CASE_FK (id_case) REFERENCES Medical_case (id);



ALTER TABLE pdf_file
ADD FOREIGN KEY PDF_FILE_CASE_FK (id_case) REFERENCES Medical_case (id);


ALTER TABLE Visit
ADD FOREIGN KEY VISIT_MEDICAL_STAFF_FK (id_medical_staff) REFERENCES Medical_staff (id);


ALTER TABLE Visit
ADD FOREIGN KEY VISIT_PATIENT_FK (id_patient) REFERENCES Patient (id);