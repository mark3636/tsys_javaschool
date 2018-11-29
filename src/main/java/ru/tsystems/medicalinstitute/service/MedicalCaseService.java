package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.MedicalCase;

import java.util.List;

public interface MedicalCaseService extends AbstractService<MedicalCase> {
    /**
     * Lists all medical cases
     * @return List of medical cases
     */
    List<MedicalCase> listMedicalCases();

    /**
     * Returns medical cases by their patient
     * @param patientId patient id
     * @return List of medical cases
     */
    List<MedicalCase> getByPatientId(int patientId);

    List<MedicalCase> filter(String caseNumber, String patientName);
}
