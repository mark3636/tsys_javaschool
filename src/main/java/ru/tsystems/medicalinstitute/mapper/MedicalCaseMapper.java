package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.MedicalCase;
import ru.tsystems.medicalinstitute.model.MedicalCaseEntity;
import ru.tsystems.medicalinstitute.model.MedicalStaffEntity;

import java.util.HashSet;
import java.util.Set;

public class MedicalCaseMapper {
    public static MedicalCase toBo(MedicalCaseEntity medicalCaseEntity) {
        return new MedicalCase(medicalCaseEntity.getId(), medicalCaseEntity.getNumber(), medicalCaseEntity.getBeginningDate(), medicalCaseEntity.getEndingDate(), CaseStatusMapper.toBo(medicalCaseEntity.getCaseStatus()), PatientMapper.toBo(medicalCaseEntity.getPatient()), MedicalStaffMapper.toBo(medicalCaseEntity.getMedicalStaff())/*, DiagnosisMapper.toBo(medicalCaseEntity.getDiagnoses()), PdfFileMapper.toBo(medicalCaseEntity.getPdfFiles()), VisitMapper.toBo(medicalCaseEntity.getVisits())*/);
    }
    public static Set<MedicalCase> toBo(Set<MedicalCaseEntity> entities) {
        Set<MedicalCase> set = new HashSet<>();
        for(MedicalCaseEntity entity : entities) {
            set.add(toBo(entity));
        }
        return set;
    }
}
