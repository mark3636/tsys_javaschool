package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.model.PatientEntity;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    List<Patient> listPatients();
    Patient getPatientById(int id);
    void removePatient(int id);
}
