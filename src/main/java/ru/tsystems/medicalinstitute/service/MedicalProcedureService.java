package ru.tsystems.medicalinstitute.service;

import ru.tsystems.medicalinstitute.bo.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureService extends AbstractService<MedicalProcedure> {
    /**
     * Lists all medical procedures
     * @return List of medical procedures
     */
    List<MedicalProcedure> listMedicalProcedures();

    /**
     * Returns medical procedures with particular medical case id
     * @param caseId medical case id
     * @return List of medical procedures
     */
    List<MedicalProcedure> getByMedicalCase(int caseId);

    /**
     * Filters medical procedures by patient name, patient SSN and medical case number
     * @param patientName patient name
     * @param socialSecurityNumber patient SSN
     * @param caseNumber medical case number
     * @return Filtered list of medical procedures
     */
    List<MedicalProcedure> filter(String patientName, Integer socialSecurityNumber, String caseNumber);
}
