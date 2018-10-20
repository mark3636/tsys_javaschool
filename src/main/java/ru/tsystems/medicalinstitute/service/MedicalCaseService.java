package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.MedicalCase;

import java.util.List;

public interface MedicalCaseService extends AbstractService<MedicalCase> {
    List<MedicalCase> listMedicalCases();
    List<MedicalCase> getByPatientId(int patientId);
}
