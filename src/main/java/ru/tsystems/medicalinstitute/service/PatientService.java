package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Patient;

import java.util.List;

public interface PatientService extends AbstractService<Patient> {
    List<Patient> listPatients();
}
