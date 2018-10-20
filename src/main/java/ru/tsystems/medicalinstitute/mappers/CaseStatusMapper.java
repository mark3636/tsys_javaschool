package ru.tsystems.medicalinstitute.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tsystems.medicalinstitute.bo.CaseStatus;
import ru.tsystems.medicalinstitute.model.CaseStatusEntity;

import java.util.List;
@Mapper(uses = {MedicalCaseMapper.class})
public interface CaseStatusMapper {
    CaseStatus toBo(CaseStatusEntity caseStatusEntity);
    CaseStatusEntity fromBo(CaseStatus caseStatus);
    List<CaseStatus> toBos(List<CaseStatusEntity> caseStatusEntities);
}
