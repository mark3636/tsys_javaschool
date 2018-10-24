package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Patient;

import java.text.ParseException;
import java.util.List;

public interface PatientService extends AbstractService<Patient> {
    List<Patient> listPatients();
    List<Patient> filterPatients(String surname, String birthday, String medicalCaseNumber) throws ParseException;
    Patient getBySocialSecurityNumber(int socialSecurityNumber);
    String getPatientStatus(int id);
    void addWithInitialMedicalCase(Patient patient, String medicalStaffEmail);
}
