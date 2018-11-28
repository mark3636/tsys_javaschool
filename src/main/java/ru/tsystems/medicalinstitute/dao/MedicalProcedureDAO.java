package ru.tsystems.medicalinstitute.dao;

import ru.tsystems.medicalinstitute.model.MedicalProcedureEntity;

import java.util.List;

public interface MedicalProcedureDAO extends AbstractDAO<MedicalProcedureEntity> {
    List<MedicalProcedureEntity> listMedicalProcedures();
    List<MedicalProcedureEntity> getByMedicalCase(int caseId);
    List<MedicalProcedureEntity> filter(String patientName, Integer socialSecurityNumber, String caseNumber);
}
