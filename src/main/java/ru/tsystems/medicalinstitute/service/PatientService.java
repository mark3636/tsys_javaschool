package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Patient;

import java.text.ParseException;
import java.util.List;

public interface PatientService extends AbstractService<Patient> {
    /**
     * Lists all patients
     * @return List of patients
     */
    List<Patient> listPatients();

    /**
     * Returns list of patients, filtered by his surname, birthday and medical case number
     * @param surname patient surname
     * @param birthday patient birthday
     * @param medicalCaseNumber patient medical case number
     * @return List of filtered patients
     * @throws ParseException If cant cast birthday to Date
     */
    List<Patient> filterPatients(String surname, String birthday, String medicalCaseNumber) throws ParseException;

    /**
     * Returns patient by his social security number
     * @param socialSecurityNumber patient social security number
     * @return Patient
     */
    Patient getBySocialSecurityNumber(int socialSecurityNumber);

    /**
     * Returns patient status
     * @param id patient id
     * @return Patient status
     */
    String getPatientStatus(int id);

    /**
     * Adds new patient and create for him initial medical case
     * @param patient new patient
     * @param medicalStaffEmail medical staff email
     */
    void addWithInitialMedicalCase(Patient patient, String medicalStaffEmail);
}
