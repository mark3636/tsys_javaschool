package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureService extends AbstractService<MedicalProcedure> {
    List<MedicalProcedure> listMedicalProcedures();
    List<MedicalProcedure> getByMedicalCase(int caseId);
    List<MedicalProcedure> filter(String patientName, Integer socialSecurityNumber, String caseNumber);
}
