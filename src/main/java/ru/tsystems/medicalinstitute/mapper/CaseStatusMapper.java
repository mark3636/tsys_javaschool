package ru.tsystems.medicalinstitute.mapper;

import ru.tsystems.medicalinstitute.bo.CaseStatus;
import ru.tsystems.medicalinstitute.model.CaseStatusEntity;

public class CaseStatusMapper {
    public static CaseStatus toBo(CaseStatusEntity caseStatusEntity) {
        return new CaseStatus(caseStatusEntity.getId(), caseStatusEntity.getName(), caseStatusEntity.getDescription()/*, MedicalCaseMapper.toBo(caseStatusEntity.getMedicalCases())*/);
    }

    public static CaseStatusEntity toEntity(CaseStatus caseStatus) {
        CaseStatusEntity caseStatusEntity = new CaseStatusEntity();
        caseStatusEntity.setId(caseStatus.getId());
        caseStatusEntity.setName(caseStatus.getName());
        caseStatusEntity.setDescription(caseStatus.getDescription());
        //caseStatusEntity.setMedicalCases(caseStatus.getMedicalCases());

        return caseStatusEntity;
    }
}
