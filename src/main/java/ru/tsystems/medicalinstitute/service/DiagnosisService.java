package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Diagnosis;

import java.util.List;

public interface DiagnosisService extends AbstractService<Diagnosis> {
    List<Diagnosis> listDiagnosis();
    List<Diagnosis> getByMedicalCaseId(int id);
}
