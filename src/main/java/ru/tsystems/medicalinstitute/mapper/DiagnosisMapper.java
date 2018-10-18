package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.Diagnosis;
import ru.tsystems.medicalinstitute.model.DiagnosisEntity;

import java.util.HashSet;
import java.util.Set;

public class DiagnosisMapper {
    public static Diagnosis toBo(DiagnosisEntity diagnosisEntity) {
        return new Diagnosis(diagnosisEntity.getId(), diagnosisEntity.getName(), diagnosisEntity.getDiagnosisDate(), diagnosisEntity.getComment(), MedicalStaffMapper.toBo(diagnosisEntity.getMedicalStaff()), MedicalCaseMapper.toBo(diagnosisEntity.getMedicalCase()));
    }

    public static Set<Diagnosis> toBo(Set<DiagnosisEntity> entities) {
        Set<Diagnosis> set = new HashSet<>();
        for(DiagnosisEntity entity : entities) {
            set.add(toBo(entity));
        }
        return set;
    }
}
