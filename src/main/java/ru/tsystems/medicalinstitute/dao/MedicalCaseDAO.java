package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;

import java.util.List;

public interface MedicalCaseDAO extends AbstractDAO<MedicalCaseEntity> {
    List<MedicalCaseEntity> listMedicalCases();
    List<MedicalCaseEntity> getByPatientId(int patientId);
    List<MedicalCaseEntity> filter(String caseNumber, String patientName);
}
