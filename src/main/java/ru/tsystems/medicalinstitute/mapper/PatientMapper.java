package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.Patient;
import ru.tsystems.medicalinstitute.model.PatientEntity;

public class PatientMapper {
    public static Patient toBo(PatientEntity patientEntity) {
        return new Patient(patientEntity.getId(), patientEntity.getName(), patientEntity.getSurname(), patientEntity.getBirthday(), patientEntity.getPassportDetails(), patientEntity.getAddress(), patientEntity.getEmail(), patientEntity.getPhoneNumber(), patientEntity.getComment(), patientEntity.getSocialSecurityNumber(), MedicalCaseMapper.toBo(patientEntity.getMedicalCases()), VisitMapper.toBo(patientEntity.getVisits()));
    }
}
