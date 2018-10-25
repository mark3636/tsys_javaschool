package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.Diagnosis;

import java.util.List;

public interface DiagnosisService extends AbstractService<Diagnosis> {
    /**
     * Lists all diagnoses
     * @return List of diagnoses
     */
    List<Diagnosis> listDiagnosis();

    /**
     * Returns diagnoses by their medical case
     * @param id medical case id
     * @return list of diagnoses
     */
    List<Diagnosis> getByMedicalCaseId(int id);
}
